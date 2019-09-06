package in.rama.practise.array;

import java.util.HashMap;
import java.util.Map;

public class UniqueCombinations {
    public int solution(int N) {
        String strNum = String.valueOf(N);
        char[] numArray = strNum.toCharArray();
        int combinationsWithDuplicates = factorial(numArray.length);

        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < numArray.length; i++) {
            char key = numArray[i];
            if (charMap.containsKey(key)) {
                charMap.computeIfPresent(key, (k, v) -> v + 1);
            } else {
                charMap.put(key, 1);
            }
        }

        int duplicateTotal = 1;

        for (Character key : charMap.keySet()) {
            int repeats = charMap.get(key);
            if (repeats > 1) {
                if (key == '0') {
                    combinationsWithDuplicates = combinationsWithDuplicates - repeats * numArray.length + 1;
                } else {
                    duplicateTotal = duplicateTotal + factorial(repeats);
                }
            }
        }

        return combinationsWithDuplicates / duplicateTotal;
    }

    private static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++)
            fact = fact * i;
        return fact;
    }
}

