class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;

        int ans = Integer.MAX_VALUE;

        for(int x = 0;x<k;x++){
            for(int y = 0;y<k;y++){
                if(x == y) continue;

                int count = 0;

                for(int i = 0;i<n;i++){
                    int rem = nums[i] % k;

                    if(i % 2 == 0){
                        int front = (x - rem + k) % k;
                        int back = (rem - x + k) % k;

                        count += Math.min(front,back);
                    }
                    else{
                        int front = (y - rem + k) % k;
                        int back = (rem - y + k) % k;

                        count += Math.min(front,back);
                    }
                }

                ans = Math.min(ans, count);
            }
        }

        return ans;
    }
}