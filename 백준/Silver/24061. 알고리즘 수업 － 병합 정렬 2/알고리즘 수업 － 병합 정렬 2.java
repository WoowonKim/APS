import java.util.*;
import java.io.*;

public class Main {
    static int[] arr, tmp;
    static int cnt, K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        arr = new int[N];
        tmp = new int[N];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        mergeSort(0, N - 1);
        if(cnt < K) System.out.println(-1);
    }

    private static void mergeSort(int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(p, q, r);
        }
    }

    private static void merge(int p, int q, int r) {
        int i = p, j = q + 1, t = 0;
        while (i <= q && j <= r) {
            if (arr[i] < arr[j]) tmp[t++] = arr[i++];
            else tmp[t++] = arr[j++];
        }
        while (i <= q) tmp[t++] = arr[i++];
        while (j <= r) tmp[t++] = arr[j++];
        i = p; t = 0;
        while (i <= r) {
            cnt++;
            arr[i++] = tmp[t++];
            if(cnt == K) System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", ""));;
        }
    }
}
