// 백준 2470번: 두 용액 (Gold 5)
// 핵심 알고리즘: 투 포인터 (Two Pointers)

import java.io.*;
import java.util.*;

public class BaekJoon_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int minDiff = Integer.MAX_VALUE;
        int ans1 = 0, ans2 = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            int diff = Math.abs(sum);

            if (diff < minDiff) {
                minDiff = diff;
                ans1 = arr[left];
                ans2 = arr[right];
            }

            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                break;
            }
        }

        System.out.println(ans1 + " " + ans2);
    }
}
