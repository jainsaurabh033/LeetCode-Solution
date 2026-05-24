class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> arr = new ArrayList<>();

        for(int i = 0;i<n;i++){
            if((map.containsKey(nums[i]) == false) || map.getOrDefault(nums[i],0) < k){
                arr.add(nums[i]);
            }

            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        int[] ans = new int[arr.size()];
        for(int i = 0;i<arr.size();i++){
            ans[i] = arr.get(i);
        }

        return ans;
    }
}