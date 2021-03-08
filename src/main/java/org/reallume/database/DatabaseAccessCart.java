package org.reallume.database;

import org.reallume.model.cart.Cart;

import java.util.ArrayList;

public class DatabaseAccessCart implements DatabaseAccessAdapter{

    private final Database<Cart> database;
    private ArrayList<Cart> databaseData;
    private static DatabaseAccessCart instance;

    public DatabaseAccessCart(Database<Cart> database) {
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
    public DatabaseAccessCart getInstance() {
        if(DatabaseAccessCart.instance == null) {
            DatabaseAccessCart.instance = new DatabaseAccessCart(database);
            return DatabaseAccessCart.instance;
        }
        return DatabaseAccessCart.instance;
    }


    public void addItem(Cart item) throws Exception {
        if(databaseData == null)
            throw new Exception("Error! Access to the disconnected database");
        else {
            databaseData.add(item);
        }
    }


    public Cart getItemById(Integer id) throws Exception {
        if(databaseData == null)
            throw new Exception("Error! Access to the disconnected database");

        for (Cart cart:databaseData) {
            if(cart.getId().equals(id))
                return cart;
        }
        return null;
    }


    public void removeItemById(Integer id) throws Exception {
        if(databaseData == null)
            throw new Exception("Error! Access to the disconnected database");
        databaseData.removeIf(cart -> cart.getId().equals(id));
    }


    public void removeAll() throws Exception {
        if(databaseData == null)
            throw new Exception("Error! Access to the disconnected database");
        databaseData.clear();
    }


    public ArrayList<Cart> getAll() throws Exception {
        if(databaseData == null)
            throw new Exception("Error! Access to the disconnected database");
        return (ArrayList<Cart>) databaseData.clone();
    }

}