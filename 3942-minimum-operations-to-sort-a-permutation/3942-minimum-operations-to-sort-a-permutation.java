class Solution {
    public int minOperations(int[] nums) {
        int ans = (int) 1e9;

        int val = solve(nums);
        if(val != -1) ans = val;

        for(int i = 0;i<nums.length/2;i++){
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }

        val = solve(nums);
        if(val != -1) ans = Math.min(ans, val + 1);
        return ans == 1e9 ? -1 : ans;
    }

    private int solve(int[] nums){
        int count = 0;
        int n = nums.length;

        boolean flag = true;
        int pos = -1;

        for(int i = 0;i<n;i++){
            if(nums[i] == 0){
                pos = i;
                break;
            }
        }

        for(int i = 0;i<n;i++){
            if(nums[(i + pos) % n] != i){
                flag = false;
            }
        }

        if(flag) return pos;

        flag = true;
        for(int i = 0;i<n;i++){
            if(nums[(pos - i + n) % n] != i) flag = false;
        }

        if(flag) return pos + 2;

        return -1;
    }
}