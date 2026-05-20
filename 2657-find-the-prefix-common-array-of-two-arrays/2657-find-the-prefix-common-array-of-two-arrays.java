class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;

        int[] ans = new int[n];
        int[] freq = new int[n+1];
        int count = 0;

        for(int i = 0;i<n;i++){
            freq[A[i]]++;
            freq[B[i]]++;

            if(freq[A[i]] == 2) count++;

            if(A[i] != B[i]){
               if(freq[B[i]] == 2) count++;
            };

            ans[i] = count;
        }

        return ans;
    }
}