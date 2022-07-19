import java.io.*;
import java.util.*;
public class Main {
    static int t,n,m;
    static int A[];
    static int B[];
    static ArrayList<Integer> a = new ArrayList<>();
    static ArrayList<Integer> b = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        String[] A_input = br.readLine().split(" ");
        A = new int [n];
        for(int i=0; i<n; i++) {
            A[i] = Integer.parseInt(A_input[i]);
        }

        m = Integer.parseInt(br.readLine());
        B = new int[m];
        String[] B_input = br.readLine().split(" ");
        for(int i=0; i<m; i++) {
            B[i] = Integer.parseInt(B_input[i]);
        }

        for(int i=0; i<n; i++) {
            int sum=0;
            for(int j=i; j<n;j++) {
                sum+=A[j];
                a.add(sum);
            }
        }
        for(int i=0; i<m; i++) {
            int sum=0;
            for(int j=i; j<m;j++) {
                sum+=B[j];
                b.add(sum);
            }
        }

        Collections.sort(a);
        Collections.sort(b);

        int a_idx=0;
        int b_idx= b.size()-1;
        long cnt = 0;
        while(a_idx<a.size() &&b_idx>=0) {

            int a_sum = a.get(a_idx);
            int b_sum = b.get(b_idx);
            long a_cnt =0;
            long b_cnt =0;
            if(a_sum+b_sum==t) {
                while(a_idx<a.size() && a.get(a_idx)==a_sum) {
                    a_idx++;
                    a_cnt++;
                }
                while(b_idx>=0 && b.get(b_idx)==b_sum) {
                    b_idx--;
                    b_cnt++;
                }
                cnt+=a_cnt*b_cnt;
            }
            if(a_sum+b_sum>t) {
                b_idx--;
            }
            if(a_sum+b_sum<t) {
                a_idx++;
            }
        }
        System.out.println(cnt);
    }
}