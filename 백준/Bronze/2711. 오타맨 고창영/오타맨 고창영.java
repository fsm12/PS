import java.util.*;
import java.io.*;

public class Main{
    static int T;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            String input = br.readLine();
            int n = Integer.parseInt(input.split(" ")[0]);
            String word = input.split(" ")[1];
            for (int i = 0; i < word.length(); i++) {
                if(i==n-1)
                    continue;
                sb.append(word.charAt(i));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}