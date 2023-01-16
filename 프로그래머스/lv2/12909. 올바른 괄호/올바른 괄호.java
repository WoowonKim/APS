import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int close = 0;
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()) {
            stk.push(c);
        }
        while(!stk.empty()) {
            char curr = stk.pop();
            if(curr == ')') {
                close += 1;
            } else {
                if(close > 0) close -= 1;
                else return false;
            }
        }
        if(close != 0) return false;
        return answer;
    }
}