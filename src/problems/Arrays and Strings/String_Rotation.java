package com.donghun.coding_interview.Ch_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class String_Rotation {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(in.readLine());

        String s1 = token.nextToken();
        String s2 = token.nextToken();

        System.out.println(isSubstring(s1, s2));
        System.out.println(isRotation(s1, s2));
    }
    private static boolean isRotation(String s1, String s2) {
        int len = s1.length();

        // s1과 s2의 길이가 같고 빈 문자열이 아닌지 확인한다.
        if(len == s2.length() && len > 0) {
            // s1과 s2를 합친 결과를 새로운 버퍼에 저장한다.
            String s1s1 = s1 + s1;
            return isSubstring2(s1s1, s2);
        }
        return false;
    }
    private static boolean isSubstring2(String s1, String s2) {
        if(s1.contains(s2))
            return true;
        else
            return false;
    }
    private static boolean isSubstring(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        return new String(ch1).equals(new String(ch2));
    }
}
