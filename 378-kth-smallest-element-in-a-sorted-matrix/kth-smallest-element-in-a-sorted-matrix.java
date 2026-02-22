class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0 ; i<matrix.length ; i++){
            for(int a : matrix[i]){
                pq.add(a);
            }
        }
        int ans =0;
        for(int i =0 ; i<k ;i++){
            ans=pq.remove();
        }
        return ans;
        
        
    }
}