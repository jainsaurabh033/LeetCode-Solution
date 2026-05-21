class Solution {
    long BASE = 911382323L;
    long MOD = 1000000007L;
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        long[] pow = new long[n+1];
        pow[0] = 1;

        for(int i = 1;i<=n;i++){
            pow[i] = (pow[i-1] * BASE) % MOD;
        }

        long[] hash = new long[n+1];

        for(int i = 0;i<n;i++){
            hash[i+1] = (hash[i] * BASE + nums[i] + 1) % MOD;
        }

        int low = 1;
        int high = n;

        int ans = n;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(check(nums, mid, hash, pow)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean check(int[] nums, int len, long[] hash, long[] pow){
        int n = nums.length;

        Map<Long, Integer> freq = new HashMap<>();

        for(int i = 0;i+len <= n ;i++){
            int l = i;
            int r = i + len - 1;

            long currentHash = getHash(l, r, hash, pow);

            freq.put(currentHash, freq.getOrDefault(currentHash, 0) + 1);
        }

        for(int count : freq.values()){
            if(count == 1){
                return true;
            }
        }

        return false;
    }

    private long getHash(int l, int r, long[] hash, long[] pow){
        long result = (hash[r+1] - (hash[l] * pow[r-l+1]) % MOD + MOD) % MOD;

        return result;   
    }
}