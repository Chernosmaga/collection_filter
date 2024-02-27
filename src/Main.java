import java.util.List;

public class Main {
    public static void main(String[] args) {
        Filter<Integer, Integer> filter = i -> (int) i + 1;
        List<Integer> ints = List.of(1, 2, 3, 4, 5);
        CollectionFilter collectionFilter = new CollectionFilter();
        List<Integer> incremented = (List<Integer>) collectionFilter.filter(ints, filter);
        System.out.println(incremented);
    }
}