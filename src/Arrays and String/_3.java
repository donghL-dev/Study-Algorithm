package com.donghun.coding_interview.Ch_01;

import java.io.*;
import java.util.StringTokenizer;

// URL화
public class _3 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = in.readLine();

        StringTokenizer token = new StringTokenizer(str, ",");

        str = token.nextToken().replaceAll(" ", "%20");

        out.write(str);
        out.flush();
        out.close();
    }
}
