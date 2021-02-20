package org.reallume.database;

import org.reallume.model.pizza.Pizza;

import java.util.ArrayList;

public class DatabaseAccessPizza implements DatabaseAccessAdapter{

    private final Database<Pizza> database;
    private ArrayList<Pizza> databaseData;
    private static DatabaseAccessPizza instance;

    public DatabaseAccessPizza(Database<Pizza> database) {
        this.database = database;
    }

    @Override
    public void open() {
        this.databaseData = database.getData();
    }

    @Override
    public void close() {
        this.databaseData = null;
    }

    @Override
    public DatabaseAccessPizza getInstance() {
        if(DatabaseAccessPizza.instance == null) {
            DatabaseAccessPizza.instance = new DatabaseAccessPizza(database);
            return DatabaseAccessPizza.instance;
        }
        return DatabaseAccessPizza.instance;
    }


    public void addItem(Pizza item) throws Exception {
        if(databaseData == null)
            throw new Exception("Error! Access to the disconnected database");
        else {
            Long id = database.generatorAutoId();
            databaseData.add(item);
        }
    }


    public Pizza getItemById(Integer id) throws Exception {
        if(databaseData == null)
            throw new Exception("Error! Access to the disconnected database");

        for (Pizza pizza:databaseData) {
            if(pizza.getId().equals(id))
                return pizza;
        }
        return null;
    }


    public void removeItemById(Integer id) throws Exception {
        if(databaseData == null)
            throw new Exception("Error! Access to the disconnected database");
        databaseData.removeIf(pizza -> pizza.getId().equals(id));
    }


    public void removeAll() throws Exception {
        if(databaseData == null)
            throw new Exception("Error! Access to the disconnected database");
        databaseData.clear();
    }


    public ArrayList<Pizza> getAll() throws Exception {
        if(databaseData == null)
            throw new Exception("Error! Access to the disconnected database");
        return (ArrayList<Pizza>) databaseData.clone();
    }

}
