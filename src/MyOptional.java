import java.util.function.Function;


public class MyOptional<E> {

  private E _item;

  public E get(){
    return _item;
  }

  public Boolean isPresent(){
    return _item != null;
  }

  public MyOptional(E item){
    this._item = item;
  }

  <F> MyOptional<F> map(Function<E,F> mapper){
    F f = null;
    if (!isPresent()){
      return new MyOptional<F>(f);
    } else {
      f = mapper.apply(_item);
      return new MyOptional<F>(f);
    }
  }
}
