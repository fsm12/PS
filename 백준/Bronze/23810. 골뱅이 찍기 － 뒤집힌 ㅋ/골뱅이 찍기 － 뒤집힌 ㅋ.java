import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static String[] f = {"@@@@@","@","@@@@@","@","@"};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < f.length; i++) {
            for (int ni = 0; ni < N; ni++) {
                for (int nj = 0; nj < N; nj++) {
                    sb.append(f[i]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}