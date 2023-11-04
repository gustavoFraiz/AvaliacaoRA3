import java.util.Random;

public class Main {
    public static void main(String[] args) {
        hashTable hash = new hashTable(10,1);

        long seed = 1231315414;
        Random random = new Random(seed);
        for (int i = 0; i < 9; i++) {
            hash.put(random.nextInt());
        }
        hash.put(666);

        hash.imprime();
        System.out.println("-----------------");
        System.out.println(hash.busca(666));
    }
}