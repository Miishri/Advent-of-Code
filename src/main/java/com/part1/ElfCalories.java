package com.part1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ElfCalories {
    public static void main(String[] args) {


        try {
            File puzzleFile = new File("puzzle.txt");
            Scanner myReader = new Scanner(puzzleFile);
            ArrayList <Integer> elfList = new ArrayList<>();

            while (myReader.hasNextLine()){
                String puzzleValue = myReader.nextLine();

                if (puzzleValue.equals("")){
                    Elf elf = new Elf();

                    for (int value: elfList){
                        elf.addCalories(value);
                    }
                    elfList.clear();

                }else {

                    Integer puzzleV = Integer.valueOf(puzzleValue);
                    elfList.add(puzzleV);

                }
            }
        } catch (Exception e) {
            System.out.println("File not found or doesn't exist: " + e);
        }

        Elf.sortCalorie();
        Elf.printTopThree();
    }
}
