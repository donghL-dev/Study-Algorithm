package com.donghun.coding_interview.Ch_01;

import java.io.*;

// 중복이 없는가?
// test input : "abcde", "hello", "apple", "kite", "padle"
public class Is_Unique {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = in.readLine();

        answer1(str, out);
    }
    private static void answer1(String str, BufferedWriter out) throws IOException {
        int[] chararr = new int[128];
        boolean status = true;

        for(int i=0; i<str.length(); i++) {
            chararr[(int)(str.charAt(i))]++;
            if(chararr[(int)(str.charAt(i))] > 1) {
                status = false;
                break;
            }
        }

        out.write(status + "\n");
        out.flush();
        out.close();
    }
}
