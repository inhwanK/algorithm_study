package algorithm_study.programers.level1;

import java.util.*;

public class Pro250121 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};

        int idx = 0;
        if (ext.equals("code")) {
            idx = 0;
        } else if (ext.equals("date")) {
            idx = 1;
        } else if (ext.equals("maximum")) {
            idx = 2;
        } else {
            idx = 3;
        }

        int[][] arr = new int[data.length][4];
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i][idx] < val_ext) {
                arr[count] = data[i];
                count++;
            }
        }

        if (sort_by.equals("code")) {
            idx = 0;
        } else if (sort_by.equals("date")) {
            idx = 1;
        } else if (sort_by.equals("maximum")) {
            idx = 2;
        } else {
            idx = 3;
        }

        ArrayList<Integer> list = sort(arr, sort_by, count);
        answer = new int[count][4];

        int index = 0;
        while (index < count) {
            for (int i = 0; i < count; i++) {
                if (index >= count) {
                    break;
                }
                if (list.get(index) == arr[i][idx]) {
                    answer[index] = arr[i];
                    index++;
                }
            }
        }

        return answer;
    }

    private ArrayList<Integer> sort(int[][] data, String sort_by, int count) {
        ArrayList<Integer> list = new ArrayList();

        int idx;
        if (sort_by.equals("code")) {
            idx = 0;
        } else if (sort_by.equals("date")) {
            idx = 1;
        } else if (sort_by.equals("maximum")) {
            idx = 2;
        } else {
            idx = 3;
        }

        for (int i = 0; i < count; i++) {
            list.add(data[i][idx]);
        }
        Collections.sort(list);

        return list;
    }


    public int[][] solution2(int[][] data, String ext, int val_ext, String sort_by) {
        int sort_by_Num = 0; // sortBy 인덱스 구하기

        String[] dataArr = {"code", "date", "maximum", "remain"};
        int extNum = 0; // ext의 인덱스 구하기

        for (int i = 0; i < dataArr.length; i++) {
            if (dataArr[i].equals(ext)) {
                extNum = i;
            }
            if (dataArr[i].equals(sort_by)) {
                sort_by_Num = i;
            }
        }

        List<Integer[]> dataList = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i][extNum] < val_ext) {
                dataList.add(Arrays.stream(data[i]).boxed().toArray(Integer[]::new));
            }
        }

        Collections.sort(dataList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] arr1, Integer[] arr2) {
                // 특정 인덱스의 값으로 비교하여 정렬
                return Integer.compare(arr1[sort_by_Num], arr2[sort_by_Num]);
            }
        });

        int[][] answer = new int[dataList.size()][dataList.get(0).length];
        for (int i = 0; i < dataList.size(); i++) {
            answer[i] = Arrays.stream(dataList.get(i))
                    .mapToInt(Integer::intValue)
                    .toArray();
        }

        return answer;
    }
}
