import com.sun.source.tree.BinaryTree;
import java.security.PublicKey;
import java.util.HashSet;

/**
 * Set is not ordered hence
 *
 * Abelien monoid: Associative and commutative
 *
 *
 */
public class Day5 {
  private static void permute(String s, int l, int r) {
    if(l==r){
      System.out.println(s);
    } else {
      for (int i =1; i< r; i++){
        s = swap(s, l, i);
        permute(s, l+1, r);
        s = swap(s, l, i);
      }
    }
  }


  private static String swap(String s, int i, int e){
    char temp;
    char[] charArray = s.toCharArray();
    temp = charArray[i];
    charArray[i] = charArray[e];
    charArray[e]= temp;
    return String.valueOf(charArray);

  }

  /**
   * Given X return neighbours for the integer
   * @param x
   * @return Set<Integer>
   */
  public static Set<Integer> neighbours(int x){
    HashSet<Integer> hashSet = new HashSet<>();
    hashSet.add(x-1);
    hashSet.add(x+1);
    return new Set<>(hashSet);
  }

//  public Set<char> findAllInterleaving(String s1, String s2){
//
//  }

  public static void main(String[] args){
//    String input = "Roopali";
//    permute(input, 0, input.length()-1);


    HashSet<Integer> myHashSet = new HashSet();
    myHashSet.add(1);
    myHashSet.add(3);
    myHashSet.add(5);
    myHashSet.add(2);

    Set<Integer> fSet = new Set<Integer>(myHashSet).flatMap(Day5::neighbours);

    System.out.println(fSet._set);

    System.out.println(permutation("ABCDEF")._set);
  }

  public static Set<String> permutation(String s){

    char[] charArray = s.toCharArray();
    HashSet<Character> charHashSet= new HashSet<Character>();

    for (char i : charArray){
      charHashSet.add(i);
    }
    Set<Character> charSet = new Set(charHashSet);
    return permutation(charSet);
  }

  private static Set<String> permutation(Set<Character> charSet) {
    if (charSet.size() == 0){
      HashSet<String> result = new HashSet<>();
      result.add("");
      return new Set<>(result);
    }

    return charSet.flatMap(ch -> permutation(charSet.rest(ch)).map(s-> ch + s));
  }
}



