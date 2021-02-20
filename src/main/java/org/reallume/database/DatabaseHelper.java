package org.reallume.database;

public class DatabaseHelper<T> implements DatabaseAccessAdapter<T>{

    private final Database<T> database;

    public DatabaseHelper(Database<T> database) {
        this.database = database;
    }

    @Override
    public void addItem(T item) throws Exception {
        Long id = database.generatorAutoId();
        database.getConnection().put(id, item);
    }

    @Override
    public T getItemById(Long id) throws Exception {
        return database.getConnection().get(id);
    }

    @Override
    public void removeItemById(Long id) throws Exception {
        database.getConnection().remove(id);
    }

    @Override
    public void removeAll() throws Exception {
        database.getConnection().clear();
    }
}
