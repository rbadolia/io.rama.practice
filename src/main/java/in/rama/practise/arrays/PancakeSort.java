package in.rama.practise.arrays;

public class PancakeSort {
    public int[] pancakeSort(int[] arr) {
        for(int i = arr.length -1; i >= 0; i--){
            int maxIndex = findMaxElementIndex(arr, i);
            flip(arr, maxIndex);
            flip(arr, i);
        }

        return arr;
    }

    private int findMaxElementIndex(int[] arr, int n){
        int maxIndex = 0;
        for(int i=0; i <= n; i++){
            if(arr[i] > arr[maxIndex]){
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    private void flip(int[] arr, int k){
        if(k == 0){
            return;
        }

        int firstIndex = 0;
        int lastIndex = k;

        while(firstIndex < lastIndex){
            int first = arr[firstIndex];
            int last = arr[lastIndex];
            arr[firstIndex] = last;
            arr[lastIndex]= first;
            firstIndex++;
            lastIndex--;
        }
    }
}
