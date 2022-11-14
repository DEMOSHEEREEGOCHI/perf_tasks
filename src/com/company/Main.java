package com.company;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(args[0]);

        int n = sc.nextInt();
        int m = sc.nextInt();
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
