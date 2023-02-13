import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        boolean isPPAP = false;
        if (str.charAt(str.length() - 1) == 'P') {//마지막 문자는 무조건 p여야 함
            isPPAP = true; //PPAP일 수 있다.
            int pCnt = 0; //P의 갯수
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'P') {//P일 경우 갯수 증가
                    pCnt++;
                } else {//A일 경우
                    if (str.charAt(i + 1) != 'P' || pCnt < 2) {
                        //뒤에는 P 앞에는 2개 이상의 P가 있어야함
                        isPPAP = false;
                        break;
                    } else pCnt -= 2;
                }
            }
            if(pCnt != 1) isPPAP = false; //마지막 P를 제외하고 남은 P가 없어야함
        }
        System.out.println(isPPAP ? "PPAP" : "NP");
    }
}