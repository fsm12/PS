import java.util.*;
import java.io.*;

public class Main {
    static int N,ans=0;
    static HashMap<Integer, ArrayList<Integer>> check;
    static int[][] map;
    static int dx[] = { -1, 1, 0, 0 }, dy[] = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        //해쉬맵 생성 (학생 - 좋아하는 학생 4명 번호)
        check = new HashMap<>();
        for (int nn = 0; nn < N * N; nn++) {
            ArrayList<Integer> nearList = new ArrayList<>();
            int[] likeStuList = new int[4];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int stu = Integer.parseInt(st.nextToken());
            for (int dxy = 0; dxy < 4; dxy++) {
                int likeStu = Integer.parseInt(st.nextToken());
                nearList.add(likeStu);
                likeStuList[dxy] = likeStu;
            }
            check.put(stu, nearList);

            int near = -1;
            int empty = -1;
            int xx = 0;
            int yy = 0;
            for (int x = 1; x <= N; x++) {
                for (int y = 1; y <= N; y++) {
                    if (map[x][y] != 0) {
                        continue;
                    }
                    int tNear = 0;
                    int tEmpty = 0;
                    for (int z = 0; z < 4; z++) {
                        int nx = x + dx[z];
                        int ny = y + dy[z];
                        // 맵안
                        if (0<nx && nx<=N && 0<ny && ny<=N) {
                            // 좋아하는 사람이 있는 칸이라면, 인접한 사람 인원수 +1
                            if (map[nx][ny] > 0 && (map[nx][ny] == likeStuList[0] || map[nx][ny] == likeStuList[1] || map[nx][ny] == likeStuList[2] || map[nx][ny] == likeStuList[3])) {
                                tNear++;
                            } // 비어있는 칸이라면
                            else if (map[nx][ny] == 0) {
                                tEmpty++;
                            }
                        }
                    }
                    /*
                    문제에서 조건은
                    1. 좋아하는 학생이 많이 인접한 곳 선택
                    1번이 여러곳이라면 -> 2. 인접한 곳중 빈곳이 많은 곳 선택
                    2번이 여러곳이라면 -> 3. 행번호가 가장 작은곳
                    3번이 여러곳이라면 -> 4. 열번호가 가장 작은곳
                    이므로,
                     */
                    // 인접한곳이 많은 곳을 먼저 선택하고
                    if (tNear > near) {
                        near = tNear;
                        empty = tEmpty;
                        xx = x;
                        yy = y;
                    }// 인접한 곳이 여러곳이라면 빈곳이 많은 곳을 선택한다.
                    else if (tNear == near && tEmpty > empty) {
                        near = tNear;
                        empty = tEmpty;
                        xx = x;
                        yy = y;
                    }
                }
            }
            //정해진 자리에 학생을 배치
            map[xx][yy] = stu;
        }

        //점수를 계산하기
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (0<nx && nx<=N && 0<ny && ny<=N) {
                        if (check.get(map[x][y]).contains(map[nx][ny])) {
                            cnt++;
                        }
                    }
                }
                // 인접한 학생 수 만큼 점수 +
                ans += (int) Math.pow(10, cnt-1);
            }
        }
        System.out.println(ans);
    }
}