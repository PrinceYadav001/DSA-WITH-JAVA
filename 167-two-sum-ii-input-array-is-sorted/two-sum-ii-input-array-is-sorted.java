class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0 ; i<numbers.length ; i++){
            int n = target-numbers[i];
            if(map.containsKey(n)){
                return new int[] {map.get(n) , i+1};
            }
            map.put(numbers[i] , i+1);
        }
        return new int[] { };
    }
}

// class Solution {
//     public int[] twoSum(int[] numbers , int target){
//         int i =0 ; 
//         int j = numbers.length-1;
        
//         while(i<j){
//             int sum = numbers[i]+numbers[j];
//             if(sum == target){
//                 return new int[]{i+1 , j+1};
//             }
//             if(sum<target){
//                 i++;
//             }else if(sum>target){
//                 j--;
//             }    
//         }
//         return new int[] { };
//     }
// }