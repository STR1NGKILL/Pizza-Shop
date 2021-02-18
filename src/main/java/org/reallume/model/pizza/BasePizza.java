package org.reallume.model.pizza;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasePizza implements Pizza {

    private String name = "Обычная пицца";
    private Double price = 120D;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getPrice() {
        return null;
    }
}
