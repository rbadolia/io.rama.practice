package in.rama.practise.array;

import java.util.ArrayList;
import java.util.List;

public class PrintWise {
    public String solution(int A, int B) {
        // write your code in Java SE 8
        return print(A, 'a', B, 'b');
    }

    private String print(int A, char a, int B, char b) {
        if (A == 0 || B == 0) {
            return "";
        }

        List<Character> charList = new ArrayList<>();

        if (A < B) {
            return print(B, b, A, a);
        }

        int count = 0;
        int aCount = 0;
        int bCount = 0;
        char[] result = new char[A + B];
        int index = 0;
        while (aCount < A && bCount < B) {
            if (count < 2) {
                result[index] = a;
                index++;
                aCount++;
                count++;
            } else {
                result[index] = b;
                index++;
                bCount++;
                count = 0;
            }
        }
        while (aCount < A) {
            result[index] = a;
            index++;
            aCount++;
        }
        while (bCount < B) {
            result[index] = b;
            index++;
            bCount++;
        }

        return new String(result);
    }
}
