class Solution {
    public String longestNiceSubstring(String s) {
        return helper(s);
    }
    
    private String helper(String s) {
        int n = s.length();
        
        if (n < 2) return "";
        
        // Check validity
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lower[c - 'a'] = true;
            } else {
                upper[c - 'A'] = true;
            }
        }
        
        // Find bad character
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            int idx = Character.toLowerCase(c) - 'a';
            
            if (lower[idx] != upper[idx]) {
                // split
                String left = helper(s.substring(0, i));
                String right = helper(s.substring(i + 1));
                
                return left.length() >= right.length() ? left : right;
            }
        }
        
        // If no split needed, whole string is nice
        return s;
    }
}