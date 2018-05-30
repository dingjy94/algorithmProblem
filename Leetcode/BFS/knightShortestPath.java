/**
 * Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as barrier) 
 * with a source position, find the shortest path to a destination position, 
 * return the length of the route.
 * Return -1 if knight can not reached.
 */

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        if (grid == null || grid[0] == null) {
            return -1;
        }
        int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
        int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};
        Queue<Point> queue = new LinkedList<>();
        int level = 0;
        queue.offer(source);
        grid[source.x][source.y] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point tmp = queue.poll();
                if (tmp.x == destination.x && tmp.y == destination.y) {
                    return level;
                }
                for (int j = 0; j < 8; j++) {
                    Point newPoint = new Point(
                        tmp.x + dx[j], tmp.y + dy[j]);
                    if (isValid(newPoint, grid)) {
                        queue.offer(newPoint);
                        grid[newPoint.x][newPoint.y] = true;
                    }    
                }
            }
            level++;
        }
        return -1;
    }
    private boolean isValid(Point point, boolean[][] grid) {
        if (point.x >= grid.length || point.y >= grid[0].length || point.y < 0 || point.x < 0) {
            return false;
        }
        return grid[point.x][point.y] == false;
    }
}
