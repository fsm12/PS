import java.util.*;
import java.io.*;

public class Main{
	static int N,M;
	static Map<String, Integer> map;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("input.txt"));
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

            if(c1==c2){
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o2.length()-o1.length(); 
            }
            return c2-c1;
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i <words.size(); i++){
            sb.append(words.get(i)).append("\n");
        }
        System.out.println(sb);
	}
}