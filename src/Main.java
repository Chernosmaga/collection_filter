import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Filter<Integer, Integer> filter = i -> (int) i + 1;
        List<Integer> ints = List.of(1, 2, 3, 4, 5);
        CollectionFilter collectionFilter = new CollectionFilter();
        List<Integer> incremented = (List<Integer>) collectionFilter.filter(ints, filter);
        System.out.println(incremented);

        MapCreator mapCreator = new MapCreator();
        Object[] objects = {"Apple", "Banana", "Orange", "Banana", "Plum", "Apple"};
        Map<Object, Integer> map = mapCreator.createMap(objects);
        for (Map.Entry<Object, Integer> object: map.entrySet()) {
            System.out.println(object.getKey() + " : " + object.getValue());
        }
    }
}