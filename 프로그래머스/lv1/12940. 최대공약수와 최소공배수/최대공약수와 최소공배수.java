import java.util.*;
class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {};
        int gcd = getGcd(Math.min(n, m), Math.max(n,m));
        answer = new int[]{gcd, n * m / gcd};
        return answer;
    }
    public static int getGcd (int a, int b) {
        return b % a == 0 ? a : getGcd(b % a, a);
    }
}