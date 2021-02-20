package org.reallume.database;

public interface DatabaseAccessAdapter {

    void open();

    void close();

    DatabaseAccessAdapter getInstance();

}

