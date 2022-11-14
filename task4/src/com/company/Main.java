package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) throws IOException {
        Path array = Path.of(args[0]);
        String arrStr = Files.readString(array);
        Scanner sc = new Scanner(arrStr);
        int count = 0;
        int result = 0;
        ArrayList<Integer> a = new ArrayList<Integer>();
        while(sc.hasNext()) {
            a.add(sc.nextInt());
            count++;
        }
        Collections.sort(a);

        //Здесь мы получаем медианное число, т.е. такое, для которого половина значений массива будет меньше,
        // а половина больше. Поскольку деление происходит нацело,
        // мы добавляем единицу. Так для нечетных n медиана
        //будет достигнута (9/2=4, 4+1=5, медиана 5), а для чётных n инкремент (+1)
        // будет несущественным (8/2=4, 4+1=5,медианы 4 и 5)
        int median = a.get(count/2);

        for (int i = 0; i < count; i++) {
            result+=abs(a.get(i)-median);
        }
        System.out.println(result);

    }
}

