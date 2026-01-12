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
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int SIZE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SIZE = Integer.parseInt(br.readLine());

    }
}
