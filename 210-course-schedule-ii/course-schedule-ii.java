class Solution {
    public int[] findOrder(int n, int[][] edges) {
        int in[] = new int[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i =0 ; i<n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0 ; i<edges.length ; i++){
            int a= edges[i][0];
            int b = edges[i][1];

            graph.get(a).add(b);
            in[b]++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i =0  ; i<n; i++){
            if(in[i]==0){
                q.add(i);
                ans.add(i);
            }
        }
        while(q.size()>0){
            int a = q.remove();
            for(int ele : graph.get(a)){
                in[ele]--;
                if(in[ele]==0){
                    q.add(ele);
                    ans.add(ele);
                }
            }
        }
        if(ans.size()==n){
            int res[] = new int[n];
            int j =0;
            for(int i =n-1 ; i>=0 ; i--){
                res[i]=ans.get(j);
                j++;
            }
            return res;
        }else
        return new int[]{};
    }
}