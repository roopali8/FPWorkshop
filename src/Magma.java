import java.util.function.BinaryOperator;

public interface Magma<T> {

  BinaryOperator<T> getOperation();

}
