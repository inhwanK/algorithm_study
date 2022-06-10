package algorithm_study.tic.chap12;

// 자물쇠와 열쇠
public class Q10 {

    /* 자바 메모리 할당 등등 공부
    public static void main(String[] args){
        int[] a = {0,1};
        int[] b = a;

        b[0] += 1;

        System.out.println(b[0]);
        System.out.println(a[0]);
    }
     */


    // 시계 방향 90도 회전
    public static int[][] rotateKey(int[][] key) {

        int n = key.length;
        int m = key[0].length;

        int[][] newKey = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                newKey[j][n-i-1] = key[i][j];
                // 0,0 = 0,2 , 1,0 = 0,1 , 0,2 = 2,2
            }
        }

        return newKey;
    }

    // 열쇠 맞는지 확인
    public static boolean check(int[][] window) {

        int n = window.length / 3;

        for(int i = n; i < n * 2; i++){
            for(int j = n; j < n * 2; j++){
                if(window[i][j] != 1) return false;
            }
        }

        return true;
    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;

        int n = lock.length;
        int m = key.length;

        // padding
        int[][] window = new int[n * 3][n * 3];

        // window에 자물쇠 정보 저장
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                window[n + i][n + j] = lock[i][j];
            }
        }

        for(int rot = 0; rot < 4; rot++){
            key = rotateKey(key);

            // window에 필터링
            for(int i = 0; i < n * 2; i++){
                for(int j = 0; j < n * 2; j++){

                    // 열쇠 끼워보기
                    for(int x = 0; x < m; x++){
                        for(int y = 0; y < m; y++){
                            window[i + x][j + y] += key[x][y];
                        }
                    }

                    if(check(window)) return true;

                    // 자물쇠 초기화
                    for(int x = 0; x < m; x++){
                        for(int y = 0; y < m; y++){
                            window[i + x][j + y] -= key[x][y];
                        }
                    }

                }
            }
        }

        return answer;
    }

}
