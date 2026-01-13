// 백준 2579번: 계단 오르기 (Silver 3)
// 핵심 알고리즘: 다이나믹 프로그래밍 (Dynamic Programming)

import java.io.*;
import java.util.*;

public class BaekJoon_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] scores = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(scores[1]);
            return;
        }

        int[] dp = new int[N + 1];
        dp[1] = scores[1];
        dp[2] = scores[1] + scores[2];

        for (int i = 3; i <= N; i++) {
            // i번째 계단으로 오는 두 가지 경우:
            // 1. i-2번째에서 2계단 뛰어오는 경우 (dp[i-2] + scores[i])
            // 2. i-3번째에서 2계단 뛰고 i-1번째 밟고 i번째 밟는 경우 (dp[i-3] + scores[i-1] + scores[i])
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + scores[i - 1]) + scores[i];
        }

        System.out.println(dp[N]);
    }
}
