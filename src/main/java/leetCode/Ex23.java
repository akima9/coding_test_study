package leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/flood-fill/
public class Ex23 {

    public static void main(String[] args) {
//        System.out.println(floodFill(new int[][]{
//                {1, 1, 1},
//                {1, 1, 0},
//                {1, 0, 1}}, 1, 1, 2));
//
//        System.out.println(floodFill(new int[][]{
//                {0, 0, 0},
//                {0, 0, 0}}, 1, 0, 2));

        System.out.println(floodFill(new int[][]{
                {0, 0, 0},
                {0, 0, 0}}, 0, 0, 0));
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] check = new int[image.length][image[0].length];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(sr, sc));
        int maxX = image.length;
        int maxY = image[0].length;
        int standardNumber = image[sr][sc];

        if (maxY > sc + 1) queue.offer(new Point(sr, sc + 1));
        if (maxX > sr + 1) queue.offer(new Point(sr + 1, sc));
        if (sc - 1 >= 0) queue.offer(new Point(sr, sc - 1));
        if (sr - 1 >= 0) queue.offer(new Point(sr - 1, sc));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curPoint = queue.poll();

                if (check[curPoint.x][curPoint.y] != 1 && image[curPoint.x][curPoint.y] == standardNumber) {

                    image[curPoint.x][curPoint.y] = color;
                    if (maxY > curPoint.y + 1) queue.offer(new Point(curPoint.x, curPoint.y + 1));
                    if (maxX > curPoint.x + 1) queue.offer(new Point(curPoint.x + 1, curPoint.y));
                    if (curPoint.y - 1 >= 0) queue.offer(new Point(curPoint.x, curPoint.y - 1));
                    if (curPoint.x - 1 >= 0) queue.offer(new Point(curPoint.x - 1, curPoint.y));
                    check[curPoint.x][curPoint.y] = 1;
                }
            }
        }
        return image;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
