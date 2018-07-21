### List
#### 1. Basic
```List<Obj> list = new List<Obj> ();```

- **void add(int index, Object O)**
- **void addAll(int index, Object O):** all elements from specified collection to list. First element gets inserted at given index. If there is already an element at that position, that element and other subsequent elements(if any) are shifted to the right by increasing their index.
- **Object remove(int index)**
- **Object get(int index)**
- **Object set(int index, Object new)**
- **List subList(int from, int to)**
- **int size()**

#### 2. Array & List
- Array to List: `Arrays.asList(array)`
- List to Array: `list.toArray()`
