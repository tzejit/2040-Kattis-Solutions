import java.util.TreeMap;

public class Binarysearchtree {

  public static class Node {
    int depth = 0;
    boolean left,right = false;
    public Node(int d) {
      depth = d;
    }
  }
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    int t = io.getInt();
    TreeMap<Integer, Node> tree = new TreeMap<>();
    tree.put(t, new Node(0));
    long count = 0;
    io.println(count);
    for (int i = 1; i < n; i++) {
      int d = 0;
      t = io.getInt();
      Integer ceil = tree.ceilingKey(t);
      Integer flr = tree.floorKey(t);
      //io.println(ceil + " " + flr);
      if (flr != null && ceil != null) {
        Node floor = tree.get(flr);
        Node ceiling = tree.get(ceil);
        if (!floor.right && !ceiling.left) {
          if (t < tree.higherKey(flr)) {
            d = floor.depth + 1;
            floor.right = true;
          } else {
            d = ceiling.depth + 1;
            ceiling.left = true;
          }
        } else if (!floor.right) {
          d = floor.depth + 1;
          floor.right = true;
        } else {
          d = ceiling.depth + 1;
          ceiling.left = true;
        }
      } else if (flr != null) {
        Node floor = tree.get(flr);
        d = floor.depth + 1;
        floor.right = true;
      } else {
        Node ceiling = tree.get(ceil);
        d = ceiling.depth + 1;
        ceiling.left = true;
      }
      tree.put(t, new Node(d));
      count += d;
      io.println(count);
    }
    io.close();
  }
}
