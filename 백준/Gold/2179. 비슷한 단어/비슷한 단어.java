import java.util.*;
import java.io.*;

public class Main {
    static int N,rs1,rs2,maxCnt;
    
    public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
    	N = Integer.parseInt(br.readLine());
    	
		ArrayList<String> list = new ArrayList<>();
		for(int n=0; n<N; n++) {
			String s= br.readLine();
			if(!list.contains(s))
				list.add(s);
		}

		for(int i=0; i<N; i++) {
			String str1 = list.get(i);
			for(int j=i+1; j<N; j++) {
				int cnt=0;
				String str2=list.get(j);
				for(int z=0; z<Math.min(str1.length(), str2.length()); z++) {
					if(str1.charAt(z)==str2.charAt(z)) 
						cnt++;
					else 
                        break;
				}
				if(cnt > maxCnt) {
					rs1=i;
					rs2=j;
					maxCnt=cnt;
				}
			}
		}
		
		System.out.println(list.get(rs1)+"\n"+list.get(rs2));
	}
}
