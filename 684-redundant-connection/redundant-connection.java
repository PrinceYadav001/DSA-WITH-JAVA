class Solution {
    class DSU{
        int parent[];
        int size[];
        DSU(int n){
            parent = new int[n+1];
            size = new int[n+1];
            for(int i =0 ; i<=n ; i++){
                parent[i]=i;
                size[i]=0;
            }
        }
        int find(int a){
            if(a==parent[a]){
                return a;
            }
            return parent[a]= find(parent[a]);
        }
        boolean union(int a  , int b ){
            int pa = find(a);
            int pb = find(b);
            if(pa == pb){
                return false;
            }
            if(size[pa]> size[pb]){
                parent[pb]=pa;
            }else if(size[pa]<size[pb]){
                parent[pa]=pb;
            }else{
                parent[pb]=pa;
                size[pa]++;
            }
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int m=Integer.MIN_VALUE;
        for(int i =0 ; i<edges.length; i++){
            m = Math.max(m , Math.max(edges[i][0] ,edges[i][1]));
        }
        DSU d1 = new DSU(m);
        for(int i =0; i<edges.length ; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            int pa = d1.find(a);
            int pb = d1.find(b);
            if(pa!=pb){
                d1.union(a ,b);
            }else if(pa == pb){
                return new int[]{a ,b};
            }
        }
         return new int[]{};
    }
    
}