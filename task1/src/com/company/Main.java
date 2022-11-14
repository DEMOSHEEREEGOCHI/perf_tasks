package com.company;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        String path = "1";
        int cursor = 1;

        while(true)
        {
            int c = (cursor - 1 + m) % n;
            if (c == 0) {
                c = n;
            }
            if (c == 1) {
                break;
            }
            cursor = c;
            path += cursor;

        }

        System.out.println(path);
    }
}
