class Solution {
    public int makeConnected(int n, int[][] connections) {

        if (connections.length < n - 1) return -1;
        int parent[] = new int[n];
        int rank[] = new int[n];
        for(int i =0 ; i<n; i++){
            parent[i]=i;
            rank[i]=0;
        }
        int count=0;
        for(int i =0; i<connections.length ; i++){
            int pa = find(connections[i][0] , parent);
            int pb = find(connections[i][1] , parent);
            if(pa!=pb){
                union(connections[i][0] , connections[i][1] , parent , rank);
                count++;
            }
        }
        return (n-count)-1;
    }
    public static void union(int a , int b , int parent[] , int rank[]){
        int pa = find(a , parent);
        int pb = find(b , parent);

        if(pa==pb){
            return;
        }
        if(rank[pa]>rank[pb]){
            parent[pb]=pa;
        }else if(rank[pa]<rank[pb]){
            parent[pa]=pb;
        }else{
            parent[pb]=pa;
            rank[pa]++;
        }
    }
    public static int find(int a , int parent[]){
        if(a==parent[a]){
            return a;
        }
        return parent[a] = find(parent[a] , parent);
    }
}