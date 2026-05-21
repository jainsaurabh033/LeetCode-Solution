class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        Set<String> st = new HashSet<>();

        for(int i = 0;i<n;i++){
            String s = Integer.toString(arr1[i]);

            StringBuilder temp = new StringBuilder();

            for(int j = 0;j<s.length();j++){
                temp.append(s.charAt(j));
                st.add(temp.toString());
            }
        }

        int ans = 0;

        for(int i = 0;i<m;i++){
            String s = Integer.toString(arr2[i]);

            StringBuilder temp = new StringBuilder();

            for(int j = 0;j<s.length();j++){
                temp.append(s.charAt(j));
                
                if(st.contains(temp.toString()) == true){
                    ans = Math.max(ans, temp.length());
                }
            }
        }

        return ans;
    }
}