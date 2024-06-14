import java.util.*;
import java.io.*;

public class Main{
    static int A,B;
    static String ans;
    
    public static void main(String[] args) throws Exception{
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        ans = "";
        if(A>B)
            ans = ">";
        else if(A<B)
            ans = "<";
        else
            ans = "==";
        
        System.out.println(ans);
    }
}