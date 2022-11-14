package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) throws IOException {
        Path circle = Path.of(args[0]);
        Path points = Path.of(args[1]);
        String circList = Files.readString(circle);
        String pointList = Files.readString(points);
        Scanner sc = new Scanner(circList);

        double cirX = Double.parseDouble(sc.next());
        double cirY = Double.parseDouble(sc.next());
        double rad =  Double.parseDouble(sc.next());

        Scanner psc = new Scanner(pointList);

        while (psc.hasNext()) {
            double pX = Double.parseDouble(psc.next());
            double pY = Double.parseDouble(psc.next());
            if (Math.pow(abs(cirX-pX),2)+Math.pow(abs(cirY-pY),2)>rad*rad) System.out.println(2);
            if (Math.pow(abs(cirX-pX),2)+Math.pow(abs(cirY-pY),2)<rad*rad) System.out.println(1);
            if (Math.pow(abs(cirX-pX),2)+Math.pow(abs(cirY-pY),2)==rad*rad) System.out.println(0);


        }



    }
}
