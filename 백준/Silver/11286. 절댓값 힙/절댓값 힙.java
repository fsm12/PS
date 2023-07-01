import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static PriorityQueue<Integer> pq;
    
    public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        pq = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if(abs1 == abs2)
            	return o1 > o2 ? 1 : -1;
            return abs1 - abs2;
        });
        
        for(int n=0 ; n<N; n++){
            int val = Integer.parseInt(br.readLine());
            if(val == 0){
                if(pq.isEmpty()) 
                	bw.append("0\n");
                else 
                	bw.append(pq.poll()+"\n");
            }else{
            	pq.add(val);
            }
        }
        bw.flush();
    }
}