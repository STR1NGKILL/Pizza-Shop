package org.reallume.controller;

import org.reallume.model.extra.Bacon;
import org.reallume.model.extra.Chicken;
import org.reallume.model.pizza.BasePizza;
import org.reallume.model.pizza.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;


@Controller
public class MainController {

    private static Logger LOGGER = Logger.getLogger("InfoLogging");

    @GetMapping(value = "/main")
    public String mainPage(){

        Pizza pizza = new Bacon(new BasePizza());
        LOGGER.info(pizza.getName() + " " + pizza.getPrice());
        pizza = new Chicken(new BasePizza());
        LOGGER.info(pizza.getName() + " " + pizza.getPrice());
        pizza = new Chicken(new Bacon(new BasePizza()));
        LOGGER.info(pizza.getName() + " " + pizza.getPrice());


        return "index";
    }

}
