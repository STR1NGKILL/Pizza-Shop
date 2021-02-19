package org.reallume.model.pizza;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasePizza implements Pizza {

    private int id;
    private String name = "Обычная пицца";
    private double price = 120D;

    public BasePizza(int id){
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
