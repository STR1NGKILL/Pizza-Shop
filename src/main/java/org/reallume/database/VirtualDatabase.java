package org.reallume.database;

import java.util.ArrayList;

public interface VirtualDatabase<T> {

    ArrayList<T> getData();

    Long generateAutoId();

}
