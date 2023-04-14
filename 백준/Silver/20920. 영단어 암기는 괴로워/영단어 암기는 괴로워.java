import java.util.*;
import java.io.*;

/*
 * 1 초 (추가 시간 없음)	1024 MB
 * 
 * [입력]
 * 1> 단어의 개수 N[1,100000]과 외울 단어의 길이 기준이 되는 M[1,10] 
 * N> 외울 단어 (알파벳 소문자로만 주어지며 단어의 길이는 10을 넘지 않음)
 * => 화은이의 단어장에 들어 있는 단어를 단어장의 앞에 위치한 단어부터 한 줄에 한 단어씩 순서대로 출력
 * 
 * 자주 나오는 단어일수록, 해당 단어의 길이가 길수록, 알파벳 사전 순으로 앞에 있는 단어일수록
 * 길이가 M이상인 단어만 외운다
 * 
 */

public class Main{
	static int N,M;
	static Map<String, Integer> map;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new HashMap<>();
		for(int n=0; n<N; n++) {
			String tmp = br.readLine();
			if(tmp.length() >= M) {
				map.put(tmp, map.getOrDefault(tmp, 0)+1);
			}
		}
		
		List<String> words = new ArrayList<>(map.keySet());
		words.sort((o1, o2) -> {
            int c1 = map.get(o1);
            int c2 = map.get(o2);

            // 자주 나오는 단어일수록
            if(c1==c2){
            	// 해당 단어의 길이가 길수록
                if(o1.length() == o2.length()) {
                	// 알파벳 사전 순으로 앞에 있는 단어일수록
                    return o1.compareTo(o2);
                }
                return o2.length()-o1.length(); 
            }
            return c2-c1;
        });

        StringBuilder sb=new StringBuilder();
        for(int i=0; i <words.size(); i++){
            sb.append(words.get(i)).append("\n");
        }
        System.out.println(sb);
	}
}