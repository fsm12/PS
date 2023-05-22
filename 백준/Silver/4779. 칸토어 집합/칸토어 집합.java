import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char c[];
    
    public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        while(str != null){
            N = Integer.parseInt(str);

            int len = (int) Math.pow(3,N); 
            c = new char[len];

            for(int i=0; i<len; i++) 
            	c[i] = '-';

            dfs(0,len);

            for(int i=0; i<len; i++) 
            	bw.write(c[i]);
            
            bw.write("\n");
            bw.flush();
            str = br.readLine();
        }
    }

    static void dfs(int start, int size){
        if(size == 1) {
            return;
        }
        
        int ns = size/3;
        for(int i = start + ns; i < start + ns * 2; i++)
        	c[i] = ' ';


        dfs(start, ns);
        dfs(start + ns * 2, ns);
    }
}
