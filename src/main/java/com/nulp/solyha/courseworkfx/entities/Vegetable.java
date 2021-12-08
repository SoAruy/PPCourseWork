package com.nulp.solyha.courseworkfx.entities;

public class Vegetable {
    private String name;
    private String color;
    private double weight;
    private double calCapPerHundGram;
    private double proteins, fats, carbs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCalCapPerHundGram() {
        return calCapPerHundGram;
    }

    public void setCalCapPerHundGram(double calCapPerHundGram) {
        this.calCapPerHundGram = calCapPerHundGram;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public Vegetable(String name, String color, double weight, double calCapPerHundGram, double proteins, double fats, double carbs) {
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.calCapPerHundGram = calCapPerHundGram;
        this.proteins = proteins;
        this.fats = fats;
        this.carbs = carbs;
    }

    public double getCalorificCapacity(){
        return weight * calCapPerHundGram;
    }
}

