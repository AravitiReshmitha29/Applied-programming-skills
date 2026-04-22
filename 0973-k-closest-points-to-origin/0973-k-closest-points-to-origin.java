import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        // max heap based on distance
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(distance(b), distance(a))
        );
        
        for (int[] p : points) {
            maxHeap.offer(p);
            
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        int[][] result = new int[k][2];
        
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        
        return result;
    }
    
    private int distance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}