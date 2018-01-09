## Useful Java features in algorithm problems

### HashMap
#### 1. Map.Entry
```for(Map.Entry<Integer, Integer> entry : map.entrySet()) {}```
Loop all entry in ```Map```. The ```entrySet()``` method declared by the Map interface returns a Set containing the map entries. Each of these set elements is a ```Map.Entry``` object.

```boolean equals(Object obj)```: Returns true if obj is a ```Map.Entry``` whose key and value are equal to that of the invoking object.
```getKey(), getValue(), hashCode(), setValue()```
