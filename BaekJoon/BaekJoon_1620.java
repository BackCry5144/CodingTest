
// 백준 1620번:  나는야 포켓몬 마스터 이다솜 (Silver 4)
import java.io.*;
import java.util.*;

public class BaekJoon_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 포켓몬 수
        int M = Integer.parseInt(st.nextToken()); // 맞춰야 할 문제 수

        Map<String, Integer> nameToNum = new HashMap<>();
        String[] numToName = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameToNum.put(name, i);
            numToName[i] = name;
        }

        for (int i = 0; i < M; i++) {
            String question = br.readLine();
            if (Character.isDigit(question.charAt(0))) {
                // 숫자면 배열에서 바로 꺼냄
                System.out.println(numToName[Integer.parseInt(question)]);
            } else {
                // 이름이면 맵에서 바로 꺼냄
                System.out.println(nameToNum.get(question));
            }
        }
    }
}
