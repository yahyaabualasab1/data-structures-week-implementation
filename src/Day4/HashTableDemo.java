package Day4;
import java.util.*;

// ===================== Hash Table =====================
class HashTable {
    private int capacity;
    private LinkedList<Pair>[] table;

    // زوج key-value
    static class Pair {
        String key;
        String value;

        Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public HashTable(int cap) {
        capacity = cap;
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // دالة hash بسيطة
    private int hashFunction(String key) {
        int sum = 0;
        for (char c : key.toCharArray()) {
            sum += c;
        }
        return sum % capacity;
    }

    // put / insert
    public void put(String key, String value) {
        int index = hashFunction(key);
        for (Pair pair : table[index]) {
            if (pair.key.equals(key)) {
                pair.value = value; // تحديث القيمة إذا المفتاح موجود
                return;
            }
        }
        table[index].add(new Pair(key, value));
    }

    // get / find
    public String get(String key) {
        int index = hashFunction(key);
        for (Pair pair : table[index]) {
            if (pair.key.equals(key)) {
                return pair.value;
            }
        }
        return "Key not found";
    }

    // remove
    public boolean remove(String key) {
        int index = hashFunction(key);
        Iterator<Pair> it = table[index].iterator();
        while (it.hasNext()) {
            Pair pair = it.next();
            if (pair.key.equals(key)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    // طباعة الجدول
    public void printTable() {
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Pair pair : table[i]) {
                System.out.print("[" + pair.key + " : " + pair.value + "] ");
            }
            System.out.println();
        }
    }
}

// ===================== MAIN =====================
public class HashTableDemo {
    public static void main(String[] args) {
        HashTable ht = new HashTable(7);

        // إدخال عناصر
        ht.put("Ali", "12345");
        ht.put("Sara", "67890");
        ht.put("Omar", "11111");
        ht.put("Zain", "22222");

        System.out.println(" Hash Table after insertions:");
        ht.printTable();

        // البحث
        System.out.println("\n Find Ali: " + ht.get("Ali"));
        System.out.println(" Find Sara: " + ht.get("Sara"));
        System.out.println("Find Yara: " + ht.get("Yara")); // غير موجودة

        // حذف
        System.out.println("\n Removing Omar...");
        ht.remove("Omar");

        System.out.println("\n Hash Table after removal:");
        ht.printTable();
    }
}

