class Solution {
    
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 1;
        int max = 200000000;
        while(min <= max) {
            int mid = (min + max)/2;
            if(check(mid, k, stones)) {
                min = mid + 1;
                answer = mid;
            } 
            else max = mid - 1;
        }
        return answer;
    }
    
     public boolean check(int mid, int k, int[] stones) {
        int jump = 0;
        for(int i = 0; i < stones.length; i++) {
            if(stones[i] < mid) {
                jump++;
                if(jump >= k) return false;
            } else jump = 0;
        }
        return true;
    }
}