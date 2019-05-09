import java.util.ArrayList;

// Generics
class HashNode<K, V> {
    K key;
    V value;

    HashNode<K, V> next;
    HashNode<K, V> prev;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class MyMap<K, V> {
    // store node chain to avoid hash cash collision (Separate Chaining Technique)
    private ArrayList<HashNode<K, V>> bucketArray;

    private int bucketNums;

    private int size;

    private void initBucketArray() {
        for (int i = 0; i < this.bucketNums; i++) {
            bucketArray.add(null);
        }
    };

    public MyMap() {
        this.bucketArray = new ArrayList<>();
        this.bucketNums = 10;
        this.size = 0;

        initBucketArray();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getBucketIndex(K key) {
        int hashcode = key.hashCode();
        return hashcode % bucketNums;
    }

    // double the length of the array list when load factor > 0.7
    private void doubleBucketArray() {
        ArrayList<HashNode<K, V>> tmp = bucketArray;
        bucketArray = new ArrayList<>();
        bucketNums *= 2;
        size = 0;

        initBucketArray();

        for (HashNode<K, V> node : tmp) {
            while (node != null) {
                add(node.key, node.value);
                node = node.next;
            }
        }
    }

    public void add(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }

            head = head.next;
        }

        HashNode<K, V> newNode = new HashNode(key, value);
        head = bucketArray.get(bucketIndex);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        size++;
        bucketArray.set(bucketIndex, newNode);

        if (size * 1.0 / bucketNums >= 0.7) {
            doubleBucketArray();
        }
    }

    private HashNode<K, V> getPair(K key) {
        int bucketIndex = getBucketIndex(key);

        HashNode<K, V> head = bucketArray.get(bucketIndex);

        while (head != null) {
            if (head.key == key) {
                return head;
            }

            head = head.next;
        }

        return null;
    }

    public V get(K key) {
        HashNode<K, V> node = getPair(key);

        return node == null ? null : node.value;
    }

    public V remove(K key) {
        HashNode<K, V> node = getPair(key);

        if (node == null) {
            return null;
        }

        size--;

        if (node.prev != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        } else {
            node.next.prev = null;
            bucketArray.set(getBucketIndex(key), node.next);
        }

        return node.value;
    }
}
