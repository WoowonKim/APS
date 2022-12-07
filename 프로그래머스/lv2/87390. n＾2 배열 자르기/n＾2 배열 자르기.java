class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right-left)+1;
        int[] answer = new int[size];
        int leftRow = (int)(left/n);
        int rightRow = (int)(right/n);
        int st = (int)(left%n);
        int idx = 0;
        for(int i = leftRow; i <= rightRow; i++) {
            for(int j = st; j < n; j++) {
                if(idx > size-1) break;
                int num = j+1;
                if(j < i+1) num = i+1;
                answer[idx] = num;
                idx++;
            }
            st = 0;
        }
  
        return answer;
    }
}