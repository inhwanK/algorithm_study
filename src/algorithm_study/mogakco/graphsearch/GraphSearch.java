package algorithm_study.mogakco.graphsearch;

public class GraphSearch {
    public static void main(String[] args) {
        GraphEx graph = new GraphEx();
        dfs(graph, 0);
        bfs(graph, 0);
    }

    static void dfs(GraphEx graph, int node) {
        System.out.println(node + " ");
        graph.visited[node] = 1;

        for (int i = 0; i < graph.nodeCount; i++) {
            if (graph.graph[node][i] == 1 && graph.visited[i] == 0) {
                dfs(graph, i);
            }
        }
    }

    static void bfs(GraphEx graph, int node) {
        Queue queue = new Queue();
        graph.visited[node] = 1;
        System.out.print(node + " ");
        queue.enqueue(node);

        while (!queue.is_empty()) {
            int v = queue.dequeue();

            for (int w = 0; w < graph.nodeCount; w++) {
                if (graph.graph[v][w] == 1 && graph.visited[w] == 0) {
                    graph.visited[w] = 1;
                    System.out.printf("%d", w);
                    queue.enqueue(w);
                }
            }
        }

    }

}

class GraphEx {

    int nodeCount = 7;
    int[] visited = {0, 0, 0, 0, 0, 0, 0};

    int[][] graph = {
            {0, 1, 0, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0}
    };
}

class Queue {
    private int MAX_QUEUE_SIZE = 10;
    private int queue[];
    private int head;
    private int tail;

    public Queue() {
        head = -1;
        tail = -1;
        queue = new int[MAX_QUEUE_SIZE];
    }

    boolean is_empty() {
        if (head == tail) {
            return true;
        }
        return false;
    }

    boolean is_full() {
        if ((tail + 1) % MAX_QUEUE_SIZE == head) {
            return true;
        }
        return false;
    }

    void enqueue(int item) {
        if (this.is_full()) {
            System.out.println("큐에 더이상 데이터를 넣을 수 없습니다.\n");
            return;
        }
        tail = (tail + 1) % MAX_QUEUE_SIZE;
        queue[tail] = item;
    }

    int dequeue() {
        if (is_empty()) {
            System.out.println("큐가 비어있습니다. \n");
            return -1;
        }
        head = (head + 1) % MAX_QUEUE_SIZE;
        return queue[head];
    }
}