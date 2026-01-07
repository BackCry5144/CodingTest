
// 백준 14888번: 연산자 끼워넣기 (Silver 1)
import java.util.*;
import java.io.*;

public class BaekJoon_14888 {

    static int numberCnt = 0;
    static int[] operator = new int[4];
    static int[] numbers = null;

    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        // 여기에 연산자 끼워넣기 풀이를 작성할 예정입니다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄을 읽어와서 공백으로 나눔

        // 수의 갯수 저장
        numberCnt = Integer.parseInt(st.nextToken());
        if (numberCnt < 2 || numberCnt > 11) {
            System.out.println("계산할 숫자의 갯수는 2~11개 범위내에서 입력하여야 합니다.");
            return;
        }

        // 수 저장
        st = new StringTokenizer(br.readLine());
        numbers = new int[numberCnt];
        for (int i = 0; i < numberCnt; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        if (numbers.length != numberCnt) {
            System.out.println("입력하신 숫자의 갯수가 설정한 숫자의 갯수와 다릅니다.");
            return;
        }

        // 연산자 저장
        // 0 : +, 1 : -, 2 : *, 3 : %
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        // 재귀 함수
        dfs(numbers[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int num, int numIdx) {
        // 현재 인덱스가 입력한 숫자의 갯수와 같으면 종료
        if (numIdx == numberCnt) {
            MIN = Math.min(MIN, num);
            MAX = Math.max(MAX, num);
            return;
        }

        // 연산자 하나씩 확인 할 것
        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                if (i == 0) {
                    dfs(num + numbers[numIdx], numIdx + 1);
                } else if (i == 1) {
                    dfs(num - numbers[numIdx], numIdx + 1);
                } else if (i == 2) {
                    dfs(num * numbers[numIdx], numIdx + 1);
                } else if (i == 3) {
                    dfs(num / numbers[numIdx], numIdx + 1);
                }
                // 사용한 연산자 하나 증가
                operator[i]++;
            }
        }
    }
}
