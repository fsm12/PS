import java.util.*;
import java.io.*;

public class Main {
    static int N,sum=0,finalN,startN,result=0;
    static int[] accSum;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        accSum = new int[N+1];
        for (int n = 1; n < N; n++) {
            sum+=n;
            accSum[n]=sum;
        }
        finalN = N-1;
        //System.out.println(Arrays.toString(accSum));

        startN = finalN-1;
        while(true){
            if(startN<0){
                result+=1;
                break;
            }else if(finalN<0){
                break;
            }

            if(accSum[finalN]-accSum[startN]==N){
                result+=1;
                finalN-=1;
            }else if(accSum[finalN]-accSum[startN]>N){
                finalN-=1;
            }else{
                startN-=1;
            }
        }
        System.out.println(result);
    }
}