package com.tekion.Cricket.util;

public class GenerateRuns {

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

    public static int betterRandom(int rating[]){
        int[] elementsToSelectFrom = {-1,0,1,2,3,4,5,6};
        int n = 8;
        int[] prefix = new int[n];
        int i;
        prefix[0] = rating[0];
        for (i = 1; i < n; ++i)
        {
            prefix[i]  = prefix[i - 1] + rating[i];
        }
        int random = (int) (Math.random() * 100) + 1;
        int indexc = findCeil(prefix, random, 0, 7);
        return elementsToSelectFrom[indexc];
    }
}
