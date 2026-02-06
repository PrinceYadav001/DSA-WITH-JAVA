class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n= rooms.size();
        boolean vis[] = new boolean[n];
        helper(rooms , 0, vis);
        for(int i = 0 ; i<vis.length ; i++){
            if(vis[i]==false){
                return false;
            }
        }
        return true;
    }
    public static void helper(List<List<Integer>> rooms , int i , boolean vis[]){
        vis[i]= true;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(q.size()>0){
            int a = q.remove();
            for(int ele : rooms.get(a)){
                if(vis[ele]!=true){
                    q.add(ele);
                    vis[ele]= true;
                }
            }
        }   
    }
}