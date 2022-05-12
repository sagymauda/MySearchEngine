package com.example.MySearchEngine.utils;

import org.springframework.stereotype.Component;

@Component
public class Utils {

    public static Boolean checkForUnwantedWords(String word) {

        if (word.equalsIgnoreCase("is") || word.equalsIgnoreCase("for") ||
                word.equalsIgnoreCase("an") ||
                word.equalsIgnoreCase("in") ||
                word.equalsIgnoreCase("and") ||
                word.equalsIgnoreCase("if") ||
                word.equalsIgnoreCase("at")||
                word.equalsIgnoreCase("his")||
                word.equalsIgnoreCase("of")) {

            return false;
        }
        return true;
    }
    public static String  changeWordToLowerCase(String word) {
      return   word.toLowerCase();
    }
}