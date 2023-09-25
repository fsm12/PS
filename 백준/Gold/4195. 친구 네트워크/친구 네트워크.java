import java.util.*;
import java.io.*;

public class Main{
	static int T,F;
	static Map<String, String> parent;
	static Map<String, Integer> size;

	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(T-->0){
			F = Integer.parseInt(br.readLine());
			parent = new HashMap<>();
			size = new HashMap<>();
			for(int f=0; f<F; f++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String n1 = st.nextToken();
				String n2 = st.nextToken();
				
				union(n1, n2);
				sb.append(size.get(find(n1))).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static String find(String x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
            size.put(x, 1);
            return x;
        }

        if (x.equals(parent.get(x)))
            return x;
        else {
            String root = find(parent.get(x));
            parent.put(x, root);
            return root;
        }
    }
	
	static void union(String a, String b) {
        a = find(a);
        b = find(b);

        if (!a.equals(b)) {
            parent.put(b, a);
            size.put(a, size.getOrDefault(a, 1) + size.getOrDefault(b, 1));
        }
    }
}