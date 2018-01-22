### Class Arrays

**Arrays.asList():** Returns a fixed-size list backed by the specified array. (Changes to the returned list "write through" to the array.) This method acts as bridge between array-based and collection-based APIs, in combination with Collection.toArray(). The returned list is serializable and implements RandomAccess.

```List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");```
**Arrays.sort(array, start, end):** Sort from start index to end index in array; end index exclusive
