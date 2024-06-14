import java.util.*;
import java.io.*;

public class Main{
    static int ans;
    
    public static void main(String[] args) throws Exception{
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        ans=0;
        while(st.hasMoreTokens()){
            String str = st.nextToken();
            ans+=1;
        }
        
        System.out.println(ans);
    }
}