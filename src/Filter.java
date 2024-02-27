import java.util.function.Function;

interface Filter<T, R> extends Function<Object, R> {
    @Override
    R apply(Object o);
}
