class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : stones){
            maxheap.add(num);
        }
        while(maxheap.size() > 1){
            int y = maxheap.poll();
            int x = maxheap.poll();
            if(y != x){
                maxheap.add(y-x);
            }
        }
        if(maxheap.isEmpty()){
            return 0;
        }
        return maxheap.peek();
    }
}
