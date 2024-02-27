import java.util.Collection;
import java.util.List;

public class CollectionFilter {

    public <T, R> Collection<?> filter(Collection<?> collection, Filter<T, R> filter) {
        return List.of(collection.stream().map(filter).toArray());
    }
}
