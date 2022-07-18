import java.util.*;
class Solution {
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,-1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int T = -1;
        while(T++ < 4){
            out : for(int i = 0; i < 5; i++){
                String line = places[T][i];
                for(int j = 0; j < 5; j++){
                    if(line.charAt(j)=='P' && !check(i,j,places[T])){
                        answer[T] = 0;
                        break out;
                    }
                }
                answer[T] = 1;
            }
        }
        return answer;
    }
    
    public boolean check(int r, int c, String[] map){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int d = 0; d < 4; d++){
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                if(nr < 0 || nc < 0 || nc >= 5 || nr >= 5 ||(nr==r && nc ==c)) continue;
                int dist = Math.abs(nr-r) + Math.abs(nc-c);
                if(map[nr].charAt(nc) == 'P' && dist <= 2)
                    return false;
                else if(map[nr].charAt(nc) == 'O' && dist < 2)
                    q.add(new int[] {nr,nc});
            }
        }
        return true;
    }
}