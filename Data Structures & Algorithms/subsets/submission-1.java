class Solution {
    public List<List<Integer>> subsets(int[] nums) {
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
        // Include num
        curr.add(nums[idx]);
        helper(nums, idx+1, curr, res);
        // backtrack
        curr.remove(curr.size()-1);
        // exclude num
        helper(nums, idx+1, curr, res);
    }
}
