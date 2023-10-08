import java.io.*;
import java.util.*;

public class Main {
    static int A,T,M,R=2;
    static int zeroCount, oneCount;
    
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        System.out.println(solve());
    }
    
    public static int solve(){
        while (true) {
            for(int i=0; i<4; i++){
                if(i%2==0){
                    zeroCount++;
                }else{
                    oneCount++;
                }
                if(M==0 && zeroCount==T){
                    return (zeroCount+oneCount-1)%A;
                }
                if(M==1 && oneCount==T){
                    return (zeroCount+oneCount-1)%A;
                }
            }
            
            for(int i=0; i<R; i++){
                zeroCount++;
                if(zeroCount==T && M==0){
                    return (zeroCount+oneCount-1)%A;
                }
            }
            
            for(int i=0; i<R; i++){
                oneCount++;
                if(oneCount==T && M==1){
                    return (zeroCount+oneCount-1)%A;
                }
            }
            R++;
        }
    }
}