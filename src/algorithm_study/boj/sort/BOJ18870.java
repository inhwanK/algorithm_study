package algorithm_study.boj.sort;

import java.io.*;
import java.util.*;

// 좌표 압축 - https://www.acmicpc.net/problem/18870
public class BOJ18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        int[] arr = new int[n];
        for (int num = 0; num < n; num++) {
            arr[num] = Integer.parseInt(input[num]);
        }
        Arrays.sort(arr);

        int count = 0;
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) continue;
            map.put(arr[i], String.valueOf(count));
            count++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(input[i]);
            sb.append(map.get(index)).append(" ");
        }
        bw.write(sb + "");
        bw.flush();

        br.close();
        bw.close();
    }
}

// 퀵 소트를 이용한 문제 풀이
class BOJ18870Quick {
    public static int[] arr;
    public static String[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }

        arr = new int[set.size()];
        for (int i = 0; i < set.size(); i++) {
            arr[i] = set.iterator().next();
        }


        result = new String[n];


    }

    public static void quick(int pivot, int left, int right, int length) {
        if (length == 1) {
            return;
        }

        while (left < right) {
            if (arr[left] <= arr[pivot]) left++;
            if (arr[right] > arr[pivot]) right--;
            if (arr[left] > arr[pivot] && arr[right] < arr[pivot]) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        int temp = arr[right];
        arr[right] = arr[pivot];
        arr[pivot] = temp;

        quick(pivot, pivot + 1, right - 1, (right - 1) - pivot);
        result[right] += arr[right] + " ";
        quick(right + 1, right + 2, length - 1, length - (right + 1));
    }
}

// 퀵소트를 이용한 풀이
// 상위 정답 - https://www.acmicpc.net/source/19708709
class BOJ18870Answer {
    public static void sort(int[] data, int l, int r) {
        int left = l;
        int right = r;
        int pivot = data[(l + r) / 2];

        do {
            while (data[left] < pivot) left++;
            while (data[right] > pivot) right--;
            if (left <= right) {
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        } while (left <= right);

        if (l < right) sort(data, l, right);
        if (r > left) sort(data, left, r);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter outp = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(inp.readLine());
        String[] s = inp.readLine().split(" ");
        int[] orgLst = new int[n];
        int[] sortLst = new int[n];
        int[] contract = new int[n];

        for (int i = 0; i < n; i++) orgLst[i] = sortLst[i] = Integer.parseInt(s[i]);

        sort(sortLst, 0, n - 1);

        int count = 0;
        contract[0] = sortLst[0];

        for (int i = 1; i < n; i++) {
            if (contract[count] != sortLst[i]) contract[++count] = sortLst[i];
        }

        int left, right, mid = 0;

        for (int i = 0; i < n; i++) {
            left = 0;
            right = count;
            while (left <= right) {
                mid = (left + right) / 2;
                if (contract[mid] == orgLst[i]) {
                    break;
                } else if (contract[mid] < orgLst[i]) left = mid + 1;
                else right = mid - 1;
            }
            outp.write(Integer.toString(mid) + " ");
        }

        outp.flush();
    }
}

// map과 quicksort를 같이 이용함
// 상위 정답 - https://www.acmicpc.net/source/28174005
class BOJ18870Answer_2 {

    public static void main(String[] args) throws Exception {

        int N = read();
        int[] list = new int[N];
        int[] sort = new int[N];

        for (int i = 0; i < N; i++)
            list[i] = sort[i] = read();

        quickSort(sort, 0, N - 1);

        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 0;

        for (int i = 0; i < N; i++) {
            int n = sort[i];
            if (!map.containsKey(n)) map.put(n, idx++);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            sb.append(map.get(list[i])).append(' ');

        System.out.print(sb);

    }

    private static void quickSort(int[] list, int l, int r) {

        if (l >= r) return;

        int m = partition(list, l, r);
        quickSort(list, l, m-1);
        quickSort(list, m, r);

    }


    private static int partition(int[] list, int l, int r) {

        int p = list[(l+r)>>1];

        while (l <= r) {

            while (list[l] < p) l++;
            while (list[r] > p) r--;

            if (l <= r) swap(list, l++, r--);

        }

        return l;

    }

    private static void swap(int[] list, int a, int b) {
        int t = list[a];
        list[a] = list[b];
        list[b] = t;
    }


    /**
     * Input Process
     * @see https://blog.naver.com/jihogrammer/222281999239
     */
    private static int read() throws Exception {

        int c, N = System.in.read() - 48;

        if (N + 48 == '-') { // 음수 처리
            N = 0;
            while ((c = System.in.read()) > 32) N = 10 * N - c + 48;
        } else while ((c = System.in.read()) > 32) N = 10 * N + c - 48; // 양수 처리

        if (c == 13) System.in.read(); // For CRLF

        return N;

    }

}