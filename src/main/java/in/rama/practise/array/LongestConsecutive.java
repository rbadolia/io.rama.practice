package in.rama.practise.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutive {
    public static int longestConsecutive1(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        Map<Integer, Integer> map = new HashMap();
        Set<Integer> visitedSet = new HashSet();
        for(int i = 0; i < nums.length; i++){
            map.putIfAbsent(nums[i], 1);
        }

        for(int key : map.keySet()){
            if(visitedSet.contains(key)){
                continue;
            }
            int valuePlus1 = key + 1;
            int valueMinus1 = key - 1;

            while(map.containsKey(valueMinus1)){
                visitedSet.add(valueMinus1);
                map.replace(key, map.get(key) + 1);
                valueMinus1 = valueMinus1 - 1;
            }

            while(map.containsKey(valuePlus1)){
                visitedSet.add(valuePlus1);
                map.replace(key, map.get(key) + 1);
                valuePlus1 = valuePlus1 + 1;
            }
        }

        int maxConsecutiveSequenceLength = 1;
        for(int key : map.keySet()){
            int length = map.get(key);
            if(length > maxConsecutiveSequenceLength){
                maxConsecutiveSequenceLength = length;
            }
        }

        return maxConsecutiveSequenceLength;
    }

    public static int longestConsecutive2(int arr[],int n)
    {
        HashSet<Integer> S = new HashSet<>();
        int ans = 0;

        // Hash all the array elements
        for (int i=0; i<n; ++i)
            S.add(arr[i]);

        // check each possible sequence from the start
        // then update optimal length
        for (int i=0; i<n; ++i)
        {
            // if current element is the starting
            // element of a sequence
            if (!S.contains(arr[i]-1))
            {
                // Then check for next elements in the
                // sequence
                int j = arr[i];
                while (S.contains(j))
                    j++;

                // update  optimal length if this length
                // is more
                if (ans<j-arr[i])
                    ans = j-arr[i];
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = {0,0,-1};
        int maxConsecutiveSequenceLength = LongestConsecutive.longestConsecutive2(nums, 3);
        System.out.println(maxConsecutiveSequenceLength);
    }
}
