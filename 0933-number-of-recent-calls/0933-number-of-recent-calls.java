import java.util.Queue;
import java.util.LinkedList;

class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);

        // Remove calls older than t - 3000
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }
}
