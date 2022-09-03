import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int i = 1; i <= s.length()/2; i++){
            StringBuilder sb = new StringBuilder();
            int counter = 1;
            String prev = s.substring(0,i);
            
            for(int j = i; j <= s.length(); j += i){
                String next = s.substring(j, j+i > s.length() ? s.length() : j + i);
                if(next.equals(prev)) {
                    counter++;
                }
                else{
                    if(counter > 1) sb.append(counter); 
                    sb.append(prev);
                    prev = next;
                    counter = 1;
                }
            }
            sb.append(prev);
            answer = Math.min(sb.length(),answer);
        }
        return answer;
    }
}