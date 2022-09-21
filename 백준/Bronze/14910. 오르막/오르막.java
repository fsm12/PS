import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.MIN_VALUE;

        while(tokenizer.hasMoreTokens()) {
            int next = Integer.parseInt(tokenizer.nextToken());

            if(N > next) {
                System.out.println("Bad");
                return;
            }else {
                N = next;
            }
        }
        System.out.println("Good");
    }
}