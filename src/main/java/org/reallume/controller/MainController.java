package org.reallume.controller;

import org.reallume.database.Database;
import org.reallume.database.DatabaseAccessCart;
import org.reallume.database.DatabaseAccessPizza;
import org.reallume.model.cart.Cart;
import org.reallume.model.cart.CommonCart;
import org.reallume.model.order.Order;
import org.reallume.model.order.PizzaOrder;
import org.reallume.model.pizza.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class MainController {

    public static final String INCR_MODE_ORDER = "INCR_MODE_ORDER";
    public static final String INCR_MODE_CART = "INCR_MODE_CART";

    DatabaseAccessPizza databaseAccessPizza = new DatabaseAccessPizza(new Database<>()).getInstance();
    DatabaseAccessCart databaseAccessCart = new DatabaseAccessCart(new Database<>()).getInstance();

    private static Cart cart;

    private static Long orderId = 0L;
    private static Long cartId = 0L;

    //класс-обёртка, чтобы добавить метод comparePizzaId в модель
    private static class comparePizzaId{

        //сравнивает id товара из каталога с id товара заказа из корзины. Если есть совпадение, возвращает true, иначе false
        public static Boolean compare(Integer id) {
            if(cart != null)
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
        PizzaOrder order = new PizzaOrder(generateAutoId(INCR_MODE_ORDER), 1, pizza);
        if(cart == null)
            cart = new CommonCart(generateAutoId(INCR_MODE_CART));
        cart.addOrder(order);
        return "redirect:/main";
    }


    @GetMapping(value = "/cart")
    public String openCartPage(Model model) {
        if(cart == null)
            cart = new CommonCart(generateAutoId(INCR_MODE_CART));
        model.addAttribute("cart", cart);
        return "cart";
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
        if(cart != null)
            cart.removeAll();
        model.addAttribute("cart", cart);
        return "redirect:/cart";
    }

    @GetMapping(value = "/cart/order-it")
    public String makeOrder() throws Exception {
        if(cart != null)
            if(!cart.getOrders().isEmpty()){
                databaseAccessCart.addItem(cart);
                cart = null;
            }
        return "redirect:/cart";
    }


    @GetMapping(value = "/orders")
    public String openOrdersPage(Model model) throws Exception {
        model.addAttribute("carts", databaseAccessCart.getAll());
        return "complete_orders";
    }


    public Long generateAutoId(String mode) {
        switch (mode) {
            case INCR_MODE_ORDER:
                orderId += 1L;
                return orderId;
            case INCR_MODE_CART:
                cartId += 1L;
                return cartId;
            default:
                return null;
        }
    }

}
