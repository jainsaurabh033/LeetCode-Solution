class Solution {
    public long minArraySum(int[] nums) {
        int n = nums.length;

        Set<Integer> st = new HashSet<>();

        for(int i = 0;i<n;i++){
            st.add(nums[i]);
        }

        long sum = 0;

        for(int i = 0;i<n;i++){
            int mini = nums[i];
            for(int j = 1;j*j<=nums[i];j++){
                if(nums[i] % j == 0){

                    if(st.contains(j)){
                        mini = Math.min(mini,j);
                    }

                    int pair = nums[i]/j;

                    if(st.contains(pair)){
                        mini = Math.min(mini, pair);
                    }
                }
            }

            sum += mini;
        }        

        return sum;
    }
}