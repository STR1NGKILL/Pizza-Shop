package org.reallume;

import org.reallume.database.Database;
import org.reallume.database.DatabaseAccessCart;
import org.reallume.database.DatabaseAccessPizza;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class Application {

    private static Logger LOGGER = Logger.getLogger("InfoLogging");

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        createPizzaDatabase();
        createCartDatabase();
    }

    private static void createPizzaDatabase() throws Exception {
        DatabaseAccessPizza databaseAccessPizza = new DatabaseAccessPizza(new Database<>()).getInstance();
        databaseAccessPizza.open();

        Initializer.initializePizza(Initializer.PIZZA_BASE_ID);
        LOGGER.info(Initializer.getPizzaInstance().getName() + " " + Initializer.getPizzaInstance().getPrice() + " " + Initializer.getPizzaInstance().getId());
        databaseAccessPizza.addItem(Initializer.getPizzaInstance());

        Initializer.initializePizza(Initializer.PIZZA_CHICKEN_ID);
        LOGGER.info(Initializer.getPizzaInstance().getName() + " " + Initializer.getPizzaInstance().getPrice() + " " + Initializer.getPizzaInstance().getId());
        databaseAccessPizza.addItem(Initializer.getPizzaInstance());

        Initializer.initializePizza(Initializer.PIZZA_CHICKEN_TOMATO_ID);
        LOGGER.info(Initializer.getPizzaInstance().getName() + " " + Initializer.getPizzaInstance().getPrice() + " " + Initializer.getPizzaInstance().getId());
        databaseAccessPizza.addItem(Initializer.getPizzaInstance());

        Initializer.initializePizza(Initializer.PIZZA_CHICKEN_TOMATO_MUSHROOM_SAUSAGE_ID);
        LOGGER.info(Initializer.getPizzaInstance().getName() + " " + Initializer.getPizzaInstance().getPrice() + " " + Initializer.getPizzaInstance().getId());
        databaseAccessPizza.addItem(Initializer.getPizzaInstance());

        Initializer.initializePizza(Initializer.PIZZA_BACON_ID);
        LOGGER.info(Initializer.getPizzaInstance().getName() + " " + Initializer.getPizzaInstance().getPrice() + " " + Initializer.getPizzaInstance().getId());
        databaseAccessPizza.addItem(Initializer.getPizzaInstance());

    }

    private static void createCartDatabase() {
        DatabaseAccessCart databaseAccessCart = new DatabaseAccessCart(new Database<>()).getInstance();
        databaseAccessCart.open();
    }

}
