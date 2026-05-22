class Solution {
    private static final int BASE = 10;
    private static final int MOD = 100000007;

    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while(sb.length() < b.length()){
            sb.append(a);
            count++;
        }    

        if(rabinKarp(sb.toString(), b)){
            return count;
        }

        sb.append(a);

        if(rabinKarp(sb.toString(),b)){
            return count + 1;
        }

        return -1;
    }

    private boolean rabinKarp(String text, String pattern){
        int n = text.length();
        int m = pattern.length();

        if(m > n){
            return false;
        }

        long patternHash = 0;
        long windowHash = 0;
        long power = 1;

        for(int i = 0;i<m-1;i++){
            power = (power * BASE) % MOD;
        }

        for(int i = 0;i<m;i++){
            patternHash = (patternHash * BASE + (pattern.charAt(i) - 'a' + 1)) % MOD;
            windowHash = (windowHash * BASE + (text.charAt(i) - 'a' + 1)) % MOD;
        }

        for(int i = 0;i<=n-m;i++){
            if(patternHash == windowHash){
                if(check(text, pattern, i)){
                    return true;
                }
            }

            if(i < n-m){
                windowHash = (windowHash - ((text.charAt(i) - 'a' + 1) * power) % MOD + MOD) % MOD;

                windowHash = (windowHash * BASE + (text.charAt(i+m) - 'a' + 1)) % MOD;
            }
        }

        return false;
    }

    private boolean check(String text, String pattern, int start){
        for(int i = 0;i<pattern.length();i++){
            if(text.charAt(start + i) != pattern.charAt(i)){
                return false;
            }
        }

        return true;
    }
}