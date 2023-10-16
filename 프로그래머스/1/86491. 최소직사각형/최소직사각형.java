class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int[] wallet = new int[2];
        for(int i = 0; i < sizes.length; i++) {
            int[] curr = sizes[i];
            int high = Math.max(curr[0], curr[1]);
            int low = Math.min(curr[0], curr[1]);
            wallet[0] = Math.max(wallet[0], high);
            wallet[1] = Math.max(wallet[1], low);
        }
        return wallet[0] * wallet[1];
    }
}