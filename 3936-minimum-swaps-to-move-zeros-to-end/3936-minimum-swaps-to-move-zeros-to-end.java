class Solution {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;

        int zeroCount = 0;

        for(int i = 0;i<n;i++){
            if(nums[i] == 0){
                zeroCount++;
            }
        }

        int pos = n - zeroCount;

        System.out.println(pos);

        for(int i = pos;i<n;i++){
            if(nums[i] == 0){
                zeroCount--;
            }
        }

        return zeroCount;
    }
}