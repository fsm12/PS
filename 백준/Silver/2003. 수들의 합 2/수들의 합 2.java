import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    StringTokenizer st = null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
        System.out.println(twoPointer(arr, M));
    }
    private static int twoPointer(int[] arr, int m) {
        int L=0,H=0,total=arr[0],cnt=0;
        while(arr.length!=H){
            if(total<m){
                H+=1;
                if(arr.length==H){
                    break;
                }
                total+=arr[H];
            }else if(total >m){
                L+=1;
                total-=arr[L-1];
            }else{
                cnt+=1;
                L+=1;
                total-=arr[L-1];
            }
        }
        return cnt;
    }
}