class Solution {
    static Map<Character, Character> mappings = new HashMap<>();
    static {
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
    }
    public boolean isValid(String s) {
    // Complexity Analysis
    // Time Complexity: O(n) – We traverse the string once, processing each character in constant time. Both push and pop operations on the stack run in O(1).
    // Space Complexity: O(n) – In the worst case (e.g., "(((((((((("), all opening brackets are pushed onto the stack, leading to O(n) space usage.
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        //case 1:open bracket, push in the stack
        //case 2: closing bracket
        //after traverse the whole string and the stack is empty, then return true;
        int left = 0;
        int len = s.length();
         Deque<Character> stack = new ArrayDeque<Character>();
         while (left < len) {
            char currEle = s.charAt(left);
            if ( mappings.containsKey(currEle)) {
                 if (stack.isEmpty() || stack.pop() != mappings.get(currEle)) {
                    return false; 
                 }
            } else {
                stack.push(currEle);
            }
            left++;
         }
         return stack.isEmpty();
    }
}