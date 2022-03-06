import java.util.Scanner;
 
public class swea1216_회문2 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        for (int tc = 1; tc <= 10; tc++) {
            int t = sc.nextInt();
            sc.nextLine();
            char[][] map = new char[100][100];
            for (int i = 0; i < 100; i++) {
                map[i] = sc.nextLine().toCharArray();
            }
            int ans = 0;
            outer:
            for (int len = 100; len > 0; len--) {
                boolean flagr = false;
                boolean flagc = false;
                boolean flag = false;
                for (int i = 0; i < 100; i++) {
                    for (int j = 0; j <= 100 - len; j++) {
                        for (int k = j, m = j + len - 1; j <= m; k++, m--) {
                            if (map[i][k] != map[i][m]) {
                                flagr = false;
                                break;
                            }
                            flagr = true;
                        }
                        for (int k = j, m = j + len - 1; j <= m; k++, m--) {
                            if (map[k][i] != map[m][i]) {
                                flagc = false;
                                break;
                            }
                            flagc = true;
                        }
                        if (flagr || flagc) {
                            flag = true;
                        }
                    }   
                    if (flag){
                        ans = len;  
                        break outer;
                    }
                } // i 길이의 회문 검사
            }
            System.out.println("#" + t + " " + ans);
        }
    }
}