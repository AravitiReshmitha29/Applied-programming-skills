class Solution {
    
    // Helper function to reverse the number recursively
    private int reverseNumber(int x, int rev) {
        if (x == 0) return rev;
        return reverseNumber(x / 10, rev * 10 + x % 10);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false; // negative numbers are not palindrome
        return x == reverseNumber(x, 0);
    }
}
