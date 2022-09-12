import java.io.*;
import java.util.*;

public class Main{
    static int M, num;
    static String command;
    static StringBuilder sb = new StringBuilder();
    static Set<Integer> S;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());

        S = new HashSet<>();
        while(M-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            command = st.nextToken();
            switch (command){
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    S.add(num);
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    S.remove(num);
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    sb.append((S.contains(num)?1:0)+"\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    if(S.contains(num)){
                        S.remove(num);
                    }else{
                        S.add(num);
                    }
                    break;
                case "all":
                    S = new HashSet<>();
                    for (int i = 1; i <= 20; i++) {
                        S.add(i);
                    }
                    break;
                case "empty":
                    S.clear();
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}