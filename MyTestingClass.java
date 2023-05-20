import java.util.Random;

/**
 * A class for testing purposes that generates random IDs and names for testing hash table functionality.
 *
 * @param <K> The type of the key.
 * @param <V> The type of the value.
 */
public class MyTestingClass<K, V, MyHashtable> {
    private Random random;
    private K id;
    private V name;

    /**
     * Constructor for MyTestingClass.
     *
     * @param id   The ID of the object.
     * @param name The name of the object.
     */
    public MyTestingClass(K id, V name) {
        this.id = id;
        this.name = name;
        this.random = new Random();
    }

    /**
     * Hashcode making own hash for hashtable
     * @return integer value hash
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
    /**
     * Generates 10000 random elements and adds them to a hash table.
     */
    public void tenThousandtest() {
        MyHashtable<K, V> pipi = new MyHashtable<>();
        for (int i = 0; i < 10000; i++) {
            int x = random.nextInt(1000);
            int y = random.nextInt(1000);
            MyTestingClass key = new MyTestingClass(x, y + "Student");
            pipi.put((K) key.id, (V) key.name);
        }

        // print number of elements in each bucket
        pipi.counter();

    }

    /**
     * Tests all methods in the MyHashtable
     **/
    public void tester() {
        MyHashtable hash = new MyHashtable();
        hash.put(45, "fdngdgn");
        hash.put(5, "sdfgnf");
        hash.put(4, "fngdfgn");
        hash.put(42, "hfgh");
        hash.put(23, "dsfgs");
        hash.put(42, "dfgds");
        hash.put(124, "dsfg");
        System.out.println(hash.getKey("hfgh"));
        System.out.println(hash.get(4));
        System.out.println(hash.contains("dsfg"));
        System.out.println(hash.remove(5));
        System.out.println(hash.get(5));
        //TODO defence
        System.out.println(hash.remove(4,"fngdfgn","qqqqqq"));
    }
}
