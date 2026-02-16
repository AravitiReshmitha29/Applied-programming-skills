import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        // Step 1: Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Min Heap based on frequency
        PriorityQueue<Integer> minheap =
                new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        
        for (int key : map.keySet()) {
            minheap.offer(key);
            if (minheap.size() > k) {
                minheap.poll();
            }
        }
        
        // Step 3: Build result
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minheap.poll();
        }
        
        return result;
    }
}
