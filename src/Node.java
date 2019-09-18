import java.util.HashSet;


public class Node<T> {
  public Node<T> _left;
  public Node<T> _right;
  public T _data;

  public Node(T data){
    this._data = data;
  }


  static Set<Node> getChildren(Set<Node> nodeSet){
    HashSet myHashSet = new HashSet();
    for (Node i : nodeSet._set){
      myHashSet.add(i._left);
      myHashSet.add(i._right);
    }
    return new Set<>(myHashSet);
  }

  Boolean BFS(Node root, T x){
    if (root._data == x){
      return Boolean.TRUE;
    }
    HashSet myHashSet = new HashSet();
    myHashSet.add(root._left);
    myHashSet.add(root._right);
    return BFS(new Set(myHashSet), x);

  }


  Boolean BFS(Set<Node> nodeSet, T x){
    HashSet myHashSet = new HashSet();

    for (Node i : nodeSet._set){
      if (i._data == x){
        return Boolean.TRUE;
      }else {
        myHashSet.add(i._left);
        myHashSet.add(i._right);
      }
    }
    if (myHashSet.size() != 0) {
      return BFS(new Set(myHashSet), x);
    }
    return Boolean.FALSE;
  }


}


