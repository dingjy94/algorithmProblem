/**
* Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.
* You need to support the following method:
* 1. connect(a, b), an edge to connect node a and node b
* 2. query(a), Returns the number of connected component nodes which include node a.
* Tip: use same langth array to store information;
*/

public class ConnectingGraph2 {
    int[] father = null;
    int[] size = null;
    /*
    * @param n: An integer
    */
    public ConnectingGraph2(int n) {
        // do intialization if necessary
        father = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            father[i] = i;
            size[i] = 1;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            father[root_a] = root_b;
            size[root_b] += size[root_a];
        }
            
    }
    private int find(int a) {
        if (father[a] == a)
            return a;
        return father[a] = find(father[a]);
    }
    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        // write your code here
        return size[find(a)];
    }
}
