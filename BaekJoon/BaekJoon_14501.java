// 백준 14501번: 퇴사 (Silver 3)
// 핵심 알고리즘: 다이나믹 프로그래밍 (DP)

import java.io.*;
import java.util.*;

public class BaekJoon_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i] 는 i번째 날부터 퇴사날까지 벌 수 있는 최대 수익
        int[] dp = new int[N + 2];

        for (int i = N; i >= 1; i--) {
            int nextDay = i + T[i];

            if (nextDay <= N + 1) {
                // 오늘 일을 하는 경우와 하지 않는 경우 중 최대값 선택
                dp[i] = Math.max(dp[i + 1], P[i] + dp[nextDay]);
            } else {
                // 오늘 일을 할 수 없는 경우 (기간 초과)
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);
    }
}
