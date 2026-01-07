import java.io.*;
import java.util.*;
import java.util.function.IntBinaryOperator;

public class BaekJoon_14888_Pro {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader(System.in);

        // 1. 입력 데이터를 객체 생성을 통해 바로 전달
        int n = fr.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++)
            numbers[i] = fr.nextInt();

        int[] operators = new int[4];
        for (int i = 0; i < 4; i++)
            operators[i] = fr.nextInt();
        // 2. 문제를 해결하는 '객체' 생성 (캡슐화)
        OperatorSolver solver = new OperatorSolver(numbers, operators);
        solver.solve();

        // 3. 결과 출력
        solver.printResults();
    }
}

class OperatorSolver {
    private final int[] numbers;
    private final int[] currentOps;
    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;
    // 연산 로직을 배열에 담아 'if-else' 없이 인덱스로 접근 (람다식 활용)
    private static final IntBinaryOperator[] CALCULATORS = {
            (a, b) -> a + b,
            (a, b) -> a - b,
            (a, b) -> a * b,
            (a, b) -> a / b
    };

    public OperatorSolver(int[] numbers, int[] operators) {
        this.numbers = numbers;
        this.currentOps = operators;
    }

    public void solve() {
        dfs(numbers[0], 1);
    }

    private void dfs(int currentSum, int idx) {
        if (idx == numbers.length) {
            max = Math.max(max, currentSum);
            min = Math.min(min, currentSum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (currentOps[i] > 0) {
                currentOps[i]--;
                // CALCULATORS[i]를 호출함으로써 코드의 가독성과 확장성을 확보
                dfs(CALCULATORS[i].applyAsInt(currentSum, numbers[idx]), idx + 1);
                currentOps[i]++;
            }
        }
    }

    public void printResults() {
        System.out.println(max);
        System.out.println(min);
    }
}

// 고수들이 쓰는 전형적인 입출력 최적화 클래스
class FastReader {
    private BufferedReader br;
    private StringTokenizer st;

    public FastReader(InputStream is) {
        br = new BufferedReader(new InputStreamReader(is));
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}