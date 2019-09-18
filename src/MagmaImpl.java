import java.util.function.BinaryOperator;


public class MagmaImpl<T> implements Magma{
  BinaryOperator<T> opt;

  MagmaImpl(BinaryOperator opterator) {
    opt = opterator;
  }

  public BinaryOperator<T> getOperation(){
    return opt;
  };


  T compute (T a, T b, T c, Magma<T> magma) {
    return magma.getOperation().apply(magma.getOperation().apply(a, b), c);
  }

}
