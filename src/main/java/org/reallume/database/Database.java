package org.reallume.database;

import java.util.ArrayList;

public class Database<T> implements VirtualDatabase<T>{

    private Long availableId = -1L;

    private ArrayList<T> elements;

    public Database(){
        this.elements = new ArrayList<>();
    }

    @Override
    public ArrayList<T> getData() {
        return this.elements;
    }

    @Override
    public Long generatorAutoId() {
        this.availableId += 1L;
        return this.availableId;
    }

}
