import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;


public class Day1 {
  public static int max1(int a, int b){
    return (a -b > 0 )? a : b;
  }

  public static <E extends Comparable<E>> E max2(E first, E second) {
    return first.compareTo(second) >=0 ? first : second;
  }


  public static <E> E max3(E first, E second, BiFunction<E, E, Boolean> func) {
    return func.apply(first, second) ? first: second;
  }


  public static int max4(int a, int b){
    BiFunction<Integer, Integer, Boolean> greater = (x, y) -> x >= y;
    return max3(a,b, greater);
  }

  public <E> E max5(E first, E second, Comparator<E> obj) {
    return obj.compare(first, second) >= 0 ? first : second ;
  }

  public <E> E max6(E first, E second, Comparator<E> obj) {
    BiFunction<E,E,Boolean> bifunc = (a,b) -> obj.compare(a, b) >=0 ? Boolean.TRUE : Boolean.FALSE;
    return max3(first, second, bifunc);
  }

  // Problem 7
  public static Integer getFirstOdd(List<Integer> list) {
    for (Integer integer : list) {
      if (integer / 2 != 0) {
        return integer;
      }
    }
    return null;
  }

  // Problem 8
  public static Integer getFirstEven(List<Integer> list) {
    for (Integer integer : list) {
      if (integer / 2 == 0) {
        return integer;
      }
    }
    return null;
  }

  // Problem 9
  public static <T> T getFirst(List<T> list, Predicate<T> predicate) {
    for(T e : list) {
      if (predicate.test(e)){
        return e;
      }
    }
    return null;
  }

  public static Integer getFirstOdd1(List<Integer> list) {
    Predicate<Integer> odd = i -> (i / 2 != 0);
    return getFirst(list, odd);
  }

  public static Integer getFirstEven1(List<Integer> list) {
    Predicate<Integer> even = i -> (i / 2 == 0);
    return getFirst(list, even);
  }


  /**
   * Problem: 10
   *
   * Solution:

  **/

  // Solution 12
  public <E> Boolean equal(E first, E second){
    return Objects.equals(first, second);
  }


  // Solution 13
  <E> Function<E, Boolean> isEqual(E e) {
    return a -> a.equals(e);
  }

  // Solution 14
  public <E> E equal11(MyList<E> list, E second){
    Predicate<E> equalPredicate = a -> isEqual(second).apply(a);
    return list.findFirst(equalPredicate);
  }

  // Solution 15
  public static <T> Predicate<T> isApplicable(T t, BiFunction<T, T, Boolean> biFunction) {
    return a -> biFunction.apply(a, t);
  }

  // Solution 16
  public static void testCode(MyList<String> list, String s1) {

    final String nonNull = list.findFirst(Objects::nonNull);
    System.out.println(nonNull);

    final String nonNonEmpty = list.findFirst(String::isEmpty);
    System.out.println(nonNonEmpty);

    final String first = list.findFirst(s1::equalsIgnoreCase);
    System.out.println(first);

  }

  public static void main(String args[]) {
    List<String> list11 = Arrays.asList("bel", "Roopali", "bleh", "blah", "Nope");
    MyList<String> stringList = new MyList(list11);
    testCode(stringList, "blah");
  }
}