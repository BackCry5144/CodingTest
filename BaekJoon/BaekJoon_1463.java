// 백준 1463번: 1로 만들기 (Silver 3)
// 핵심 알고리즘: 다이나믹 프로그래밍 (Dynamic Programming)

import java.io.*;
import java.util.*;

public class BaekJoon_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        // dp[1] = 0
        for (int i = 2; i <= N; i++) {
            // 기본은 1을 빼는 경우
            dp[i] = dp[i - 1] + 1;

            // 2로 나누어 떨어지는 경우
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 3로 나누어 떨어지는 경우
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}
