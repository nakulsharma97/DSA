class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> l = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!l.containsKey(key)) {
            return -1;
        }
        int value = l.get(key);
        l.remove(key);
        l.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (l.containsKey(key)) {
            l.remove(key);
        } else if (l.size() == capacity) {
            int lru = l.keySet().iterator().next(); // first key = LRU
            l.remove(lru);
        }
        l.put(key, value);
    }
}