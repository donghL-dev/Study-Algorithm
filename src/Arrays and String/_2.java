package com.donghun.coding_interview.Ch_01;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


// 순열 확인
public class _2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String str1 = in.readLine();
        String str2 = in.readLine();

        System.out.println(answer(str1, str2));
    }
    private static boolean answer(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;

        Map<Character, Character> map = new HashMap<>();

        for(int i=0; i<str1.length(); i++) {
            map.put(str1.charAt(i), str1.charAt(i));
        }

        for(int i=0; i<str2.length(); i++) {
            if(map.get(str2.charAt(i)) == null)
                return false;
        }

        return true;
    }
}
