package org.reallume.database;

import java.util.Map;

public interface VirtualDatabase<T> {

    void create();

    void connect();

    void disconnect();

    Map<Long, T> getConnection() throws Exception;

    Long generatorAutoId();




}
