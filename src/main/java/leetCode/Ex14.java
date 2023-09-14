package leetCode;

//https://leetcode.com/problems/island-perimeter/description/
public class Ex14 {
    static int sum;
    static int[][] tempGrid;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
    }

    public static int islandPerimeter(int[][] grid) {
        sum = 0;
        tempGrid = grid;
        // 1. grid 에서 1을 찾는다.
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    DFS(new Point(j, i));
                    return sum;
                }
            }
        }
        return sum;
    }

    public static void DFS(Point point) {
        if (point.x == tempGrid[0].length || point.y == tempGrid.length || point.x < 0 || point.y < 0) {
            sum++;
            return;
        } else if (tempGrid[point.y][point.x] == 0) {
            // 2. 못가는 방향의 합을 구한다.
            sum++;
            return;
        } else if (tempGrid[point.y][point.x] == 2) {
            return;
        } else {
            // 3. 한번 방문한 곳은 2로 변경.
            tempGrid[point.y][point.x] = 2;
            for (int i = 0; i < 4; i++) {
                DFS(new Point(point.x + dx[i], point.y + dy[i]));
            }
        }
    }
}