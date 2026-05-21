class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        if(m < n){
            return longestCommonPrefix(arr2, arr1);
        }

        Set<String> st = new HashSet<>();
        StringBuilder temp = new StringBuilder();

        for(int i = 0;i<n;i++){
            String s = Integer.toString(arr1[i]);

            for(int j = 0;j<s.length();j++){
                temp.append(s.charAt(j));
                st.add(temp.toString());
            }

            temp.setLength(0);
        }

        int ans = 0;

        for(int i = 0;i<m;i++){
            String s = Integer.toString(arr2[i]);

            for(int j = 0;j<s.length();j++){
                temp.append(s.charAt(j));
                
                if(st.contains(temp.toString())){
                    ans = Math.max(ans, temp.length());
                }
            }

            temp.setLength(0);
        }

        return ans;
    }
}