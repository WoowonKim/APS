import java.util.*;
class Solution {
    public String solution(String p) {
        String answer = "";
        if(isRight(p)) return p;
        else answer = getRight(p);
        return answer;
    }
    public String getRight(String w) {
        if(w.length()==0) return "";
        String[] s = splitUV(w);
        String u = s[0];
        String v = s[1];
        if(isRight(u)) {
            return u + getRight(v);
        } else {
            String newS = "(";
            newS += getRight(v);
            newS += ")";
            return newS + flip(u);
        }
    }
    public String flip(String w) {
        String s = "";
        for(int i = 1; i < w.length()-1; i++){
            s += w.charAt(i) == '(' ? ")" : "(";
        }
        return s;
    }
    public String[] splitUV(String w) {
        int count1 = 0;;
        int count2 = 0;;
        String[] UV = {"a","b"};
        for(int i = 0; i < w.length(); i++) {
            if(w.charAt(i) =='(') count1++;
            if(w.charAt(i) ==')') count2++;
            if(count1 == count2) {
                UV[0] = w.substring(0, i+1);
                UV[1] = w.substring(i+1, w.length());
                break;
            }
        }
        return UV;
    }

    public boolean isRight(String w) {
        int counter = 0;
        for(int i = 0; i < w.length(); i++) {
            if(w.charAt(i) == '(') counter++;
            else {
                if(counter > 0) counter--;
                else return false;
            }
        }
        return true;
    }
}