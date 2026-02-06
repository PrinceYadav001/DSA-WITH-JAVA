class Solution {
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
       ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i =0; i<n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int i =0 ; i<edges.length ; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean vis[] = new boolean[n];
        bfs(graph , source, destination , vis , n);
        if(vis[destination]!=true){
            return false;
        }else{
            return true;
        } 
    }
    public static void bfs(ArrayList<ArrayList<Integer>> graph , int source , int destination , boolean [] vis , int n){
        vis[source]=true;
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while(q.size()>0){
            int a = q.remove();
            for(int ele : graph.get(a)){
                 if(vis[ele]!=true){
                    q.add(ele);
                    vis[ele]= true;
                 }
            }
           
        }

    }
}