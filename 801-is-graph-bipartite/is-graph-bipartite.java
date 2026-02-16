class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        Arrays.fill(color , -1);
        for(int i = 0 ; i<n ; i++){
            if(color[i]==-1){
                if(!bipartite(i , graph , color , 0)){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean bipartite(int i , int[][] graph , int[] color , int col){
        color[i] = col;
        for(int ele : graph[i]){
            if(color[ele]==-1){
                if(!bipartite(ele , graph , color , 1-col)){
                    return false;
                }
            }else if(color[ele]==color[i]){
                    return false;
            }
        }
        return true;
    }
}