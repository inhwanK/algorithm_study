package algorithm_study.tic.chap13;


// 순열과 조합 알고리즘 정리된 블로그
//https://velog.io/@cgw0519/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%88%9C%EC%97%B4-%EC%A4%91%EB%B3%B5%EC%88%9C%EC%97%B4-%EC%A1%B0%ED%95%A9-%EC%A4%91%EB%B3%B5%EC%A1%B0%ED%95%A9-%EC%B4%9D%EC%A0%95%EB%A6%AC
class Combination {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int r = 2;
        combination(arr, new boolean[arr.length], 0, 0, r);
    }

    // 조합, visited로 중복 체크, start 변수를 증가 시키면서 이미 뽑은 값을 제외
    public static void combination(int[] arr, boolean[] visited, int start, int depth, int r) {
        if (depth == r) {
            for (int i = 0; i < arr.length; i++) {
                // 방문한 수만 출력
                if (visited[i] == true) System.out.println(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        // 이전 depth에서 골랐던 수는 고르지 않음
        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(arr, visited, i + 1, depth + 1, r);
                visited[i] = false; // 이걸 해줘야 다음 depth에서 선택할 수 있음
            }
        }
    }

    // 중복 조합, 조합에서 visited 대신 out이 들어감
    public static void dupCombination(int[] arr, int[] out, int start, int depth, int r) {
        if (depth == r) {
            for (int num : out) System.out.print(num + " ");
            System.out.println();
            return;
        }

        for (int i = start; i < arr.length; i++) {
            out[depth] = arr[i];
            dupCombination(arr, out, i + 1, depth + 1, r);
        }
    }
}

// 순열
class Permutation {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int r = 2;
//        permutation(arr, new int[r], new boolean[arr.length], 0, r);
        dupPermutation(arr, new int[r], 0, r);
    }

    // 순열 알고리즘 : 재귀
    public static void permutation(int[] arr, int[] out, boolean[] visited, int depth, int r) {
        // 깊이, 즉 r개의 수를 다 골랐다면 출력
        if (depth == r) {
            for (int num : out) System.out.print(num + " ");
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, out, visited, depth + 1, r);
                visited[i] = false; // 이거 하는 이유가 뭐야?
            }
        }
    }

    // 중복 순열 알고리즘 : 재귀
    public static void dupPermutation(int[] arr, int[] out, int depth, int r) {
        if (depth == r) {
            for (int num : out) System.out.print(num + " ");
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            out[depth] = arr[i];
            dupPermutation(arr, out, depth + 1, r);
        }
    }
}
