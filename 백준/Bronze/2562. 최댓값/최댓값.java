import java.util.*;
import java.io.*;

public class Main{
    static int ansIdx, ansVal;
    
    public static void main(String[] args) throws Exception{
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        ansIdx = -1;
        ansVal = Integer.MIN_VALUE;
        for(int i=0; i<9; i++){ 
            int cur = Integer.parseInt(br.readLine());
            if(ansVal < cur){
                ansVal = cur;
                ansIdx = i+1;
            }
        }

        System.out.println(ansVal+"\n"+ansIdx);
    }
}