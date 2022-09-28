package com.test;


import java.io.*;
import java.util.ArrayList;

public class Main {

    private static ArrayList<String> nArray = new ArrayList<>();
    private static ArrayList<String> mArray = new ArrayList<>();
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {

        getTwoArrayFromFile(readFile("input.txt"));

        compareArray(nArray, mArray);

        writeFile(result.toString());

    }


    public static boolean isDigitString(String string){
        int value;
        if (string == null || string.equals("")){
            return false;
        }

        try {
            value = Integer.parseInt(string);
            return true;
        }catch (NumberFormatException e){

        }
        return false;
    }

    public static void getTwoArrayFromFile(String string){
        String[] strings = string.split("\n");

        int count = 0;

        for (String s:strings) {
            if (isDigitString(s)){
                count++;
            }
            if (count == 1){
                nArray.add(s);
            }
            if (count == 2){
                mArray.add(s);
            }
        }
    }


    public static void deleteEmptyElements(ArrayList<String> arrayList){
        arrayList.remove(0);
        for(int i = 0; i < arrayList.size(); i++){
            if (arrayList.get(i).equals("")){
                arrayList.remove(i);
            }
        }
    }

    public static void compareArray(ArrayList<String> first, ArrayList<String> second){
        deleteEmptyElements(first);
        deleteEmptyElements(second);
        for (String s: first) {
            String temp = "\n";
            temp += s+":";
            for (String ss: second) {
                if (compareStrings(s, ss)){
                    temp = temp+ss;
                }
            }
            result.append(temp);

        }
    }

    public static boolean compareStrings(String first, String second){
        String[] firstArray = first.split(" ");
        String[] secondArray = second.split(" ");
        for (String s: firstArray) {
            for (String ss:secondArray) {
                if (s.contains(ss)){
                    return true;
                }
            }
        }

        return false;
    }

    public static String readFile(String fileName){
        String file = "";

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            file = sb.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return file;
    }

    public static void writeFile(String output){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write(output);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}