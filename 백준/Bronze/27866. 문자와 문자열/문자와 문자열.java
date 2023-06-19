import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String inp = br.readLine();
        int idx = Integer.parseInt(br.readLine());
        
        bw.write(inp.charAt(idx-1));
        bw.flush();
    }
}