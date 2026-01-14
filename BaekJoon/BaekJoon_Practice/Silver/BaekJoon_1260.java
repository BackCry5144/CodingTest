// 백준 1260번: DFS와 BFS (Silver 2)
package BaekJoon_Practice.Silver;

import java.util.*;
import java.io.*;

public class BaekJoon_1260 {

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 입력 값 저장
        // 1 Line 정보
        int nodeCnt = Integer.parseInt(st.nextToken());
        int lineCnt = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] nodeList = new ArrayList[nodeCnt + 1];
        for (int i = 1; i <= nodeCnt; i++) {
            nodeList[i] = new ArrayList<>();
        }

        // 2 Line ~ 끝(연결 노드 정보)
        for (int i = 1; i <= lineCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int fromNode = Integer.parseInt(st.nextToken());
            int toNode = Integer.parseInt(st.nextToken());
            nodeList[fromNode].add(toNode);
            nodeList[toNode].add(fromNode);
        }
        // 2. 정렬
        for (int i = 1; i < nodeList.length; i++) {
            Collections.sort(nodeList[i]);
        }

        // 3. DFS
        visited = new boolean[nodeCnt + 1];
        dfs(nodeList, startNode);
        System.out.println();

        // 4. BFS
        visited = new boolean[nodeCnt + 1];
        bfs(nodeList, startNode);
    }

    static void dfs(ArrayList<Integer>[] nodeList, int startNode) {
        System.out.print(startNode + " ");
        visited[startNode] = true;
        for (int next : nodeList[startNode]) {
            if (!visited[next]) {
                dfs(nodeList, next);
            }
        }
    }

    static void bfs(ArrayList<Integer>[] nodeList, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        visited[startNode] = true; // Start시 방문 처리
        queue.offer(startNode);

        while (!queue.isEmpty()) {

            int currentNode = queue.poll();
            System.out.print(currentNode + " ");
            for (int nextNode : nodeList[currentNode]) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }
    }
}
