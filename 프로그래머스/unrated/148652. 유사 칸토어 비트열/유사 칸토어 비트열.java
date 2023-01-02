class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;

        for (long i = l; i <= r; i++) {
            answer += is1(n, i - 1);
        }

        return answer;
    }

    int is1(int n, long l) {
        if (n == 0 || l == 0)
            return 1;
        if (l % 5 == 2)
            return 0;
        return is1(n - 1, l / 5);
    }

}