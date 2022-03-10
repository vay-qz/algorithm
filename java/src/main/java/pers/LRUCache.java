package pers;

import java.util.HashMap;
import java.util.Map;

/**
 * 146
 */
public class LRUCache {

    private Map<Integer, DoubleNode> hashMap;

    private DoubleNode head;
    private DoubleNode tail;

    private final int capacity;
    private int size;

    public LRUCache(int capacity) {
        hashMap = new HashMap<>();
        head = new DoubleNode();
        tail = new DoubleNode();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        DoubleNode node = hashMap.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        addHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DoubleNode node1 = hashMap.get(key);
        if (node1 == null) {
            if (size == capacity) {
                DoubleNode tail = removeTail();
                hashMap.remove(tail.key);
            } else {
                size++;
            }
            node1 = new DoubleNode(key, value);
            hashMap.put(key, node1);
        } else {
            remove(node1);
            node1.val = value;
        }
        addHead(node1);
    }

    private void addHead(DoubleNode node) {
        DoubleNode r = head.next;
        head.next = node;
        node.prev = head;
        node.next = r;
        r.prev = node;
    }

    private void remove(DoubleNode node) {
        DoubleNode l = node.prev;
        DoubleNode r = node.next;
        l.next = r;
        r.prev = l;
    }

    private DoubleNode removeTail() {
        DoubleNode res = tail.prev;
        DoubleNode l = tail.prev.prev;
        l.next = tail;
        tail.prev = l;
        return res;
    }

    class DoubleNode {
        DoubleNode prev;
        DoubleNode next;
        int key;
        int val;
        public DoubleNode () {
        }
        public DoubleNode (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,1);
        lruCache.get(2);
        lruCache.put(3,1);
        System.out.println(lruCache.get(1));
    }
}
