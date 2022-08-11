import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> category = new HashMap<>();
        for(int i =0; i<clothes.length; i++){
            String key = clothes[i][1];
            if(!category.containsKey(key)) {
                category.put(key, 1);
            } else {
                category.put(key, category.get(key) + 1);
            }
        }
        for(String key : category.keySet()) {
            answer *=(category.get(key)+1);
        }
        return (answer - 1);
    }
}