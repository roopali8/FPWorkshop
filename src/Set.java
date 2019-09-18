import java.util.HashSet;
import java.util.function.Function;


/**
 * Set is not ordered hence cannot apply operator that are not commutative
 *
 */
public class Set<E> {

  public java.util.Set<E> _set;

  public Set(java.util.Set set){
    this._set = set;
  }

  E fold(Monoid<E> monoid){
    E res = monoid.getIdentity();
    for (E e : _set){
      res = monoid.getOperation().apply(res, e);
    }
    return res;
  }

  <F> Set<F> map(Function<E,F> mapper){
    HashSet hashSet = new HashSet();
    for (E item : _set){
      hashSet.add(mapper.apply(item));
    }

    return new Set(hashSet);
  }

  Set<E> union(Set<E> a){
    Set<E> res = new Set<>(new HashSet());
    res._set.addAll(this._set);
    res._set.addAll(a._set);
    return res;
  }

  <F> Set<F> flatMap(Function<E,Set<F>> mapper){
    HashSet<F> hashSet = new HashSet<>();
    for (E e : _set){
      Set<F> res = mapper.apply(e);
      hashSet.addAll(res._set);
    }
    return new Set<>(hashSet);
  }

  Set<E> rest(E e){
    HashSet<E> newHashSet = new HashSet<>();
    for (E t : _set){
      if (t != e) {
        newHashSet.add(t);
      }
    }
    return new Set<>(newHashSet);
  }

  public int size(){
    return _set.size();
  }
}
