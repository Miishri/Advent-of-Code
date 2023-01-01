package com.part1;

import java.util.ArrayList;

public class Elf {

    private int totalCalories;
    private ArrayList<Integer> calorieList;
    public static ArrayList<Elf> elfList = new ArrayList<>();

    public Elf(){
        totalCalories = 0;
        calorieList = new ArrayList();
        elfList.add(this);
    }
    public void addCalories(int calories) {
        calorieList.add(calories);
        totalCalories += calories;
    }
    public int getTotalCalories(){
        return totalCalories;
    }
    public void printAll(){
        for (int eachCal: calorieList){
            System.out.println(eachCal);
        }
    }

    public void printHighest(){
        if (elfList.size() == 1){
            System.out.println(elfList.get(0));
        }else {
            Elf checkElf = this;
            for (int i = 0; i < elfList.size(); i++){
                if (elfList.get(i).totalCalories > checkElf.totalCalories){
                    checkElf = elfList.get(i);
                }
            }
            checkElf.printAll();
        }
    }
}
