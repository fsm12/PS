import java.util.*;
import java.io.*;

public class Main{
    static int A,B,C;
    static int[] cnt;
    
    public static void main(String[] args) throws Exception{
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());

        int cal = A*B*C;
        cnt = new int[10];

        while(0<cal){
            cnt[cal%10]+=1;
            cal/=10;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10; i++){
            sb.append(cnt[i]).append("\n");
        }
        System.out.println(sb);
    }
}