import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        
        ArrayList<Integer> crane = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            crane.add(sc.nextInt());
        }
        Collections.sort(crane, Collections.reverseOrder());
        
        int m = sc.nextInt();
        ArrayList<Integer> loads = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            loads.add(sc.nextInt());
        }
        Collections.sort(loads, Collections.reverseOrder());
        
        if(crane.get(0) < loads.get(0)) System.out.println(-1);
        else {
            int ans = 0;
            while(!loads.isEmpty()) {
                int idx = 0;
                for(int i = 0; i < crane.size();) {
                    if(idx == loads.size()) break;
                    else if(crane.get(i) >= loads.get(idx)) {
                        loads.remove(idx);
                        i++;
                    }
                    else idx++;
                }
                ans++;
            }
            System.out.println(ans);
        }
    }
}