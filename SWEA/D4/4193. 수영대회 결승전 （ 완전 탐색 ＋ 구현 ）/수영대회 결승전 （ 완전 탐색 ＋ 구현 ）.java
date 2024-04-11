import java.io.*;
import java.util.*;

class Point {
    int x, y, dist;

    Point(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    Point clone(int x, int y, int dist) {
        return new Point(x, y, dist);
    }
}

public class Solution {
    static int answer;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static int size;
    static boolean[][] visited;
    static Point endPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int c = 1; c <= tc; c++) {
            size = Integer.parseInt(br.readLine());
            map = new int[size][size];
            visited = new boolean[size][size];

            for (int i = 0; i < size; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < size; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            Point p = new Point(x, y, 0);

            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            endPoint = new Point(x, y, 0);

            answer = bfs(p);
            System.out.println("#" + c + " " + answer);
        }
    }

    static int bfs(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.y][start.x] = true;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Point p = queue.poll();

                if (p.x == endPoint.x && p.y == endPoint.y) {
                    return p.dist;
                }

                for (int j = 0; j < 4; j++) {
                    int mx = p.x + dx[j];
                    int my = p.y + dy[j];
                    int move = p.dist + 1;

                    if (mx < 0 || my < 0 || mx >= size || my >= size) continue;
                    if (visited[my][mx] || map[my][mx] == 1) continue;
                    if (map[my][mx] == 2) {
                        if (p.dist % 3 != 2) {
                            queue.offer(p.clone(p.x, p.y, p.dist+1));
                        }else{
                            queue.offer(new Point(mx,my,move));
                            visited[my][mx] = true;
                        }
                        continue;
                    }
                    visited[my][mx] = true;
                    queue.offer(new Point(mx, my, move));
                }
            }
        }
        return -1;
    }
}