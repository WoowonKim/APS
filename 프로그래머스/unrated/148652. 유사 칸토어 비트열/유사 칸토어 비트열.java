class Solution {
    public int solution(int n, long l, long r) {                
        return (int)(cal(n, r - 1) - cal(n, l - 2));
    }
    
    public long cal(int n, long k) {
        if (n <= 1) {
            if (k < 2) return k + 1;            
            return k;            
        }
        
        long len = (long)Math.pow(5, n - 1);
        long d = k / len;
        long r = k % len;
        
        long res = 0;
        if (d == 2) {
            res = 2 * (long)Math.pow(4, n - 1);            
            return res;
        }
        long add = (d > 2 ? d - 1 : d) * (long)Math.pow(4, n - 1);        
        res = cal(n - 1, r) + add;        
        return res;
        
        
    }
}