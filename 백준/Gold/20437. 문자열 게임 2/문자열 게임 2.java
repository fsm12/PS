import java.util.*;
import java.io.*;

/*
 * 1 초	1024 MB
 * 
 * [입력]
 * 1> 문자열 게임의 수 T (1 ≤ T ≤ 100)
 * 2> 문자열 W
	정수 K가 주어진다. (1 ≤ K ≤ |W| ≤ 10,000) 
 * => T개의 줄 동안 문자열 게임의 3번과 4번에서 구한 연속 문자열의 길이를 공백을 사이에 두고 출력
 * 		만약 만족하는 연속 문자열이 없을 시 -1을 출력
 * 
 * 3. 어떤 문자를 정확히 K개를 포함하는 가장 짧은 연속 문자열의 길이를 구한다.
 * 4. 어떤 문자를 정확히 K개를 포함하고, 문자열의 첫 번째와 마지막 글자가 해당 문자로 같은 가장 긴 연속 문자열의 길이
 * => 출력은 (3번 결과, 4번 결과) 임
 * 
 * sol)
 * 처음에 해당 알파벳이 각각 몇개 존재하는지 담아둠
 * 처음부터 순회하면서 K개 이상 품을 수 있는 알파벳을 찾으면, 해당 인덱스 기점으로 나머지 K-1개를 찾아서 길이를 갱신함
 * 
 */

public class Main {
	static int T,K,min_val,max_val;
	static String W;
	static int[] alpha;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
    	// System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            
            W = br.readLine();
            
            K = Integer.parseInt(br.readLine());
            if (K==1) {
                sb.append("1 1").append("\n");
                continue;
            }
            
            alpha = new int[26];
            for (int w=0; w<W.length(); w++) {
                alpha[W.charAt(w) - 97]++;
            }
            
            // K개를 포함하는 문자의 시작점을 찾는데
            for (int w=0; w<=W.length()-K; w++) {
                char start = W.charAt(w);
                // 해당 문자가 K개 이상 존재했다면
                if (alpha[start - 97] >= K) {
                	// 현재 w를 시작점으로 잡음
                    int cnt = 1;
                    // w위치 알파벳과 같은 알파벳을 찾기위해 해당 문자열을 순회하고
                    for (int j = w + 1; j < W.length(); j++) {
                        char cur = W.charAt(j);
                        // 같으면 cnt값 증가
                        if (start == cur) {
                            cnt++;
                            // K개 전부 찾았다면
                            if (cnt == K) {
                            	// 길이 갱신
                                int len = (j - w) + 1;
                                min = Math.min(min, len);
                                max = Math.max(max, len);
                                break;
                            }
                        }
                    }
                }
            }
            
            if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
                sb.append("-1");
            } else {
                sb.append(min).append(" ").append(max);
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }
}
