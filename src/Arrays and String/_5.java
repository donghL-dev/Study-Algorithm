package com.donghun.coding_interview.Ch_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(in.readLine());

        String str1 = token.nextToken();
        String str2 = token.nextToken();

        System.out.println(compare(str1, str2));
    }
    private static boolean compare(String str1, String str2) {
        if(Math.abs(str1.length() - str2.length()) > 1)
            return false;

        String s1 = str1.length() > str2.length() ? str2 : str1; // 짧은 놈
        String s2 = str1.length() > str2.length() ? str1 : str2; // 긴 놈

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;

        while(index2 < s2.length() && index1 < s1.length()) {
            if(s1.charAt(index1) != s2.charAt(index2)) {
                if(foundDifference) return false;
                foundDifference = true;
                if(s1.length() == s2.length())
                    index1++;
            }
            else {
                index1++;
            }
            index2++;
        }
        return true;
    }
}
