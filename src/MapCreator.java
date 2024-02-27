import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MapCreator {

    public Map<Object, Integer> createMap(Object[] collection) {
        return Arrays.stream(collection).toList().stream().collect(Collectors.toMap(o -> o, o -> 1, Integer::sum));
    }
}
