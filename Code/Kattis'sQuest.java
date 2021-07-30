import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class KattissQuest {
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    TreeMap<Integer, PriorityQueue<Integer>> tree = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      String c = io.getWord();
      int e = io.getInt();
      if (c.equals("add")) {
        int g = io.getInt();
        if (tree.containsKey(e)) {
          tree.get(e).add(g);
        } else {
          PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
          q.add(g);
          tree.put(e, q);
        }
      } else {
        long gold = 0;
        Integer key = tree.floorKey(e);
        while (key != null && e > 0) {
          e -= key;
          PriorityQueue<Integer> temp = tree.get(key);
          gold += temp.poll();
          if (temp.isEmpty()) {
            tree.remove(key);
          }
          key = tree.floorKey(e);
        }
        io.println(gold);
      }
    }
    io.close();
  }
}
