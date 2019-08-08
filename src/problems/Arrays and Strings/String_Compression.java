package com.donghun.coding_interview.Ch_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자열 압축
public class String_Compression {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();

        System.out.println(compression(input));
    }
    private static String compression(String str) {
        StringBuilder builder = new StringBuilder();

        int count = 1;
        builder.append(str.charAt(0));

        for(int i=1; i<str.length(); i++) {
            if(str.charAt(i) == str.charAt(i-1)) {
                count++;
            }
            else {
                builder.append(count);
                count = 1;
                builder.append(str.charAt(i));
            }

            if(i == str.length()-1)
                builder.append(count);
        }

        return builder.toString().length() > str.length() ? str : builder.toString();
    }
}
