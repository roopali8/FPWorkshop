import java.util.function.BinaryOperator;


public class MonoidImpl<T> implements Monoid<T> {

  BinaryOperator<T> _operator;
  T _identity;


  public MonoidImpl(BinaryOperator operator, T identity){
    this._identity = identity;
    this._operator = operator;
  }

  @Override
  public T getIdentity() {
    return this._identity;
  }

  @Override
  public BinaryOperator<T> getOperation() {
    return this._operator;
  }

}
