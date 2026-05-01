import java.util.LinkedList;
public class HashTable<K, V> {

    private class Node { 
        K key; 
        V value; 

        Node(K key, V value) { 
            this.key = key;
            this.value = value;
        }
    }

    private final LinkedList<Node>[] buckets; 
    private final int capacity = 16;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public HashTable() {
        buckets = new LinkedList[capacity];
    }
    private int getBucketIndex(K key) {
        int hashCode = (key == null) ? 0 : Math.abs(key.hashCode()); 
        return hashCode % capacity;
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key); 

        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        for (Node node : buckets[index]) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        buckets[index].add(new Node(key, value));
        size++;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Node> bucket = buckets[index]; 

        if (bucket != null) {
            for (Node node : bucket) {
                if (node.key.equals(key)) { 
                    return node.value;
                }
            }
        }
        return null; 
    }

    public void remove(K key) {
        int index = getBucketIndex(key); 
        LinkedList<Node> bucket = buckets[index];

        if (bucket != null) {
            for (Node node : bucket) {
                if (node.key.equals(key)) { 
                    bucket.remove(node);
                    size--;
                    return;
                }
            }
        }
    }

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        HashTable<String, Integer> map = new HashTable<>();
        map.put("Apple", 100);
        map.put("Banana", 200);

        System.out.println("Size: " + map.size()); 
        System.out.println("Price of Apple: " + map.get("Apple")); 

        map.remove("Apple");
        System.out.println("Is empty after removal? " + map.isEmpty()); 
        System.out.println("Size: " + map.size()); 
    }
}
