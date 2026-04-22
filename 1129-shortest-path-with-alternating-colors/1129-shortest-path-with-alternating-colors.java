import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        // Build adjacency lists
        List<Integer>[] redGraph = new ArrayList[n];
        List<Integer>[] blueGraph = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            redGraph[i] = new ArrayList<>();
            blueGraph[i] = new ArrayList<>();
        }
        
        for (int[] edge : redEdges) {
            redGraph[edge[0]].add(edge[1]);
        }
        
        for (int[] edge : blueEdges) {
            blueGraph[edge[0]].add(edge[1]);
        }
        
        // Result array
        int[] res = new int[n];
        Arrays.fill(res, -1);
        
        // visited[node][color]
        // color: 0 = red, 1 = blue
        boolean[][] visited = new boolean[n][2];
        
        Queue<int[]> queue = new LinkedList<>();
        
        // Start from node 0 with both colors
        queue.offer(new int[]{0, 0, 0}); // node, distance, last_color = red
        queue.offer(new int[]{0, 0, 1}); // last_color = blue
        
        visited[0][0] = true;
        visited[0][1] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int dist = curr[1];
            int lastColor = curr[2];
            
            // Set shortest distance if not already set
            if (res[node] == -1) {
                res[node] = dist;
            }
            
            // Alternate color
            if (lastColor == 0) { // last was red → take blue edges
                for (int nei : blueGraph[node]) {
                    if (!visited[nei][1]) {
                        visited[nei][1] = true;
                        queue.offer(new int[]{nei, dist + 1, 1});
                    }
                }
            } else { // last was blue → take red edges
                for (int nei : redGraph[node]) {
                    if (!visited[nei][0]) {
                        visited[nei][0] = true;
                        queue.offer(new int[]{nei, dist + 1, 0});
                    }
                }
            }
        }
        
        return res;
    }
}