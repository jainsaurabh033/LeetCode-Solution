class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2*n];
        
        int j = 0;

        for(int i = 0;i<n;i++){
            ans[j] = nums[i];
            j++;
        }

        for(int i = n-1;i>=0;i--){
            ans[j] = nums[i];
            j++;
        }

        return ans;
    }
}