package org.reallume.database;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;


@NoArgsConstructor
public class Database<T> implements VirtualDatabase<T>{

    private Long availableId = -1L;

    private Map<Long,T> pizzas;

    private Map<Long,T> connection;


    @Override
    public void create() {
        pizzas = new HashMap<>();
    }

    @Override
    public void connect() {
        connection = pizzas;
    }

    @Override
    public void disconnect() {
        connection = null;
    }

    @Override
    public Map<Long, T> getConnection() throws Exception {
        if(connection == null)
            throw new Exception("Error! Access to the disconnected database");
        else
            pizzas.clear();
        return connection;
    }

    @Override
    public Long generatorAutoId() {
        this.availableId += 1L;
        return this.availableId;
    }

}
