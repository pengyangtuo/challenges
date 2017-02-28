import java.time.LocalDateTime;
import java.util.*;

public class LFUCache {

    private int cap;
    private int size;
    private HashMap<Integer, Item> data;

    private class Item {
        public int value;
        public LocalDateTime lastGet;

        public Item(Integer v) {
            this.value = v;
            this.lastGet = LocalDateTime.now();
        }

        public String toString() {
            return this.value + " " + this.lastGet.toString();
        }
    }

    public LFUCache(int capacity) {
        this.cap = capacity;
        this.size = 0;
        data = new HashMap<Integer, Item>();
    }

    public int get(int key) {
        return 1;
    }

    public void set(int key, int value) {
        Item newItem = new Item(value);
        this.data.put(key, newItem);
    }

    public void finePrint() {
        System.out.println("-------------------");
        Iterator<Integer> keyIterator = this.data.keySet().iterator();
        while (keyIterator.hasNext()) {
            Integer k = keyIterator.next();
            System.out.println("Key: \t" + k.toString());
            System.out.println("Value: \t" + this.data.get(k).toString());
            System.out.println("-------------------");
        }
    }

    public static void main(String[] args) {

        int capacity = 2;

        LFUCache lc = new LFUCache(capacity);

        lc.set(1, 10);
        lc.set(5, 1);

        lc.finePrint();
    }
}