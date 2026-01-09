
// 백준 2178번: 미로 탐색 (Silver 1)
import java.util.*;
import java.io.*;

public class BaekJoon_2178 {

    static int[] dirRow = { 0, 1, 0, -1 };
    static int[] dirCol = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 주변 4칸 탐색.
        // 4방향 중 갈 수 있는 방향으로 깊이 우선 탐색
        // 진행과정을 배열에 입력.
        // 이미 방문한 곳은 갈 수 없음.
        // 재귀의 종료는 목표 좌표에 도착하면 끝.
        // 재귀 종료 시, 저장 된 경로 배열에서 경로 숫자 체크하여 최소값을 계속 업데이트.
        // 종료 후 출력
    }
}
