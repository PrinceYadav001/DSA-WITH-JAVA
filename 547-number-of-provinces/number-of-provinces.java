// // class Solution {
// //     public int findCircleNum(int[][] isConnected) {
// //         int n = isConnected.length;
// //         boolean vis[] = new boolean[n];
// //         int count = 0;
// //         for (int i = 0; i < n; i++) {

// //             if (vis[i] != true) {
// //                 count++;
// //                 dfsutil(isConnected, i, vis);
// //             }
// //         }
// //         return count;
// //     }
// //     public static void dfsutil(int isConnected[][], int n, boolean vis[]) {
// //         vis[n] = true;
// //         for (int i = 0; i < isConnected.length; i++) {
// //             if (isConnected[n][i] == 1 && !vis[i]) {
// //                 dfsutil(isConnected, i, vis);
// //             }
// //         }

// //     }
// // }
// class Solution{
//     public int findCircleNum(int [][]isConnected){
//         int n = isConnected.length;
//         boolean vis[] = new boolean[n];
//         int count=0;
//         for(int i =0; i<isConnected.length ; i++){
//             if(vis[i]!=true){
//                 count++;
//                 bfs(isConnected , i , vis);
//             }
//         }
//         return count; 
//     }
//     public static void bfs(int [][] isConnected , int i , boolean vis[] ){
//         int n = isConnected.length;
//         vis[i]=true;
//          Queue<Integer> q = new LinkedList<>();
//          q.add(i);

//         while(q.size()>0){
//             int front = q.remove();
//             for(int j =0 ; j<n ; j++){
//                 if(isConnected[front][j]==1 && vis[j]!=true){
//                     q.add(j);
//                     vis[j]=true;
//                 }
//             }
//         }
        
//     }
// }

// // O(N^2) time Space Complexity


class Solution{
    public int findCircleNum(int[][] grid){
    int n = grid.length;
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for(int i =0 ; i<n+1; i++){
        graph.add(new ArrayList<>());
    }
    for (int i =0 ; i<n;  i++){
        for(int j =0 ; j<n ; j++){
            if(i==j){
                continue;
            }

            if(grid[i][j]==1){
                graph.get(i+1).add(j+1);
            }
        }
    }
    boolean vis[] = new boolean[n+1];
    int count=0;
    for(int i =1 ;i<n+1 ; i++){
        if(!vis[i]){
            count++;
            bfs(graph , i , vis);
        }
    }
    return count;
    }
    public static void bfs(ArrayList<ArrayList<Integer>> graph , int i , boolean []vis ){
        Queue<Integer> q = new LinkedList<>();
        vis[i] = true;
        q.add(i);
        while(q.size()>0){
            int a = q.remove();
            for(int ele : graph.get(a)){
                if(!vis[ele]){
                    q.add(ele);
                    vis[ele]= true;
                }
            }
        }
    }
}