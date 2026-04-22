class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        
        // Edge case: same color
        if (original == color) return image;
        
        dfs(image, sr, sc, original, color);
        return image;
    }
    
    private void dfs(int[][] image, int r, int c, int original, int newColor) {
        int m = image.length;
        int n = image[0].length;
        
        // boundary + color check
        if (r < 0 || c < 0 || r >= m || c >= n || image[r][c] != original) {
            return;
        }
        
        // color the cell
        image[r][c] = newColor;
        
        // explore 4 directions
        dfs(image, r + 1, c, original, newColor);
        dfs(image, r - 1, c, original, newColor);
        dfs(image, r, c + 1, original, newColor);
        dfs(image, r, c - 1, original, newColor);
    }
}