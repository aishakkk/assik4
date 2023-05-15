public class MyHashTable <K, V>{
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }
    private HashNode<K, V>[] chain;
    private int M = 11;
    private int size;

    public MyHashTable() {
        chain = new HashNode[M];
    }

    public MyHashTable(int M) {
        this.M = M;
        chain = new HashNode[M];
    }

    private int hash(K key) {
        return key.hashCode() % M;
    }

    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);

        for (HashNode<K, V> currentNode = chain[index]; currentNode != null; currentNode = currentNode.next) {
            if (currentNode.key.equals(key)) {
                currentNode.value = value;
                return;
            }
        }

        newNode.next = chain[index];
        chain[index] = newNode;
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> currentNode = chain[index];

        for (currentNode = chain[index]; currentNode != null; currentNode = currentNode.next) {
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
        }
        return null;
    }

    public V remove(K key) {

    }

    public boolean contains(V value) {

    }

    public K getKey(V value) {

    }
}