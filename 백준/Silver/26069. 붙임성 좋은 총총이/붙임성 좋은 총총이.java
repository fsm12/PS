import java.util.*;
import java.io.*;

public class Main{
    static int N, cnt;
    static HashSet<String> rainbowDance;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        rainbowDance = new HashSet<>();
        rainbowDance.add("ChongChong");
        for (int n = 0; n < N; n++) {
            String[] name = br.readLine().split(" ");
            if(rainbowDance.contains(name[0])){
                rainbowDance.add(name[1]);
            }else if(rainbowDance.contains(name[1])){
                rainbowDance.add(name[0]);
            }
        }
        System.out.println(rainbowDance.size());
    }
}