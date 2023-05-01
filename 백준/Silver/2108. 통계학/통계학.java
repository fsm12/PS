import java.util.*;
import java.io.*;

public class Main{
	static int N,mid,maxFreq,range;
	static double avg;
	static List<Integer> list;
	static Map<Integer, Integer> map;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine()); 
		
		list = new ArrayList<>();
		for(int n=0;n<N;n++) {
			int num = Integer.parseInt(br.readLine());
			list.add(num);
			avg+=num;
		}
		
		Collections.sort(list);
		mid = list.get(N/2);
		
		int[] freq = new int[8001];
        int max = 0;
        for(int n=0; n<N; n++) {
        	freq[list.get(n)+4000]++;
            max = Math.max(freq[list.get(n)+4000], max);
        }
        ArrayList<Integer> max_idx = new ArrayList<>();
        for(int n=0; n<=8000; n++) {
            if(max == freq[n]) {
                max_idx.add(n-4000);
            }
        }
        maxFreq = max_idx.size()>1? max_idx.get(1) : max_idx.get(0);
		
		range = list.get(N-1) - list.get(0);
		
		bw.append((int)Math.round((avg/N))+"\n"+mid+"\n"+maxFreq+"\n"+range+"\n");
		bw.close();
	}
}