import java.util.*;

class Solution {
    
    class Pair {
        int val, idx;
        Pair(int v, int i) {
            val = v;
            idx = i;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }
        
        mergeSort(arr, 0, n - 1, result);
        
        List<Integer> res = new ArrayList<>();
        for (int v : result) res.add(v);
        return res;
    }
    
    private void mergeSort(Pair[] arr, int left, int right, int[] result) {
        if (left >= right) return;
        
        int mid = left + (right - left) / 2;
        
        mergeSort(arr, left, mid, result);
        mergeSort(arr, mid + 1, right, result);
        
        merge(arr, left, mid, right, result);
    }
    
    private void merge(Pair[] arr, int left, int mid, int right, int[] result) {
        Pair[] temp = new Pair[right - left + 1];
        
        int i = left, j = mid + 1, k = 0;
        int rightCount = 0;
        
        while (i <= mid && j <= right) {
            if (arr[i].val <= arr[j].val) {
                result[arr[i].idx] += rightCount;
                temp[k++] = arr[i++];
            } else {
                rightCount++;
                temp[k++] = arr[j++];
            }
        }
        
        while (i <= mid) {
            result[arr[i].idx] += rightCount;
            temp[k++] = arr[i++];
        }
        
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }
}