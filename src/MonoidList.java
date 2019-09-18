import java.util.List;
import java.util.function.BinaryOperator;


public interface MonoidList<T>{


  List<T> getIdentity();
  BinaryOperator<List<T>> getOperation();

}
