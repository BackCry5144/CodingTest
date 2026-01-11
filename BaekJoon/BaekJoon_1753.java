
// 백준 1753번: 최단경로 (Gold 4)
// 핵심 알고리즘: 다익스트라 (Dijkstra)
import java.util.*;
import java.io.*;

public class BaekJoon_1753 {

    // 노드 정보를 저장하기 위한 클래스
    static class Node implements Comparable<Node> {
        int target; // 목적지 노드 번호
        int weight; // 해당 노드까지 가는 가중치(거리)

        Node(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        // 우선순위 큐에서 '가중치가 작은 것'이 먼저 나오도록 설정
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static int V, E, K;
    static ArrayList<Node>[] graph; // 인접 리스트
    static int[] distance; // 시작점으로부터의 최단 거리를 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수
        K = Integer.parseInt(br.readLine()); // 시작 정점 번호

        // 1. 그래프 및 거리 배열 초기화
        graph = new ArrayList[V + 1];
        distance = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE; // 아주 큰 값으로 초기화 (무한대)
        }

        // 2. 간선 정보 입력 받기
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 출발
            int v = Integer.parseInt(st.nextToken()); // 도착
            int w = Integer.parseInt(st.nextToken()); // 가중치
            graph[u].add(new Node(v, w));
        }

        // 3. 다익스트라 수행
        dijkstra(K);

        // 4. 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                sb.append("INF\n");
            else
                sb.append(distance[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static void dijkstra(int start) {
        // 우선순위 큐: 가장 거리가 짧은 노드를 먼저 꺼내기 위해 사용
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 탐색 시작 노드 설정
        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.target;
            int dist = current.weight;

            // 이미 처리된 적이 있고, 현재 거리보다 더 짧은 경로를 알고 있다면 무시
            if (distance[now] < dist)
                continue;

            // 현재 노드와 연결된 다른 인접 노드들을 확인
            for (Node next : graph[now]) {
                int cost = distance[now] + next.weight;

                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < distance[next.target]) {
                    distance[next.target] = cost;
                    pq.offer(new Node(next.target, cost));
                }
            }
        }
    }
}
