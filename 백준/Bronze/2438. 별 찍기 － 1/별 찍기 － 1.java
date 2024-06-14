import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static StringBuilder ans;
    
    public static void main(String[] args) throws Exception{
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        ans = new StringBuilder();
        for(int i=1; i<=N; i++){
            for(int j=0; j<i; j++){
                ans.append("*");
            }
            ans.append("\n");
        }

        System.out.println(ans);
    }
}