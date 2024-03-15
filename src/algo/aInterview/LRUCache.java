package algo.aInterview;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LRUCache {
    class DLinkedNode {
        String key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    private ConcurrentMap<String, DLinkedNode> cache = new ConcurrentHashMap<String, DLinkedNode>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(String key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1; // should raise exception here.
        }

        moveToHead(node);
        return node.value;
    }


    public void put(String key, int value) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }

        DLinkedNode newNode = new DLinkedNode();
        newNode.key = key;
        newNode.value = value;

        cache.put(key, newNode);
        addNode(newNode);

        ++count;

        if (count > capacity) {
            // pop the tail
            DLinkedNode tail = popTail();
            cache.remove(tail.key);
            --count;
        }
    }

    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        removeNode(res);
        return res;
    }

    public static void main(String[] args) {
        // 创建⼀个容量为3的LRU缓存
        LRUCache lruCache = new LRUCache(3);
        // 添加数据
        lruCache.put("One",1);
        lruCache.put( "Two",2);
        lruCache.put("Three",3);
        // 此时缓存为：{1=One, 2=Two, 3=Three}
        // 访问某个元素，使其成为最近访问的元素
        int value = lruCache.get("Two");
        System.out.println(value);
        // 此时缓存为：{1=One, 3=Three, 2=Two}
        // 添加新的数据，触发淘汰
        lruCache.put("Four",4);
        // 此时缓存为：{3=Three, 2=Two, 4=Four}
        // 元素1被淘汰，因为它是最近最少访问的元素

    }

}