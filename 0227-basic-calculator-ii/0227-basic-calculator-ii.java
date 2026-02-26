
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char operator = '+';  // previous operator
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            
            // If current char is operator OR end of string
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                
                if (operator == '+') {
                    stack.push(num);
                } 
                else if (operator == '-') {
                    stack.push(-num);
                } 
                else if (operator == '*') {
                    stack.push(stack.pop() * num);
                } 
                else if (operator == '/') {
                    stack.push(stack.pop() / num);  // truncates toward zero
                }
                
                operator = ch;
                num = 0;
            }
        }
        
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}