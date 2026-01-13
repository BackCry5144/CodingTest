// 백준 2805번: 나무 자르기 (Silver 2)
// 핵심 알고리즘: 이분 탐색 (Binary Search / Parametric Search)

import java.io.*;
import java.util.*;

public class BaekJoon_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > max)
                max = trees[i];
        }

        long low = 0;
        long high = max;
        long result = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            long sum = 0;

            for (int tree : trees) {
                if (tree > mid) {
                    sum += (tree - mid);
                }
            }

            if (sum >= M) {
                result = mid; // 가능한 높이 저장
                low = mid + 1; // 더 높은 높이를 찾아봄
            } else {
                high = mid - 1; // 높이를 낮춰서 더 많은 나무를 자름
            }
        }

        System.out.println(result);
    }
}
