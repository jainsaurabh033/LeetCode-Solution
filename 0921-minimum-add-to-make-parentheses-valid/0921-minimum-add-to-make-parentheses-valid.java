class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();

        int open = 0;
        int insertion = 0;

        for(int i = 0;i<n;i++){
            if(s.charAt(i) == '('){
                open++;
            }
            else{
                if(open > 0){
                    open--;
                }
                else{
                    insertion++;
                }
            }
        }

        return open + insertion;
    }
}