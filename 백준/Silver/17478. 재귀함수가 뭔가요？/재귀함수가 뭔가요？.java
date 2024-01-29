import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		recursive(0,N);
		
		System.out.print(sb.toString());
	}
	
	public static void recursive(int k, int n) {
        if (n >= k + 1) {
            sb.append(String.format("%s\"재귀함수가 뭔가요?\"\n%s\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n%s마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n%s그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"%n",
                    "____".repeat(k), "____".repeat(k), "____".repeat(k), "____".repeat(k)));
            recursive(k + 1, n);
            sb.append(String.format("%s라고 답변하였지.%n", "____".repeat(k)));
        } else {
            sb.append(String.format("%s\"재귀함수가 뭔가요?\"\n%s\"재귀함수는 자기 자신을 호출하는 함수라네\"\n%s라고 답변하였지.%n",
                    "____".repeat(k), "____".repeat(k), "____".repeat(k)));
        }
    }
}