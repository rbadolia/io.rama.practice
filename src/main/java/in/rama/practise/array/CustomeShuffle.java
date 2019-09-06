package in.rama.practise.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomeShuffle {
    public int solution(int num) {
        if (num == 0) {
            return 0;
        }

        String strNum = String.valueOf(num);
        char[] numArray = strNum.toCharArray();
        List<Character> shuffledList = new ArrayList<>();

        if (numArray.length % 2 == 0) {
            for (int i = 0, j = numArray.length - 1; i < numArray.length - 1 && j > 0; i++, j--) {
                shuffledList.add(numArray[i]);
                shuffledList.add(numArray[j]);
                if (shuffledList.size() == numArray.length) {
                    break;
                }
            }
        } else {
            for (int i = 0, j = numArray.length - 1; i < numArray.length - 1 && j > 0; i++, j--) {
                shuffledList.add(numArray[i]);
                shuffledList.add(numArray[j]);
                if (shuffledList.size() == numArray.length - 1) {
                    break;
                }
            }

            int midIndex = numArray.length / 2;

            shuffledList.add(numArray[midIndex]);
        }

        String result = shuffledList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        int shuffledInt = Integer.parseInt(result);

        System.out.println(shuffledInt);

        return shuffledInt;
    }
}
