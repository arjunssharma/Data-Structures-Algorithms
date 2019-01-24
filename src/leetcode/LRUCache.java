package leetcode;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node {
        int key;
        int value;
        Node previous;
        Node next;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    Map<Integer, Node> map;
    int capacity;
    int nodesCount;
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.previous = head;
        nodesCount = 0;
    }
    
    
    public void deleteNode(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
        node.previous = null;
        node.next = null;
    }
    
    public void addNodeToHead(Node node) {
        head.next.previous = node;
        node.next = head.next;
        head.next = node;
        node.previous = head;
    }
    
    public int get(int key) {
        if(map.get(key) != null) {
            Node node = map.get(key);        
            int result = node.value;
            deleteNode(node);
            addNodeToHead(node);
            return result;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addNodeToHead(node);
        }
        else {
            Node node = new Node(key, value);
            map.put(key, node);
            addNodeToHead(node);
            if(nodesCount < capacity) {
                nodesCount++;
            }
            else {
                map.remove(tail.previous.key);
                deleteNode(tail.previous);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
