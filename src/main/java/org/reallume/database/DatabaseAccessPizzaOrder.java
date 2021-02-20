package org.reallume.database;

import org.reallume.model.order.Order;
import org.reallume.model.order.PizzaOrder;

import java.util.ArrayList;

public class DatabaseAccessPizzaOrder implements DatabaseAccessAdapter{

    private final Database<PizzaOrder> database;
    private ArrayList<PizzaOrder> databaseData;
    private static DatabaseAccessPizzaOrder instance;

    public DatabaseAccessPizzaOrder(Database<PizzaOrder> database) {
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
    public DatabaseAccessPizzaOrder getInstance() {
        if(DatabaseAccessPizzaOrder.instance == null) {
            DatabaseAccessPizzaOrder.instance = new DatabaseAccessPizzaOrder(database);
            return DatabaseAccessPizzaOrder.instance;
        }
        return DatabaseAccessPizzaOrder.instance;
    }


    public void addItem(PizzaOrder item) throws Exception {
        if(databaseData == null)
            throw new Exception("Error! Access to the disconnected database");
        else {
            Long id = database.generatorAutoId();
            databaseData.add(item);
        }
    }


    public Order getItemById(Long id) throws Exception {
        if(databaseData == null)
            throw new Exception("Error! Access to the disconnected database");

        for (PizzaOrder order:databaseData) {
            if(order.getId().equals(id))
                return order;
        }
        return null;
    }


    public void removeItemById(Long id) throws Exception {
        if(databaseData == null)
            throw new Exception("Error! Access to the disconnected database");
        databaseData.removeIf(order -> order.getId().equals(id));
    }


    public void removeAll() throws Exception {
        if(databaseData == null)
            throw new Exception("Error! Access to the disconnected database");
        databaseData.clear();
    }


    public ArrayList<PizzaOrder> getAll() throws Exception {
        if(databaseData == null)
            throw new Exception("Error! Access to the disconnected database");
        return (ArrayList<PizzaOrder>) databaseData.clone();
    }

}
