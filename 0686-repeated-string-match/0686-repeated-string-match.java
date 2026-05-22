class Solution {
    private static final int BASE = 10;
    private static final int MOD = 100000007;

    public int repeatedStringMatch(String a, String b) {
       StringBuilder st = new StringBuilder();

       int count = 0;

       while(st.length() < b.length()){
          st.append(a);
          count++;
       }    

       if(rabinKarp(st.toString(),b) == true){
          return count;
       }

       st.append(a);

       if(rabinKarp(st.toString(),b) == true){
          return count + 1;
       }

       return -1;
    }

    private boolean rabinKarp(String text, String pattern){
        int n = text.length();
        int m = pattern.length();

        long texthash = 0;
        long patternhash = 0;
        long pow = 1;

        for(int i = 0;i<m-1;i++){
            pow = pow * BASE;
        }

        for(int i = 0;i<m;i++){
            texthash = (texthash * BASE + (text.charAt(i) - 'a' + 1)) % MOD;
            patternhash = (patternhash * BASE + (pattern.charAt(i) - 'a' + 1)) % MOD;
        }

        for(int i = 0;i<=n-m;i++){
            if(patternhash == texthash){
                if(check(text, pattern,i)){
                    return true;
                }
            }

            if(i < n - m){
                texthash = (texthash - ((text.charAt(i) - 'a' + 1) * pow) % MOD + MOD) % MOD;
                texthash = (texthash * BASE + (text.charAt(i+m) - 'a' + 1)) % MOD;
            }
        }

        return false;
    }

    private boolean check(String text, String pattern, int start){
        for(int i = 0;i<pattern.length(); i++){
            if(text.charAt(start + i) != pattern.charAt(i)){
                return false;
            }
        }

        return true;
    }
}