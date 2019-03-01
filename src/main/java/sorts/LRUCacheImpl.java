package sorts;

public class LRUCacheImpl {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        int v1 = cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        int v2 = cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        int v3 = cache.get(1);       // returns -1 (not found)
        int v4 = cache.get(3);       // returns 3
        int v5 = cache.get(4);       // returns 4

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
        System.out.println(v5);
    }
}

class LRUCache {
    private Node[] table;
    private int capacity = 16; // power of 2
    private Node head;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.table = new Node[capacity];
        head = null;
    }

    public int get(int key) {
        int hash = hash(key);
        int tableIndex = hash & (table.length - 1);
        Node node = table[tableIndex];

        for(; node != null; node = node.next) {
            if(node.keyEquals(key)) {
                // remove node;
                removeNode(node);

                // set head
                insertAfter(head, node);

                return node.value;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        int hash = hash(key);
        int tableIndex = hash & (table.length - 1);
        Node node = table[tableIndex];

        for(; node != null; node = node.next) {
            if(node.keyEquals(key)) {
                // remove node;
                removeNode(node);

                // set head
                insertAfter(head, node);

                node.value = value;
                return;
            }
        }

        if(size == capacity) {
            if(head.before == head) {
                head = null;
            } else {
                removeNode(head.before);
            }
        }

        // add Node
        Node newNode = new Node(key, value, null, null, table[tableIndex]);
        table[tableIndex] = newNode;
        size++;

        if(head == null) {
            head = newNode;
            head.before = head;
            head.after = head;
            return;
        }

        // add Node to double sequence link list tail
        head.before.after = newNode;
        newNode.before = head.before;
        newNode.after = head;
        head.before = newNode;
    }

    private void insertAfter(Node target, Node node) {
        node.after = target.after;
        node.before = target;
        target.after.before = node;
        target.after = node;
    }

    private void removeNode(Node node) {
        node.before.after = node.after;
        node.after.before = node.before;
        size--;
    }

    private int hash(int key) {
        return key;
    }

    private class Node {
        public Node next;
        public Node before;
        public Node after;
        private int key;
        private int value;

        public Node() {}
        public Node(int key, int value, Node before, Node after, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.before = before;
            this.after = after;
        }

        public boolean keyEquals(int key) {
            return hash(this.key) == hash(key) && this.key == key;
        }
    }
}
