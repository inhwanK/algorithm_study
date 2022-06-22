package algorithm_study.tic.chap13;

import java.util.ArrayList;
import java.util.Scanner;

/* 이건 블로그에 기록할까?
5
X S X X T
T X S X X
X X X X X
X T X X X
X X T X X

4
S S S T
X X X X
X X X X
T T T X
*/
// 감시피하기 - 정답이랑 코드 동일함
public class Q20 {
    public static int n; // 복도의 크기
    public static char[][] board = new char[6][6]; // 복도 정보 (N x N)
    public static ArrayList<Position> teachers = new ArrayList<>(); // 모든 선생님 위치 정보
    public static ArrayList<Position> spaces = new ArrayList<>(); // 모든 빈 공간 위치 정보

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.next().charAt(0);
                // 선생님이 존재하는 위치 저장
                if (board[i][j] == 'T') {
                    teachers.add(new Position(i, j));
                }

                if (board[i][j] == 'X') {
                    spaces.add(new Position(i, j));
                }
            }
        }

        PositionCombination comb = new PositionCombination(spaces.size(), 3);
        comb.combination(spaces, 0, 0, 0);
        ArrayList<ArrayList<Position>> spaceList = comb.getResult();

        // 학생이 한 명도 감지되지 않도록 설치할 수 있는지의 여부
        boolean found = false;
        for (int i = 0; i < spaceList.size(); i++) {
            for (int j = 0; j < spaceList.get(i).size(); j++) {
                int x = spaceList.get(i).get(j).getI();
                int y = spaceList.get(i).get(j).getJ();
                board[x][y] = 'O';
            }
            //학생이 한 명도 감지되지 않는 경우
            if (!process()) {
                // 원하는 경우를 발견한 것임
                found = true;
                break;
            }
            // 설치된 장애물을 다시 없애기
            for (int j = 0; j < spaceList.get(i).size(); j++) {
                int x = spaceList.get(i).get(j).getI();
                int y = spaceList.get(i).get(j).getJ();
                board[x][y] = 'X';
            }
        }

        if (found) System.out.println("YES");
        else System.out.println("NO");
    }

    public static boolean process() {
        // 모든 선생의 위치를 하나씩 확인
        for (int i = 0; i < teachers.size(); i++) {
            int x = teachers.get(i).getI();
            int y = teachers.get(i).getJ();

            // 4가지 방향으로 학생을 감지할 수 있는지 확인
            for (int direction = 0; direction < 4; direction++) {
                if (watch(x, y, direction)) {
                    return true;
                }
            }
        }

        return false;
    }

    // 특정 방향으로 감시를 진행 (학생 발견 : true, 학생 미발견: false)
    public static boolean watch(int x, int y, int direction) {
        // 왼쪽 방향으로 감시
        if (direction == 0) {
            while (y >= 0) {
                if (board[x][y] == 'S') return true;
                if (board[x][y] == 'O') return false;

                y -= 1;
            }
        }

        // 오른쪽 방향으로 감시
        if (direction == 1) {
            while (y < 0) {
                if (board[x][y] == 'S') return true;
                if (board[x][y] == 'O') return false;

                y += 1;
            }
        }
        if (direction == 2) {
            while (x >= 0) {
                if (board[x][y] == 'S') return true;
                if (board[x][y] == 'O') return false;

                x -= 1;
            }
        }

        if (direction == 3) {
            while (x < 0) {
                if (board[x][y] == 'S') return true;
                if (board[x][y] == 'O') return false;

                x += 1;
            }
        }

        return false;
    }

}

class PositionCombination {
    private int n;
    private int r;
    private int[] now; // 현재 조합
    private ArrayList<ArrayList<Position>> result; // 모든 조합

    public ArrayList<ArrayList<Position>> getResult() {
        return result;
    }

    public PositionCombination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Position>>();
    }

    // 위치 정보를 담은 리스트에서 여러개를 고르는 조합
    public void combination(ArrayList<Position> arr, int depth, int index, int target) {
        if (depth == r) {
            ArrayList<Position> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(arr.get(now[i]));
            }
            result.add(temp);
            return;
        }
        if (target == n) return;
        now[index] = target;
        combination(arr, depth + 1, index + 1, target + 1);
        combination(arr, depth, index, target + 1);
    }
}

class Position {
    private int i;
    private int j;

    public Position(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return this.i;
    }

    public int getJ() {
        return this.j;
    }
}