package com.ghassan;

public class Utilities {

    //Returns a char array contains every nth char, when sourceArray.length < n, returns sourceArray
    public char[] everyNthChar(char[] sourceArray, int n){
        if (sourceArray == null || sourceArray.length < n ){
            return sourceArray;
        }
        int returnedLenght = sourceArray.length / n;
        char[] result = new char[returnedLenght];
        int index = 0;

        for (int i = n-1; i < sourceArray.length ; i +=n) {
            result[index++] = sourceArray[i];
        }
        return result;
    }

    //Remove pairs of the char that are next ot each other, by removing on a occurrence of the character
    //ABBCDEEF -> ABCDEF
    public String removePairs(String source){
        //if length is less than 2 there is no pairs
        if (source.length() < 2){
            return source;
        }
        StringBuilder sb = new StringBuilder();
        char[] string = source.toCharArray();
        for (int i = 0; i < string.length -1 ; i++) {
            if (string[i] != string[i+1]){
                sb.append(string[i]);
            }
        }
        sb.append(string[string.length -1]);
        return sb.toString();
    }

    //Perform a conversion based on some internal business rule
    public int converter(int a, int b){
        return (a/b) + (a* 30)-2;
    }

    public String nullIfOddLength(String source){
        if (source.length() % 2 == 0){
            return source;
        }
        return null;
    }
}
