# ❤ assignment 4  |  Kalimatova Aisha
## MyHashTable.java
### ✔ hash(K key)
> **Description:** This function takes a key of sort K and returns the hash esteem of the key. It employments the hashCode() strategy of the key protest and performs modulo operation with M (estimate of the hash table) to decide the record where the key-value combine will be put away.
```java
private int hash(K key) {
    return key.hashCode() % M;
}
```

### ✔ put(K key, V value)
> **Description:** This function is used to embed a key-value match into the hash table. It calculates the record utilizing the hash work, and in the event that the chain at that file is invalid, it makes a modern LinkedList to store different key-value sets. It at that point repeats over the chain to check on the off chance that the key as of now exists. In the event that found, it upgrades the esteem; something else, it includes a modern HashNode with the given key and esteem.
```java
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
```

### ✔ get(K key)
> **Description:** This function is used to recover the esteem related with a given key from the hash table. It calculates the record utilizing the hash work and after that emphasizes over the chain at that list to discover the coordinating key. On the off chance that found, it returns the comparing esteem; something else, it returns invalid.
```java
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
```

### ✔ remove(K key)
> **Description:** This function is used to evacuate a key-value combine from the hash table. It calculates the record utilizing the hash work and after that emphasizes over the chain at that file to discover the coordinating key. In the event that found, it expels the comparing HashNode from the chain, decrements the measure, and returns the esteem; something else, it returns invalid.
```java
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
```

### ✔ contains(V value)
> **Description:** This function checks if the hash table contains a particular esteem. It emphasizes over all the chains within the hash table and checks on the off chance that any HashNode's esteem matches the given esteem. In the event that found, it returns genuine; something else, it returns wrong.
```java
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
```

### ✔ getKey(V value)
> **Description:** This function is used to recover the esteem related with a given key from the hash table. It calculates the record utilizing the hash work and after that emphasizes over the chain at that list to discover the coordinating key. On the off chance that found, it returns the comparing esteem; something else, it returns invalid.
```java
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
```
