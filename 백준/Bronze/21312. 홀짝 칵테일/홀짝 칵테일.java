import java.util.*;
import java.io.*;

public class Main {
	static int[] num;
	static PriorityQueue<Integer> pq;
	static int ans = 0;
    
    public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        pq = new PriorityQueue<>(Collections.reverseOrder());
        num = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=3; i++) {
        	num[i] = Integer.parseInt(st.nextToken());
        	pq.add(num[i]);
        }
        
        for(int i=1; i<3; i++) {
        	for(int j=i+1; j<=3; j++) {
        		pq.add(num[i] * num[j]);
        	}
        }
        pq.add(num[1]*num[2]*num[3]);
        
        while(!pq.isEmpty()) {
        	int val = pq.poll();
        	if(val%2==1) {
        		ans = val;
        		break;
        	}
        	if(ans > 0) {
        		continue;
        	}
        	ans = val;
        }
        bw.append(String.valueOf(ans));
        bw.flush();
        
    }
}