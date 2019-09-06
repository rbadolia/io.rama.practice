package in.rama.practise.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindNumberOfSlices {
    //{2, 4, 1, 6, 5, 9, 7}
    public int solution(int[] A) {
        //create a sorted copy of the given array
        int[] sorted = Arrays.copyOf(A, A.length);
        Arrays.sort(sorted);
        List<List<Integer>> slices = new ArrayList<>();
        int totalElementAdded = 0;
        for (int i = 0; i < A.length;) {
            List<Integer> slice = new ArrayList<>();
            for (;i < A.length; i++) {
                slice.add(A[i]);
                if (A[i] == sorted[totalElementAdded]) {
                    slices.add(slice);
                    totalElementAdded=totalElementAdded + slice.size();
                    ++i;
                    break;
                }
            }
        }
        if (totalElementAdded == A.length) {
            return slices.size();
        } else {
            return -1;
        }
    }
}
