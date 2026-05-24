class Solution {
    public int passwordStrength(String password) {
        int n = password.length();

        Map<Character, Boolean> map = new HashMap<>();

        int ans = 0;

        for(int i = 0;i<n;i++){
            char c = password.charAt(i);

            if(map.getOrDefault(c, false) == false){
                if(isLowerCaseChar(c)){
                    ans += 1;
                }
                else if(isUpperCaseChar(c)){
                    ans+= 2;
                }
                else if(isNumber(c)){
                    ans += 3;
                }
                else if(isSpecialChar(c)){
                    ans += 5;
                }
            }

            map.put(c, true);
        }

        return ans;
    }

    private boolean isLowerCaseChar(char c){
        if('a' <= c && c <= 'z') return true;

        return false;
    }

    private boolean isUpperCaseChar(char c){
        if('A' <= c && c <= 'Z') return true;

        return false;
    }

    private boolean isNumber(char c){
        if('0' <= c && c <= '9') return true;

        return false;
    }

    private boolean isSpecialChar(char c){
        if(c == '!' || c == '@' || c == '#' || c == '$') return true;

        return false;
    }
}