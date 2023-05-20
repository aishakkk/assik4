import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable<MyTestingClass, String>();
        Random rand = new Random();
        MyTestingClass asd = new MyTestingClass(null,null);
        /*for (int i = 0; i < 10000; i++) {
            int val = rand.nextInt(0, 9);
            hashTable.put(new MyTestingClass(val), "Student " + val);
        }
         */
        asd.tester();
        /*System.out.println(hashTable.contains(1));
        System.out.println(hashTable.contains(2));
        System.out.println(hashTable.contains(3));
        System.out.println(hashTable.contains(4));
        System.out.println(hashTable.contains(5));
        System.out.println(hashTable.contains(6));
        System.out.println(hashTable.contains(7));

         */
    }
}
