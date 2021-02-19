package org.reallume.controller;

import org.reallume.Initializer;
import org.reallume.model.extra.*;
import org.reallume.model.pizza.BasePizza;
import org.reallume.model.pizza.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@Controller
public class MainController {

    private static Logger LOGGER = Logger.getLogger("InfoLogging");

    @GetMapping(value = "/main")
    public String mainPage(Model model) throws Exception {

        List<Pizza> pizzas = new ArrayList<>();

        Initializer.initializePizza(Initializer.PIZZA_BASE_ID);
        pizzas.add(Initializer.getPizzaInstance());
        LOGGER.info(Initializer.getPizzaInstance().getName() + " " + Initializer.getPizzaInstance().getPrice() + " " + Initializer.getPizzaInstance().getId());

        Initializer.initializePizza(Initializer.PIZZA_BACON_ID);
        pizzas.add(Initializer.getPizzaInstance());
        LOGGER.info(Initializer.getPizzaInstance().getName() + " " + Initializer.getPizzaInstance().getPrice() + " " + Initializer.getPizzaInstance().getId());

        Initializer.initializePizza(Initializer.PIZZA_CHICKEN_ID);
        pizzas.add(Initializer.getPizzaInstance());
        LOGGER.info(Initializer.getPizzaInstance().getName() + " " + Initializer.getPizzaInstance().getPrice() + " " + Initializer.getPizzaInstance().getId());

        Initializer.initializePizza(Initializer.PIZZA_CHICKEN_TOMATO_ID);
        pizzas.add(Initializer.getPizzaInstance());
        LOGGER.info(Initializer.getPizzaInstance().getName() + " " + Initializer.getPizzaInstance().getPrice() + " " + Initializer.getPizzaInstance().getId());

        Initializer.initializePizza(Initializer.PIZZA_CHICKEN_TOMATO_MUSHROOM_SAUSAGE_ID);
        pizzas.add(Initializer.getPizzaInstance());
        LOGGER.info(Initializer.getPizzaInstance().getName() + " " + Initializer.getPizzaInstance().getPrice() + " " + Initializer.getPizzaInstance().getId());

        model.addAttribute("pizzas", pizzas);

        return "index";
    }

}
