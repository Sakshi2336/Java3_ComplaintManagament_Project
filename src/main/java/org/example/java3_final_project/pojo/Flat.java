package org.example.java3_final_project.pojo;

public class Flat {

    private String flat_num;
    private String description;
    private int hall;
    private int bath;
    private int kitchen;

    public Flat(String flat_num, String description, int hall, int bath, int kitchen) {
        this.flat_num = flat_num;
        this.description = description;
        this.hall = hall;
        this.bath = bath;
        this.kitchen = kitchen;
    }

    public String getFlat_num() {
        return flat_num;
    }

    public void setFlat_num(String flat_num) {
        this.flat_num = flat_num;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHall() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }

    public int getBath() {
        return bath;
    }

    public void setBath(int bath) {
        this.bath = bath;
    }

    public int getKitchen() {
        return kitchen;
    }

    public void setKitchen(int kitchen) {
        this.kitchen = kitchen;
    }

    public String toString(){
        return flat_num;
    }
}
