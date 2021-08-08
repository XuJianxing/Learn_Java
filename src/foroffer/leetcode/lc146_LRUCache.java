package foroffer.leetcode;

import java.util.HashMap;
import java.util.Map;

public class lc146_LRUCache {

}

class DLinkedNode {
    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;
    public DLinkedNode() {}
    public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
}

class LRUCache{
    // get的key所对应的双向链表内的节点的引用
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;  // 当前元素个数
    private int capacity;  // 总容量
    // 在双向链表的实现中，使用一个伪头部（dummy head）和伪尾部（dummy tail）标记界限，
    // 这样在添加节点和删除节点的时候就不需要检查相邻的节点是否存在。
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)){
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            DLinkedNode node = cache.get(key);
            node.value = value;
            moveToHead(node);
        }
        else {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
    }

    private void addToHead(DLinkedNode node) {
        // 插到head的后面
        node.prev = head;
        node.next = head.next;
        // 因为没有head.next的引用，所以先改head.next
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        // 删除后添加
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        // 把tail的前一个节点删除
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

}
