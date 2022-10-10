import java.io.*;
import java.util.*;

public class Main {
    static int cnt;
    static long num,sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Long.parseLong(br.readLine());
        sum = 0;
        cnt = 0;

        for(int i=1; ; i++) {
            if(sum > num)	break;
            sum += i;
            cnt ++;
        }
        System.out.println(cnt-1);
    }
}