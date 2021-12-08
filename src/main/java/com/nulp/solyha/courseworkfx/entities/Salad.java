package com.nulp.solyha.courseworkfx.entities;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Salad {
    private String name;
    private double weight;
    private List<Vegetable> vegetables;

    private static Salad instance = null;
    public static Salad getInstance() {
        if (instance == null) {
            instance = new Salad();
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        double weight = 0;

        Iterator<Vegetable> itr = vegetables.iterator();
        while (itr.hasNext()) {
            Vegetable veg = (Vegetable) itr.next();
            weight += veg.getWeight();
        }
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List<Vegetable> getVegetables() {
        return vegetables;
    }

    public void setVegetables(List<Vegetable> vegetables) {
        this.vegetables = vegetables;
    }

    public void addVegetable(Vegetable vegetable) {
        this.vegetables.add(vegetable);
    }


    public double getCalorificCapacity(){
        double calorificCapacity = 0;

        Iterator<Vegetable> itr = vegetables.iterator();
        while (itr.hasNext()) {
            Vegetable veg = (Vegetable) itr.next();
            calorificCapacity += veg.getCalorificCapacity();
        }
        return calorificCapacity;
    }

    public void sortByCarbs() {
        Collections.sort(vegetables, new Comparator() {
            public int compare(Object o1, Object o2) {
                Double x1 = ((Vegetable) o1).getCarbs();
                Double x2 = ((Vegetable) o2).getCarbs();

                int sComp = x1.compareTo(x2);
                if (sComp != 0) {
                    return sComp;
                }

                x1 = ((Vegetable) o1).getCarbs();
                x2 = ((Vegetable) o2).getCarbs();

                return x1.compareTo(x2);
            }
        });
    }

    public List<Vegetable> findByCalCapacity(double min, double max){
        List<Vegetable> found_vegetables = null;
        for(Vegetable v : vegetables) {
            if(v.getCalorificCapacity() >= min && v.getCalorificCapacity() <= max) {
                found_vegetables.add(v);
            }
        }
        return found_vegetables;
    }

    public void flush(){
        this.name = null;
        this.weight = 0.0;
        this.vegetables = null;
        System.out.println("Salad data flushed!");
    }
}