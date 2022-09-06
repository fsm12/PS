import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static String num;
    static boolean primeNumber[];

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        primeNumber = new boolean[1004001];
        primeNumber[0] = true;
        primeNumber[1] = true;
        for (int i = 2; i < primeNumber.length; i++) {
            if(!primeNumber[i]) {
                if(i>9){
                    num = String.valueOf(i);
                    for (int j = 0; j < num.length()/2; j++) {
                        if(num.charAt(j)!=num.charAt(num.length()-j-1)){
                            primeNumber[i] = true;
                            break;
                        }
                    }
                }
                for (int j = 2; j*i < primeNumber.length; j++) {
                    primeNumber[i*j] = true;
                }
            }
        }

        for (int i = N; i < 1004001; i++) {
            if(!primeNumber[i]){
                System.out.println(i);
                break;
            }
        }
    }
}