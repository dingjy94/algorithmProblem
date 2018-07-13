public class LRUCache {
    private class Node {
        int val;
        int key;
        Node prev;
        Node next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
    
    private int capacity;
    private Map<Integer, Node> hash = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    /*
    * @param capacity: An integer
    */public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (!hash.containsKey(key)) {
            return -1;
        }
        
        Node cur = hash.get(key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        
        move(cur);
        
        return cur.val;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (get(key) != -1) {
            hash.get(key).val = value;
            return;
        }
        
        if (hash.size() == capacity) {
            hash.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        
        Node newNode = new Node(key, value);
        hash.put(key, newNode);
        move(newNode);
    }
    
    private void move(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
}
