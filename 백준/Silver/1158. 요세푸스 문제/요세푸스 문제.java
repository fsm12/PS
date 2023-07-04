import java.io.*;
import java.util.*;

public class Main {
    static int N,K,p;
    
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        for (int n=0; n<N; n++) {
            arr.add(n);
        }

        p = K-1;
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int n=0; n<N-1; n++) {
            if (p >= arr.size()) {
                p %= arr.size();
            }
            sb.append(arr.remove(p) + 1).append(", ");
            p += (K-1);
        }
        sb.append(arr.remove(0) + 1).append(">");
        
        System.out.println(sb);
    }
}