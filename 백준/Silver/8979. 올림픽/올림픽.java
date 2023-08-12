import java.io.*;
import java.util.*;

class Main {

    static class Nat implements Comparable<Nat> {

        int gold, silver, bronze;

        Nat(int gold, int silver, int bronze) {
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public int compareTo(Nat o) {
            if (this.gold != o.gold) {
                return this.gold - o.gold;
            } else if (this.silver != o.silver) {
                return this.silver - o.silver;
            } else {
                return this.bronze - o.bronze;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt() - 1;
        Nat[] nations = new Nat[N];
        for(int i = 0; i < N; i++) {
            nations[sc.nextInt() - 1] = new Nat(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        int ans = 1;
        for(int i = 0; i < N; i++) {
            if(i != K && nations[i].compareTo(nations[K]) > 0) ans++;
        }
        System.out.println(ans);
    }
}
