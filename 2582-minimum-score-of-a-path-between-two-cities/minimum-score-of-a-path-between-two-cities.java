import java.util.*;

class Solution {
    
    static class Pair {
        int node, wt;
        Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }
    
    public int minScore(int n, int[][] roads) {
        
        // Step 1: Graph build
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] r : roads) {
            int u = r[0], v = r[1], w = r[2];
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }
        
        // Step 2: BFS from node 1
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(1);
        visited[1] = true;
        
        int minEdge = Integer.MAX_VALUE;
        
        while (!q.isEmpty()) {
            int node = q.poll();
            
            for (Pair nei : graph.get(node)) {
                
                // 🔥 update minimum edge
                minEdge = Math.min(minEdge, nei.wt);
                
                if (!visited[nei.node]) {
                    visited[nei.node] = true;
                    q.add(nei.node);
                }
            }
        }
        
        return minEdge;
    }
}