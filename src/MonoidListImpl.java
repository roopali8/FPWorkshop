import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;


public class MonoidListImpl<T> implements MonoidList {

  BinaryOperator<List<T>> _operator;
  List<T> _identity;
  Set<List<T>> _list;

  public MonoidListImpl(BinaryOperator operator, List<T> identity, Set<List<T>> list){
    this._identity = identity;
    this._operator = operator;
    this._list = list;
  }

  @Override
  public List<T> getIdentity() {
    return this._identity;
  }

  @Override
  public BinaryOperator<List<T>> getOperation() {
    return this._operator;
  }

}
