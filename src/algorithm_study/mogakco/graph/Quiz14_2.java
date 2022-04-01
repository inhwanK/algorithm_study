package algorithm_study.mogakco.graph;

class Graph {

    int[][] graph = new int[4][4];

    void insert(int givingNode, int givenNode, int weight, int direction) {
        this.graph[givingNode][givenNode] = weight;
        this.graph[givenNode][givingNode] = weight;
    }
}

public class Quiz14_2 {
    public static void main(String[] args) {

        Graph adjMat = new Graph();
        adjMat.insert(0, 1, 1, 1);
        adjMat.insert(0, 3, 1, 1);
        adjMat.insert(1, 2, 1, 1);
        adjMat.insert(1, 3, 1, 1);
        adjMat.insert(2, 3, 1, 1);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(adjMat.graph[i][j] + " ");
            }
            System.out.println();
        }

    }
}
