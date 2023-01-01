package com.part1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public static void printTopThree(){
        System.out.println(elfList.get(elfList.size() - 1).getTotalCalories());
        System.out.println(elfList.get(elfList.size() - 2).getTotalCalories());
        System.out.println(elfList.get(elfList.size() - 3).getTotalCalories());
        System.out.println("SUM: " +
                (elfList.get(elfList.size() - 1).getTotalCalories() +
                elfList.get(elfList.size() - 2).getTotalCalories() +
                elfList.get(elfList.size() - 3).getTotalCalories())
        );
    }

    public static void printAllElfs(){
        for (Elf eachElf: elfList){
            System.out.println(eachElf.getTotalCalories());
        }
    }
    public static void sortCalorie(){
        List<Elf> list = elfList.stream().
                sorted(Comparator.comparing(Elf::getTotalCalories)).
                collect(Collectors.toList()
                );

        elfList = (ArrayList<Elf>) list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Elf elf = (Elf) o;
        return totalCalories == elf.totalCalories && elfNumber == elf.elfNumber && Objects.equals(calorieList, elf.calorieList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalCalories, calorieList, elfNumber);
    }
}
