package leetCode;

//https://leetcode.com/problems/max-area-of-island/
public class Ex37 {

    static int max;
    static int[][] map;
    static int count;

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        }));
    }

    /**
     * grid에서 1을 찾으면 DFS로 순회하여 섬의 크기를 구한다.
     * 가장 큰 섬의 크기를 반환한다.
     */
    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        max = 0;
        map = grid;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count = 0;
                    DFS(new Point(i, j));
                }
            }
        }
        return max;
    }

    private static void DFS(Point point) {
        if (point.x < 0 || point.y < 0 || point.x >= map.length || point.y >= map[0].length) return;
        if (map[point.x][point.y] != 1) return;
        map[point.x][point.y] = 2;
        count++;
        max = Math.max(max, count);
        DFS(new Point(point.x, point.y + 1));
        DFS(new Point(point.x + 1, point.y));
        DFS(new Point(point.x, point.y - 1));
        DFS(new Point(point.x - 1, point.y));
    }
}
