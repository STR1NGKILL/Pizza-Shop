package org.reallume.controller;

import lombok.NoArgsConstructor;
import org.reallume.database.Database;
import org.reallume.database.DatabaseAccessPizza;
import org.reallume.model.cart.Cart;
import org.reallume.model.cart.CommonCart;
import org.reallume.model.order.Order;
import org.reallume.model.order.PizzaOrder;
import org.reallume.model.pizza.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {

    DatabaseAccessPizza databaseAccessPizza = new DatabaseAccessPizza(new Database<>()).getInstance();
    private static Cart cart = new CommonCart();
    private static Long orderId = 0L;

    //класс-обёртка, чтобы добавить метод comparePizzaId в модель
    private static class comparePizzaId{

        //сравнивает id товара из каталога с id товара заказа из корзины. Если есть совпадение, возвращает true, иначе false
        public static Boolean compare(Integer id) {
            for (Order order:cart.getOrders())
                if(order.getProduct().getId().equals(id))
                    return true;

            return false;
        }
    }

    @GetMapping(value = "/main")
    public String mainPage(Model model) throws Exception {
        model.addAttribute("pizzas", databaseAccessPizza.getAll());
        model.addAttribute("comparePizzaId", new comparePizzaId());
        return "index";
    }


    @GetMapping(value = "/catalog/{pizza_id}/addOrder")
    public String addOrder(@PathVariable Integer pizza_id) throws Exception {
        Pizza pizza = databaseAccessPizza.getItemById(pizza_id);
        PizzaOrder order = new PizzaOrder(generateAutoId(), 1, pizza);
        cart.addOrder(order);
        return "redirect:/main";
    }


    @GetMapping(value = "/cart")
    public String openCartPage(Model model) {
        model.addAttribute("cart", cart);
        return "cart";
    }


    @PostMapping(value = "/cart")
    public String cartPage(@ModelAttribute CommonCart newCart) {
        cart = new CommonCart();
        return "redirect:/main";
    }


    @GetMapping(value = "/cart/orders/{order_id}/quantity/up")
    public String increaseQuantity(@PathVariable Long order_id, Model model) {
        for (Order order:cart.getOrders()) {
            if(order.getId().equals(order_id))
                order.setQuantity(order.getQuantity() + 1);
        }
        model.addAttribute("cart", cart);
        return "redirect:/cart";
    }


    @GetMapping(value = "/cart/orders/{order_id}/quantity/down")
    public String decreaseQuantity(@PathVariable Long order_id, Model model) {
        for (Order order:cart.getOrders()) {
            if(order.getId().equals(order_id))
                if(order.getQuantity() - 1 != 0)
                    order.setQuantity(order.getQuantity() - 1);
        }
        model.addAttribute("cart", cart);
        return "redirect:/cart";
    }


    @GetMapping(value = "/cart/orders/{order_id}/remove")
    public String removeOrder(@PathVariable Long order_id, Model model) {
        cart.removeOrderById(order_id);
        model.addAttribute("cart", cart);
        return "redirect:/cart";
    }


    @GetMapping(value = "/cart/clear")
    public String clearCart(Model model) {
        cart.removeAll();
        model.addAttribute("cart", cart);
        return "redirect:/cart";
    }

    @GetMapping(value = "/cart/order-it")
    public String makeOrder(Model model) {
        if(!cart.getOrders().isEmpty()){
            //пока пусто
        }
        return "redirect:/cart";
    }


    public Long generateAutoId() {
        this.orderId += 1L;
        return this.orderId;
    }

}
