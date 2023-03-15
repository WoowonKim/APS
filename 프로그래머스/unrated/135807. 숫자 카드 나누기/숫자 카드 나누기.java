class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int AGCD = arrayA[0];
        int BGCD = arrayB[0];
        
        for(int i = 1; i < arrayA.length ;i++) {
            AGCD = gcd(AGCD, arrayA[i]);
        }
        for(int i = 1; i < arrayB.length ;i++) {
            BGCD = gcd(BGCD, arrayB[i]);
        }
        
        boolean canA = true;
        boolean canB = true;
        
        for(int i = 0; i < arrayA.length ;i++) {
            if (arrayA[i]%BGCD == 0) canB = false;
        }
        for(int i = 0; i < arrayB.length ;i++) {
            if (arrayB[i]%AGCD == 0) canA = false;
        }
        if(!canA && !canB) return 0;
        if(canA && canB) return Math.max(AGCD, BGCD);
        else return canA ? AGCD : BGCD;
    }
    
    static int gcd (int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
}
