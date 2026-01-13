// 백준 1654번: 랜선 자르기 (Silver 2)
// 핵심 알고리즘: 이분 탐색 (Binary Search / Parametric Search)

import java.io.*;
import java.util.*;

public class BaekJoon_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] cables = new int[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            cables[i] = Integer.parseInt(br.readLine());
            if (cables[i] > max)
                max = cables[i];
        }

        // 1부터 시작 (나누기 0 방지)
        long low = 1;
        long high = max;
        long result = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            long count = 0;

            for (int cable : cables) {
                count += (cable / mid);
            }

            if (count >= N) {
                result = mid; // 가능한 길이 저장
                low = mid + 1; // 더 긴 길이를 찾아봄
            } else {
                high = mid - 1; // 길이를 줄여서 더 많은 개수를 만듦
            }
        }

        System.out.println(result);
    }
}
