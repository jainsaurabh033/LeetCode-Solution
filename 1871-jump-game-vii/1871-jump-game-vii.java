class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[0] = true;

        q.offer(0);

        int farthest = 0;

        while(!q.isEmpty()){
            int curr = q.poll();

            if(curr == n-1) return true;

            int start = Math.max(curr + minJump, farthest + 1);
            int end = Math.min(curr + maxJump, n-1);

            for(int i = start;i<=end;i++){
                if(s.charAt(i) == '0' && visited[i] == false){
                    visited[i] = true;
                    q.offer(i);
                }
            }
            farthest = end;
        }

        return false;
    }
}