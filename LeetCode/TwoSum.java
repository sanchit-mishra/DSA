/*Two Sum Problem Using HashMap Java-LeetCode
TC : O(N)*/



class Solution {
    public int[] twoSum(int[] nums, int target) {
    HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
        int[] indices = new int[2];
        
        for(int i=0; i < nums.length; i++){
            int potentialSum = target - nums[i];
            if(hmap.containsKey(potentialSum)){
                indices[0] = hmap.get(potentialSum);
                indices[1] = i;
                return indices;
            }
            else{
                hmap.put(nums[i],i);
            }
        }
    return indices;
  }
}