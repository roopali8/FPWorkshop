import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;


public class MyList<E> {

  public List<E> myList;
  public MyList<E> prevList;
  public E e;

  public MyList(List<E> list) {
    myList = list;
  }

  public MyList(MyList<E> list, E e) {
    this.prevList = list;
    this.e = e;
  }

  public E findFirst(Predicate<E> predicate){
    for (E item : myList) {
      if (predicate.test(item)) {
        return item;
      }
    }
    return null;
  }

  public MyList<E> add(E e) {
    return new MyList<E>(this, e);
  }

  public E get(int index) {
    int size = this.myList.size();
    if (index == size)
      return this.e;
    if (index < size)
      return this.myList.get(index);
    throw new IllegalArgumentException();
  }

  // Applies the Monoid operation to the _list items.
  public E fold(Monoid<E> monoid) {
    E res = monoid.getIdentity();
    for (E item : myList){
      res = monoid.getOperation().apply(res, item);
    }
    return res;
  }

  public <R> R fold(BiFunction<R, E, R> biFunction, R zero) {
    R res = zero;
    for (E item : myList){
      res = biFunction.apply(res, item);
    }
    return res;
  }

  public MyList<E> copy(){
    return fold(MyList::add, new MyList<>(new ArrayList<>()));
  }

  public E foldRecur(Monoid<E> monoid) {
    return recur(myList, monoid);
  }

  private E recur(List<E> e, Monoid<E> monoid){
    if (e.size() != 0){
      E item = e.get(e.size()-1);
      List<E> newList = e.subList(0, e.size()-2);
      return monoid.getOperation().apply((E) newList, recur(e, monoid));
    }
    return monoid.getIdentity();
  }

  public <F> MyList<F> ap(MyList<Function<E,F>> list){
    ArrayList<F> resList = new ArrayList<F>();
    for (Function<E,F> fxn : list.myList) {
      for (E item : myList) {
        F res = fxn.apply(item);
        resList.add(res);
      }
    }
    return new MyList<>(resList);
  }

  <F> MyList<F> map(Function<E,F> mapper){
    ArrayList<F> resList = new ArrayList<>();
    for (E item : myList) {
      F res = mapper.apply(item);
      resList.add(res);
    }
    return new MyList<>(resList);
  }
}
