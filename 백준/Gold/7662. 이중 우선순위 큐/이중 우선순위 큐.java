import java.io.*;
import java.util.*;

// TreeMap..

public class Main {
    static int T,K,N;
    static char c;
    static TreeMap<Integer, Integer> map;

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		while(T-->0) {
			map = new TreeMap<>();
            
			K = Integer.parseInt(br.readLine());
			for (int k = 0; k < K; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				c = st.nextToken().charAt(0);
				N = Integer.parseInt(st.nextToken());
				if (c == 'I') {
					map.put(N, map.getOrDefault(N, 0) + 1);
				} else if (map.size() == 0) {
					continue;
				} else {
					int key = N == 1 ? map.lastKey() : map.firstKey();
					int cnt = map.get(key);
					if (cnt == 1) {
						map.remove(key);
					} else {
						map.put(key, cnt - 1);
					}
				}
			}

			if (map.size() == 0) {
				sb.append("EMPTY\n");
			} else {
				sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
			}
		}
		System.out.print(sb.toString());
	}
}