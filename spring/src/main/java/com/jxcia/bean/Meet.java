package com.jxcia.bean;

public class Meet {
    private  Integer id;
    private String breed;
    private  Double price;

    public Meet() {
    }

    @Override
    public String toString() {
        return "Meet{" +
                "id=" + id +
                ", breed='" + breed + '\'' +
                ", price=" + price +
                '}';
    }

    public Meet(Integer id, String breed, Double price) {
        this.id = id;
        this.breed = breed;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
