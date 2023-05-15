public class MyHashTable <K, V>{
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;
        /**
         * HashNode - constructor to set values in fields
         * @param key - given key to set
         * @param value - given value to set
         */
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
        /**
         * getKey - method that returns key of node
         * @return K - key type
         */
        public K getKey() {
            return key;
        }
        /**
         * getValue - method that returns value of node
         * @return V - value type
         */
        public V getValue() {
            return value;
        }
        /**
         * setValue - method that set value in node
         * @param value - given value to set
         */
        public void setValue(V value) {
            this.value = value;
        }
        /**
         * toString - method that returns node with specific type
         * @return String
         */
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
        int index = hash(key);
        HashNode<K, V> prevNode = null;

        for (HashNode<K, V> currentNode = chain[index]; currentNode != null; prevNode = currentNode, currentNode = currentNode.next) {
            if (currentNode.key.equals(key)) {
                if (prevNode == null) {
                    chain[index] = currentNode.next;
                } else {
                    prevNode.next = currentNode.next;
                }
                size--;
                return currentNode.value;
            }
        }

        return null;
    }

    public boolean contains(V value) {
        for (HashNode<K, V> node : chain) {
            for (HashNode<K, V> currentNode = node; currentNode != null; currentNode = currentNode.next) {
                if (currentNode.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (HashNode<K, V> node : chain) {
            for (HashNode<K, V> currentNode = node; currentNode != null; currentNode = currentNode.next) {
                if (currentNode.value.equals(value)) {
                    return currentNode.key;
                }
            }
        }
        return null;
    }
}