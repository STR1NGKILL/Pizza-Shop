package org.reallume.controller;

import org.reallume.database.Database;
import org.reallume.database.DatabaseAccessPizza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping(value = "/main")
    public String mainPage(Model model) throws Exception {

        DatabaseAccessPizza databaseAccessPizza = new DatabaseAccessPizza(new Database<>()).getInstance();
        databaseAccessPizza.open();

        model.addAttribute("pizzas", databaseAccessPizza.getAll());

        //Initializer.initializeOrder(Initializer.ORDER_PIZZA_TYPE_ID, 0L, 1, Initializer.getPizzaInstance().getId(),  Initializer.getPizzaInstance().getPrice());
        //LOGGER.info(Initializer.getOrderInstance().getId() + " " + Initializer.getOrderInstance().getQuantity() + " " + Initializer.getOrderInstance().getProductId() + " " + Initializer.getOrderInstance().getCost());

        return "index";
    }

}
