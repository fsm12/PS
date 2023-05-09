import java.util.*;
import java.io.*;

public class Main{
	static int N;
	static Deque<Integer> dq;
	static Integer front, back;
	
	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		dq = new ArrayDeque<Integer>();
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front":
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    continue;
                case "push_back":
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    continue;
                case "pop_front":
                    front = dq.pollFirst();
                    if (front != null) {
                        sb.append(front);
                    } else {
                        sb.append(-1);
                    }
                    break;
                case "pop_back":
                    back = dq.pollLast();
                    if (back != null) {
                        sb.append(back);
                    } else {
                        sb.append(-1);
                    }
                    break;
                case "size":
                    sb.append(dq.size());
                    break;
                case "empty":
                    if (dq.isEmpty() == true) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    break;
                case "front":
                    front = dq.peekFirst();
                    if (front != null) {
                        sb.append(front);
                    } else {
                        sb.append(-1);
                    }
                    break;
                case "back":
                    back = dq.peekLast();
                    if (back != null) {
                        sb.append(back);
                    } else {
                        sb.append(-1);
                    }
                    break;
            }
            sb.append("\n");
        }
        System.out.print(sb);
	}
}