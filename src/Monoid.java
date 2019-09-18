import java.util.function.BinaryOperator;


public interface Monoid<T> extends Magma<T>{


  T getIdentity();

}
