class Solution {
    long MOD = 100000007;
    long BASE = 10;

    public int smallestUniqueSubarray(int[] nums) {
       int n = nums.length;

       long[] hash = new long[n+1];
       long[] pow = new long[n+1];

       pow[0] = 1;

       for(int i = 1;i<=n;i++){
        pow[i] = (pow[i-1] * BASE) % MOD;
       }    

       for(int i = 0;i<n;i++){
          hash[i+1] = (hash[i] * BASE + nums[i]) % MOD;
       }

       int low = 1;
       int high = n;

       int ans = n;

       while(low <= high){
        int mid = low + (high - low) / 2;

        if(check(mid,nums, hash, pow)){
            ans = mid;
            high = mid - 1;
        }
        else{
            low = mid + 1;
        }
       }

       return ans;
    }

    private boolean check(int len, int[] nums, long[] hash, long[] pow){
        int n = nums.length;

        Map<Long, Integer> map = new HashMap<>();

        for(int i = 0;i+len<=n;i++){
            int l = i;
            int r = i + len - 1;

            long currentHash = getHash(l,r,hash, pow);

            map.put(currentHash, map.getOrDefault(currentHash,0) + 1);
        }

        for(int count : map.values()){
            if(count == 1){
                return true;
            }
        }

        return false;
    }

    private long getHash(int l, int r, long[] hash, long[] pow){
        long result = (hash[r+1]  - (hash[l] * pow[r-l+1]) % MOD + MOD) % MOD;
        return result;
    }
}