import java.math.*;
class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
        return ((long) w *  h) - ((((long) w / gcd) + ((long) h / gcd) - 1) * gcd);
    }
}