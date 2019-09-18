import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import javafx.util.Pair;


public class Day2 {
  static <A,B,C> Function<A,C> compose(Function<A,B> f, Function<B,C> g){
    return t -> g.apply(f.apply(t));
    // return f.andThen(g);
  }

  static <A,B,C> Function<B,C> partialApply(BiFunction<A,B,C> biFunction, A a){
    return b -> biFunction.apply(a,b);
  }

  static <A,B,C> Function<A, Function<B,C>> curry(BiFunction<A,B,C> biFunction){
    return a -> partialApply(biFunction, a);
  }

  static Integer sum(List<Integer> list){
    Integer sum = 0;
    for(Integer item : list) {
      sum += item;
    }
    return sum;
  }

  static Integer sum1(Integer a, Integer b){
    return a + b;
  }

  static Integer product1(Integer a, Integer b){
    return a * b;
  }

  static Integer product(List<Integer> list){
    Integer product = 1;
    for(Integer item : list) {
      product *= item;
    }
    return product;
  }

  static Integer add1(Integer a){
    return a + 1;
  }

  static Integer substract2(Integer a){
    return a - 2;
  }


  static Integer sumMoniod(List<Integer> list){
    BinaryOperator<Integer> adder = (n1, n2) -> n1 + n2;
    MonoidImpl<Integer> sumMoniod = new MonoidImpl<Integer>(adder , 0);

    Integer sum = sumMoniod.getIdentity();
    for (Integer item : list) {
      sum = sumMoniod.getOperation().apply(sum, item);
    }
    return sum;
  }

  static Integer productMoniod(List<Integer> list){
    BinaryOperator<Integer> product = (n1, n2) -> n1 * n2;
    MonoidImpl<Integer> productMoniod = new MonoidImpl<>(product , 1);

    Integer result = productMoniod.getIdentity();
    for (Integer item : list) {
      result = productMoniod.getOperation().apply(result, item);
    }
    return result;
  }

  static Integer length(MyList<String> stringList){
    BinaryOperator<String> adder = (n1, n2) -> n1 + n2;
    MonoidImpl<String> sumMoniod = new MonoidImpl<String>(adder , "");
    String res =  stringList.fold(sumMoniod);
    return res.length();
  }

//  static Integer length1(MyList<String> stringList){
//    BinaryOperator<Integer> adder = (n1, n2) -> n1 + n2;
//    MonoidImpl<Integer> sumMoniod = new MonoidImpl<Integer>(adder , 0);
//    String res =  stringList..fold(sumMoniod);
//    return res.length();
//  }

//  static MyList<Integer> sorting(MyList<Integer> stringList){
//
//    BinaryOperator<MyList<Integer>> sort = (n1, n2) -> {
//      MyList<Integer> res = new MyList(new ArrayList());
//      if (n1.myList.size() == 0){
//        return n1;
//      }
//      if (n2.myList.size() == 0){
//        return n2;
//      }
//      for (int i=0, j=0; i == n1.myList.size() -1 && i == n1.myList.size() -1;){
//        if (n1.get(i) > n2.get(j)){
//          res.add(n1.get(i));
//          i++;
//        } else{
//          res.add(n2.get(j));
//          j++;
//        }
//      }
//      return res;
//    };
//
//
//    MonoidImpl<Integer> sortMoniod = new MonoidImpl<>(sort , 1);
//
//  }

  static MyList<Pair<Integer, Integer>> crossProduct1(MyList<Integer> input1, MyList<Integer> input2){
    ArrayList<Pair<Integer, Integer>> resList = new ArrayList<>();
    for (Integer m : input1.myList){
      for (Integer n : input2.myList) {
        resList.add(new Pair<>(m, n));
      }
    }
    return new MyList(resList);
  }

  public static void main(String args[]){
    List<Integer> list11 = Arrays.asList(1, 10, 50,30, 20);
    List<Integer> list12 = Arrays.asList(1, -1, 50,30, 20);

    // final Function<Integer, Integer> compose = compose(Day2::sum, Day2::product);
    System.out.println(curry(Day2::sum1).apply(2).apply(4));
    System.out.println(compose(Day2::add1, Day2::substract2).apply(2));

    System.out.println(compose(Day2::add1, Day2::substract2).apply(2));
  }
}


