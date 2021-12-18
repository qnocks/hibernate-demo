package ru.qnocks.hibernateconnectionexample.domain;

import java.math.BigDecimal;

public class Garden {

    private Long id;

    private String number;

    private Integer area;

    private Long cost;

    public Garden() {
    }

    public Garden(Long id, String number, Integer area, Long cost) {
        this.id = id;
        this.number = number;
        this.area = area;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }
}
