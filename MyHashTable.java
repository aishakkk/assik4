public class MyHashTable <K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        /**
         * HashNode - constructor to set values in fields
         *
         * @param key   - given key to set
         * @param value - given value to set
         */
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * getKey - method that returns key of node
         *
         * @return K - key type
         */
        public K getKey() {
            return key;
        }

        /**
         * getValue - method that returns value of node
         *
         * @return V - value type
         */
        public V getValue() {
            return value;
        }

        /**
         * setValue - method that set value in node
         *
         * @param value - given value to set
         */
        public void setValue(V value) {
            this.value = value;
        }

        /**
         * toString - method that returns node with specific type
         *
         * @return String
         */
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chain;
    private int M = 11;
    private int size;

    /**
     * MyHashTable - constructor to create hash table
     */
    public MyHashTable() {
        chain = new HashNode[M];
    }

    /**
     * MyHashTable - constructor to create hash table with specific M
     *
     * @param M - given M to change
     */
    public MyHashTable(int M) {
        this.M = M;
        chain = new HashNode[M];
    }

    /**
     * hash - method to do hash key
     *
     * @param key - given key to do hash
     * @return int
     */
    private int hash(K key) {
        return key.hashCode() % M;
    }

    /**
     * put - method puts a value in hash table with key
     *
     * @param key   - given key to put within
     * @param value - given value to put
     */
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

    /**
     * get - method gets a value from hash table with key
     *
     * @param key - given key to get value within
     * @return V - value type
     */
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

    /**
     * remove - method removes value from hash table with key
     *
     * @param key - given key to remove value within
     * @return V - value type
     */
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

    /**
     * contains - method checks is value in hash table
     *
     * @param value - given value to check
     * @return boolean
     */
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

    /**
     * getKey - method returns key with value
     *
     * @param value - given value to get key within
     * @return K - key type
     */
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

    public V remove(K key, V oldValue, V newValue) {
        int index = hash(key);
        HashNode<K, V> node = chain[index];
        while (node != null) {
            if (node.key.equals(key) && node.value.equals(oldValue)) {
                node.value = newValue;
                return newValue;
            }
            node = node.next;
        }
        return null;
    }
}
