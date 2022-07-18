import java.io.*;
import java.util.*;
 
class Main {
    static char[] arr;
    static int[] res;
    static int N;
    static int M;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new char[M];
        res = new int[M];
        str = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            arr[i] = str[i].charAt(0);
        }
 
        Arrays.sort(arr);
        DFS(0, 0, 0, 0);
    }
 
    public static void DFS(int start, int depth, int ja, int mo) {

        for (int i = start; i < M; i++) {
            res[i] = 1; 
            DFS(i + 1, depth + 1, ja + (!check(arr[i]) ? 1 : 0), mo + (!check(arr[i]) ? 0 : 1));
            res[i] = 0;
        }

        if (depth == N && ja >= 2 && mo >= 1) {
            print();
        }
    }
 
    public static void print() {
        for (int i = 0; i < M; i++) {
            if (res[i] == 1)
                System.out.print(arr[i]);
        }
        System.out.println();
    }
 
    public static boolean check(char a) {
        if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u')
            return true;
        else
            return false;
    }
 
}