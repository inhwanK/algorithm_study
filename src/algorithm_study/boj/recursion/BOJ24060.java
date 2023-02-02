package algorithm_study.boj.recursion;

import java.io.BufferedReader;
import java.io.IOException;

// 알고리즘 수업 - 병합 정렬 1
public class BOJ24060 {
    static int[] sorted;
    static int count, k, answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        String[] arrStr = br.readLine().split(" ");
        int[] arr = new int[a];
        sorted = new int[a];
        for(int i = 0; i < a; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        mergeSort(arr, 0, a - 1);
        System.out.println(answer);
    }

    private static void mergeSort(int[] arr, int left, int right) {

        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr,left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int t = left;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                sorted[t] = arr[i];
                i++;
            } else {
                sorted[t] = arr[j];
                j++;
            }
            t++;
        }

        if (i > mid) {
            for(int k = j; k <= right; k++) {
                sorted[t] = arr[k];
                t++;
            }
        } else {
            for(int k = i; k <= mid; k++) {
                sorted[t] = arr[k];
                t++;
            }
        }

        for(int index = left; index <= right; index++) {
            count++;
            arr[index] = sorted[index];
            if(count == k) {
                answer = arr[index];
                return;
            }
        }
    }
}


// https://www.acmicpc.net/source/49346830
class BOJ24060Answer {

    static int[] A, tmp;
    static int count = 0;
    static int result = -1;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        tmp = new int[N];
        merge_sort(A, 0, N - 1);
        System.out.println(result);

    }

    public static void merge_sort(int[] A, int p, int r) {
        if (count > K) return ;
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(A, p, q);
            merge_sort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    public static void merge(int[] A, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;

        while (i <= q && j <= r) {
            if(A[i] <= A[j]) {
                tmp[t] = A[i];
                i++;
            }else {
                tmp[t] = A[j];
                j++;
            }
            t++;
        }

        while (i <= q)
            tmp[t++] = A[i++];

        while (j <= r)
            tmp[t++] = A[j++];

        i = p;
        t = 0;
        while (i <= r) {
            count++;
            if (count == K) {
                result = tmp[t];
                break;
            }
            A[i++] = tmp[t++];
        }
    }

}