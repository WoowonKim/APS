import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> matchMap = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            matchMap.put(want[i], i);
        }

        int total = 0;
        for(int i = 0; i < number.length; i++) {
            total += number[i];
        }
        int ptr1 = 0;
        int ptr2 = total-1;

        int[] saleNum = new int[number.length];
        for(int i = 0; i < total; i++) {
            if(matchMap.containsKey(discount[i])) {
                saleNum[matchMap.get(discount[i])]++;
            }
        }
        while(true) {
           if(checkMatch(number, saleNum))
               answer++;

            if(matchMap.containsKey(discount[ptr1])) {
                saleNum[matchMap.get(discount[ptr1])]--;
            }

           ptr1++;
           ptr2++;

            if(ptr2 == discount.length)
                break;

            if(matchMap.containsKey(discount[ptr2])) {
                saleNum[matchMap.get(discount[ptr2])]++;
            }
        }
        return answer;
    }

    Boolean checkMatch(int[] number, int[] saleNum) {
        for(int i = 0; i < number.length; i++) {
            if(number[i]>saleNum[i])
                return false;
        }
        return true;
    }
}