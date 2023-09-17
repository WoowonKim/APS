import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            if(map.containsKey(p)) map.replace(p, map.get(p) + 1);
            else map.put(p, 1);
        }
        for (String p : completion) map.replace(p, map.get(p) - 1);
        for(String key : map.keySet())  {
            if(map.get(key) > 0) answer = key;
        }
        return answer;
    }
}