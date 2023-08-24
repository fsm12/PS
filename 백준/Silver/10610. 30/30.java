import java.util.*;
import java.io.*;

public class Main{
	static String inp;
	static int len;
	static int[] cntNum;
	static long total = 0;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		cntNum = new int[10];
		
		inp = br.readLine();
		len = inp.length();
        for(int i=0; i < len; i++) {
            int tNum = Integer.parseInt(inp.substring(i, i+1));
            cntNum[tNum] += 1;
            total+=tNum;
        }
        
        if(!inp.contains("0") || total % 3 != 0) {
            System.out.println("-1");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--) {
            while(cntNum[i] > 0) {
                sb.append(i);
                cntNum[i]--;
            }
        }
        System.out.println(sb.toString());
	}
}