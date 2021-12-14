package com.nulp.solyha.courseworkfx.entities;

public class Vegetable {
    private int id;
    private int saladId;
    private String name;
    private String color;
    private double weight;
    private double calCapPerHundGram;
    private double proteins, fats, carbs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSaladId() {
        return saladId;
    }

    public void setSaladId(int saladId) {
        this.saladId = saladId;
    }

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

    public double getCarbs() {return carbs;}

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

    public Vegetable(int id, int saladId, String name, String color, double weight, double calCapPerHundGram, double proteins, double fats, double carbs) {
        this.id = id;
        this.saladId = saladId;
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.calCapPerHundGram = calCapPerHundGram;
        this.proteins = proteins;
        this.fats = fats;
        this.carbs = carbs;
    }

    public String getStringId(){
        return Integer.toString(this.id);
    }

    public String getStringSaladId(){
        return Integer.toString(saladId);
    }

    public String getStringWeight() {
        return Double.toString(weight);
    }

    public String getStringCalCap() {
        return Double.toString(calCapPerHundGram);
    }
    public String getStringProteins() {
        return Double.toString(proteins);
    }
    public String getStringFats() {
        return Double.toString(fats);
    }
    public String getStringCarbs() {
        return Double.toString(carbs);
    }
}

