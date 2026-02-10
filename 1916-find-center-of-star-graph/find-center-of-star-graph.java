class Solution {
    public int findCenter(int[][] edges) {
        int max = 0;
        for (int i = 0; i < edges.length; i++) {
            max = Math.max(max, Math.max(edges[i][0], edges[i][1]));
        }
        int arr[] = new int[max + 1];
        for (int i = 0; i < edges.length; i++) {

            arr[edges[i][0]]++;
            arr[edges[i][1]]++;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == edges.length) {
                return i;
            }
        }

        return -1;
    }
}