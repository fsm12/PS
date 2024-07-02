import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean[] status = new boolean[31];
        for(int i=0; i<28; i++){
            int a = Integer.parseInt(br.readLine());
            status[a] = true;
        }
        
        for(int i=1; i<=30; i++){
            if(!status[i])
                System.out.println(i);
        }
        
    }
}