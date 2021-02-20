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

    private Integer id;
    private String name = "Обычная пицца";
    private Double price = 120D;

    public BasePizza(Integer id){
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
