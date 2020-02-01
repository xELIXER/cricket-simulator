package com.tekion.Cricket.util;

public class MathUtil {
    public static boolean toss(){
        return (int) (Math.random() * 2) == 0;
    }
    private static int findCeil(int[] elementsToSelectFrom, int random, int low, int high){
        int mid;
        while (low < high)
        {
            mid = low + ((high - low) >> 1); // Same as mid = (l+h)/2
            if(random > elementsToSelectFrom[mid]){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return (elementsToSelectFrom[low] >= random) ? low : -1;
    }

    public static int generateScore(int rating){
        int[] elementsToSelectFrom = {-1,0,1,2,3,4,5,6};
        int n = 8;
        int[] prefix = new int[n];
        int[] probabilities = new int[]{5, 30, 20, 18, 15, 8, 1, 3};
        for(int i = 1; i <=  rating; i++){
            probabilities[i] += 5;
        }
        int sum = 0;
        for (Integer x : probabilities) {
            sum += x;
        }
        int i;
        prefix[0] = probabilities[0];
        for (i = 1; i < n; ++i) {
            prefix[i]  = prefix[i - 1] + probabilities[i];
        }
        int random = (int) (Math.random() * sum) + 1;
        int index = findCeil(prefix, random, 0, 7);
        return elementsToSelectFrom[index];
    }
}
