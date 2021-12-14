package com.nulp.solyha.courseworkfx.entities;

public class Salad {
    private int id;
    private String name;
    private double weight;

    public Salad() {
    }

    public Salad(String name){
        this.name = name;
        this.weight = 0.0;
    }

    public Salad(int id, String name, double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getIdString(){
        return Integer.toString(id);
    }

    public String getWeightString(){
        return Double.toString(weight);
    }
}