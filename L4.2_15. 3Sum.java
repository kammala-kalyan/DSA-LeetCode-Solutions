/*

🔢 LeetCode Problem: 15. 3Sum
🌐 Link: https://leetcode.com/problems/3sum/
📌 Difficulty: Medium
🧠 Topics: Array, Two Pointers, Sorting
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
  */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3 || nums==null){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int target=0;
        Set<List<Integer>> result=new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    int sum=nums[i]+nums[j]+nums[k];
                    if(sum==target){
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    }
                }
            }
                         
        }
        return new ArrayList<>(result);
    }
} //----------------------------------------------->works but time limit exceeded O(n^3);

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3 || nums==null){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int target=0;
        Set<List<Integer>> result=new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            int start=i+1;
            int end=nums.length-1;
            while(start<end){
                int sum=nums[i]+nums[start]+nums[end];
                if(sum>target){
                    end--;
                }
                else if(sum<target){
                    start++;
                }
                else if(sum==target){
                    result.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    start++;
                    end--;
                }            
            }
        }
        return new ArrayList<>(result);
    }
}//--------------------------------------------->O(n^2)

//------------------------------------------------Will work on more optimized code.
