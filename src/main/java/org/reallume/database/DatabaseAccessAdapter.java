package org.reallume.database;

public interface DatabaseAccessAdapter<T> {

    void addItem(T item) throws Exception;

    T getItemById(Long id) throws Exception;

    void removeItemById(Long id) throws Exception;

    void removeAll() throws Exception;

}
