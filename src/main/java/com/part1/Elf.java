package com.part1;

import java.util.ArrayList;

public class Elf {

    private int totalCalories;
    private ArrayList<Integer> calorieList;
    public static ArrayList<Elf> elfList = new ArrayList<>();

    public static int elfCount = 0;

    private int elfNumber;
    public Elf(){
        elfNumber = elfCount;
        elfCount++;
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
    public int getElfNumber(){
        return elfNumber;
    }
    public void printAll(){
        for (int eachCal: calorieList){
            System.out.println(eachCal);
        }
    }


    //static method
    public static void printHighest(){
        if (elfList.size() == 1){
            System.out.println(elfList.get(0));
        }else {
            Elf checkElf = elfList.get(0);
            for (int i = 1; i < elfList.size(); i++){
                if (elfList.get(i).getTotalCalories() > checkElf.getTotalCalories()){
                    checkElf = elfList.get(i);
                }
            }
            System.out.println(checkElf.getElfNumber() + ":" + checkElf.getTotalCalories());
        }
    }
}
