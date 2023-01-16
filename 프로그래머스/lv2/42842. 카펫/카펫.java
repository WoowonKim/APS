class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sum = brown + yellow;
        for(int i = 2; ; i++) {
            if(sum % i != 0) continue;
            int r = i;
            int c = sum / i;
            if(((2 * r) + (2 * c) - 4) == brown) {
                answer = new int[] {c, r};
                break;
            }
        }
        return answer;
    }
}