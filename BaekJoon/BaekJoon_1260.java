
// 백준 1260번: DFS와 BFS (Silver 2)
import java.util.*;
import java.io.*;

public class BaekJoon_1260 {
    static int startNode = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int lineCount = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] nodeList = new ArrayList[nodeCount + 1];
        for (int i = 0; i <= nodeCount; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < lineCount; i++) {
            st = new StringTokenizer(br.readLine());
            int fromNode = Integer.parseInt(st.nextToken());
            int toNode = Integer.parseInt(st.nextToken());
            nodeList[fromNode].add(toNode);
            nodeList[toNode].add(fromNode);
        }

        for (int i = 1; i <= nodeCount; i++) {
            Collections.sort(nodeList[i]);
        }

        // 결과 출력을 위한 준비
        visited = new boolean[nodeCount + 1];
        dfs(nodeList, startNode);
        System.out.println();

        visited = new boolean[nodeCount + 1];
        bfs(nodeList, startNode);
        System.out.println();
    }

    public static void dfs(ArrayList<Integer>[] nodeList, int current) {
        visited[current] = true;
        System.out.print(current + " ");

        for (int next : nodeList[current]) {
            if (!visited[next]) {
                dfs(nodeList, next);
            }
        }
    }

    public static void bfs(ArrayList<Integer>[] nodeList, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int next : nodeList[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
