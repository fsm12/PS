import java.util.*;
import java.io.*;

public class Main{
    static int A,B,C,D,E;
    
    public static void main(String[] args) throws Exception{
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int ans = A*A + B*B + C*C + D*D + E*E;

        System.out.println(ans%10);
    }
}