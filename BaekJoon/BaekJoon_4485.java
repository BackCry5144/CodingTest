// 백준 4485번: 녹색 옷 입은 애가 젤다지? (Gold 4)
// 핵심 알고리즘: 다익스트라 (Dijkstra)

import java.io.*;
import java.util.*;

public class BaekJoon_4485 {

    // 다익스트라 구현 시 우선순위 큐 사용을 위한 Node Class 정의
    static class Node implements Comparable<Node> {
        int row, col; // 좌표
        int weight; // 가중치

        Node(int row, int col, int weight) {
            this.row = row;
            this.col = col;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    // 하, 우, 상, 좌 좌표정의
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int caseNum = 1;

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;

            int[][] map = new int[N][N];
            int[][] dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            int minRupee = solve(N, map, dist);
            sb.append("Problem ").append(caseNum++).append(": ").append(minRupee).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int solve(int N, int[][] map, int[][] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[0][0] = map[0][0];
        pq.offer(new Node(0, 0, map[0][0]));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.weight > dist[curr.row][curr.col])
                continue;

            for (int i = 0; i < 4; i++) {
                int nr = curr.row + dr[i];
                int nc = curr.col + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (dist[nr][nc] > dist[curr.row][curr.col] + map[nr][nc]) {
                        dist[nr][nc] = dist[curr.row][curr.col] + map[nr][nc];
                        pq.offer(new Node(nr, nc, dist[nr][nc]));
                    }
                }
            }
        }

        return dist[N - 1][N - 1];
    }
}
