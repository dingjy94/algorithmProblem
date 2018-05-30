/*
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
 * which is expressed as a pair: [0,1]. Given the total number of courses and a list of prerequisite pairs, 
 * return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. 
 * If it is impossible to finish all courses, return an empty array.
 */
public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        int[] result = new int[numCourses];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new HashSet<Integer>());
            indegree.put(i, 0);
        }
        for (int[] pair : prerequisites) {
            if (map.get(pair[0]).contains(pair[1])) {
                return new int[0];
            }
            if (map.get(pair[1]).add(pair[0])) {
                indegree.put(pair[0], indegree.get(pair[0]) + 1);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree.get(i) == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result[count++] = cur;
            for (int after : map.get(cur)) {
                indegree.put(after, indegree.get(after) - 1);
                if (indegree.get(after) == 0) {
                    queue.offer(after);
                }
            }
        }
        if (count == numCourses) {
            return result;
        }
        return new int[0];
    }
}
