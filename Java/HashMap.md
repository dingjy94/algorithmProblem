

### HashMap
#### 1. Map.Entry
```for(Map.Entry<Integer, Integer> entry : map.entrySet()) {}```
Loop all entry in ```Map```. The ```entrySet()``` method declared by the Map interface returns a Set containing the map entries. Each of these set elements is a ```Map.Entry``` object.

```boolean equals(Object obj)```: Returns true if obj is a ```Map.Entry``` whose key and value are equal to that of the invoking object.
```getKey(), getValue(), hashCode(), setValue()```

```public V put(K key, V value)```: Return the previous value associated with key, or null if there was no mapping for key


### HashSet
```boolean HashSet.add(E e)```: for HashMap and HashTable is put; return 1 if can add

