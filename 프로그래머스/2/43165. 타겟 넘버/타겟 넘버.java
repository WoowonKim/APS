class Solution {
    static int answer, n;
    public int solution(int[] numbers, int target) {
        answer = 0;
        n = numbers.length;
        solve(0, numbers, target, new int[n]);
        return answer;
    }
    
    public void solve(int index, int[] numbers, int target, int[] sel) {
        if(index == n) {
            int temp = 0;
            for(int i = 0; i < n; i++) temp += sel[i] * numbers[i];
            if(temp == target) answer++;
            return;
        } 
        
        sel[index] = 1;
        solve(index+1, numbers, target, sel);
        sel[index] = -1;
        solve(index+1, numbers, target, sel);
    }
}