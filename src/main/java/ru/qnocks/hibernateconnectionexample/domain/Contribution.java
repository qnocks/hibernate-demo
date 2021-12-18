package ru.qnocks.hibernateconnectionexample.domain;

public class Contribution {

    private Long id;

    private String name;

    private String desc;

    private Integer price;

    private String date;

    public Contribution() {
    }

    public Contribution(Long id, String name, String desc, Integer price, String date) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
