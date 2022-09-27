package com.test;

import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;

public class Main {

    private static ArrayList<String> nArray = new ArrayList<>();
    private static ArrayList<String> mArray = new ArrayList<>();
    private static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) {

        getTwoArrayFromString(TestString.INPUT);

        printArray(nArray);
        printArray(mArray);
        System.out.println("RESULT: -> ");
        deleteEmptyElements(nArray);
        deleteEmptyElements(mArray);
        compareArray(nArray, mArray);
        printArray(result);


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

    public static void getTwoArrayFromString(String string){
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

    public static void printArray(ArrayList<String> arrayList){

        for (String s:arrayList) {
            System.out.println(s);
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
        for (String s: first) {
            String temp = "\n";
            temp += s+":";
            for (String ss: second) {
                if (compareStrings(s, ss)){
                    temp = temp+ss;
                }
            }
            result.add(temp);

        }
    }

    public static boolean compareStrings(String first, String second){
        if (StringUtils.contains(first, second)){
            return true;
        }
        return false;
    }


}