class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(nums, 0, curr, res);
        return res;
    }
    private void helper(int[] nums, int idx, List<Integer> curr, List<List<Integer>> res){
        if(idx == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        // Include
        curr.add(nums[idx]);
        helper(nums, idx+1, curr, res);
        // backtrack
        curr.remove(curr.size()-1);
        // handle duplicate
        while(idx+1 < nums.length && nums[idx] == nums[idx+1]){
            idx++;
        }
        // exclude
        helper(nums, idx+1, curr, res);
    }
}