class Solution {
    static class Node{
        int des;
        int wt;
        public Node(int des , int wt){
            this.des = des;
            this.wt = wt;
        }
    }
    static class Pair implements Comparable<Pair>{
        int v;
        int wt;
        public Pair(int v , int wt){
            this.v = v;
            this.wt = wt;
        }
        public int compareTo(Pair p2){
            return this.wt - p2.wt;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for(int i =0 ; i<=n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int i =0 ;i<times.length ; i++){
            int s = times[i][0];
            int d = times[i][1];
            int w = times[i][2];

            graph.get(s).add(new Node(d,w));
        }
        int dis[] = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        NetworkDis(k , graph , dis);
        int ans = Integer.MIN_VALUE;
        for(int i =1 ; i<dis.length; i++){
            if(dis[i]==Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans , dis[i]);
        }
        return ans;
        
    }
    public static void NetworkDis(int src , ArrayList<ArrayList<Node>> graph , int dis[]){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src , 0));
        dis[src]=0;
        while(pq.size()>0){
            Pair front = pq.remove();
            int v = front.v;
            int w = front.wt;
            if(w>dis[v]){
                continue;
            }
            for(Node ele : graph.get(v)){
                if(w+ele.wt < dis[ele.des]){
                    dis[ele.des]= w+ele.wt;
                    pq.add(new Pair(ele.des , dis[ele.des]));
                }
            }
        }
    }
}