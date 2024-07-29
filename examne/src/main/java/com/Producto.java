package com;

public class Producto {
    private String id;
    private String name;
    private String category;
    private double price;
    private double rate;

    public Producto(String id, String name, String category, double price, double rate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.rate = rate;
    }


public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}


public String getCategory() {
    return category;
}

public void setCategory(String category) {
    this.category = category;
}


public double getPrice() {
    return price;
}

public void setPrice(double price) {
    this.price = price;
}


public double getRate() {
    return rate;
}

public void setRate(double rate) {
    this.rate = rate;
}

}
