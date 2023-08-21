import java.util.*;
import java.io.*;

public class Main{
    static int N, K;
    static boolean[] visited;
    static String[] words;
    static int max = 0;
    static int selectedCount = 5;
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        visited = new boolean[26];

        if(K < 5) {
            System.out.println(0);
        } else {
            visited['a' - 'a'] = true;
            visited['n' - 'a'] = true;
            visited['t' - 'a'] = true;
            visited['i' - 'a'] = true;
            visited['c' - 'a'] = true;
            for (int i=0; i<N; i++) {
                words[i] = br.readLine().replaceAll("[antic]", "");
            }
            
            max = countWords();
            for (int i=0; i<26; i++) {
                if(visited[i] == false) {
                    dfs(i);
                }
            }
            System.out.println(max);
        }
    }

    static void dfs(int index) {
        //1.체크인 : 사용중
        visited[index] = true;
        selectedCount ++; 

        //2.목적지인가 : K개만큼 배웠는가
        if(selectedCount == K) {
            // 몇개의 글자를 배울 수 있는지 계산해야함
            max = Math.max(max, countWords());
        } else {
            //3.연결된 곳을 순회
            for (int i=index+1; i<=25; i++) {
                //4.갈 수 있는가 : 방문한 적 없는가
                if(visited[i] == false) {
                    //5.간다: dfs()
                    dfs(i);
                }
            }
        }
        //6.체크아웃
        visited[index] = false;
        selectedCount --;
    }
    
    static int countWords() {
        int count = 0;
        for (int n=0; n<N; n++) {
            boolean isPossible = true;
            String word = words[n];
            for (int i=0; i<word.length(); i++) {
                if(visited[word.charAt(i) - 'a'] == false) {
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) {
                count++;
            }
        }
        return count;
    }
}