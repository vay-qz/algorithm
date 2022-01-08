package pers;

import java.util.*;

/**
 * 460
 */
public class LFUCache {

    private int capacity;
    private int minFreq;

    private Map<Integer, Node> nodeMap;
    private Map<Integer, LinkedList<Node>> freq;

    public LFUCache(int capacity) {
        nodeMap = new HashMap<>();
        freq = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        if (nodeMap.get(key) != null) {
            Node node = nodeMap.get(key);
            freq.get(node.freq).remove(node);
            if (freq.get(node.freq).size() == 0) {
                freq.remove(node.freq);
                if (node.freq == minFreq) {
                    minFreq++;
                }
            }

            node.freq++;
            LinkedList<Node> orDefault = freq.get(node.freq);
            if (orDefault == null) {
                orDefault = new LinkedList<>();
            }
            orDefault.addLast(node);
            freq.put(node.freq, orDefault);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node oldNode = nodeMap.get(key);
        if (oldNode != null) {
            freq.get(oldNode.freq).remove(oldNode);
            if (freq.get(oldNode.freq).size() == 0) {
                freq.remove(oldNode.freq);
                if (oldNode.freq == minFreq) {
                    minFreq++;
                }
            }
            oldNode.freq++;
            LinkedList<Node> orDefault = freq.get(oldNode.freq);
            if (orDefault == null) {
                orDefault = new LinkedList<>();
            }
            orDefault.addLast(oldNode);
            freq.put(oldNode.freq, orDefault);

            oldNode.value = value;
        } else {
            // 移除
            if (capacity == nodeMap.size()) {
                Node node = freq.get(minFreq).removeFirst();
                nodeMap.remove(node.key);
                if (freq.get(minFreq).size() == 0) {
                    freq.remove(minFreq);
                }
                if (nodeMap.isEmpty()) {
                    minFreq = 0;
                }
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            newNode.freq = 1;
            LinkedList<Node> orDefault = freq.get(newNode.freq);
            if (orDefault == null) {
                orDefault = new LinkedList<>();
            }
            orDefault.addLast(newNode);
            freq.put(1, orDefault);
            nodeMap.put(key, newNode);
            minFreq = 1;
        }
    }

    class Node {
        int key;
        int value;
        int freq;

        @Override
        public boolean equals(Object obj) {
            return this == obj;
        }
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1,1);
        lfuCache.put(2,2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3,3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4,4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }

}
