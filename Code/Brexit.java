import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Brexit {
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int c = io.getInt();
    HashMap<Integer, HashSet<Integer>> adjlist = new HashMap<>();
    int[] size = new int[c];
    int p = io.getInt();
    int x = io.getInt()-1;
    int l = io.getInt()-1;
    for (int i = 0; i < c; i++) {
      adjlist.put(i, new HashSet<>());
    }
    for (int i = 0; i < p; i++) {
      int c1 = io.getInt()-1;
      int c2 = io.getInt()-1;
      adjlist.get(c1).add(c2);
      adjlist.get(c2).add(c1);
      size[c1]++;
      size[c2]++;
    }
    LinkedList<Integer> q = new LinkedList<>();
    q.push(l);
    while (!q.isEmpty()) {
      Integer temp = q.poll();
      if (adjlist.get(temp) == null) {
        break;
      }
      for (int i : adjlist.get(temp)) {
        adjlist.get(i).remove(temp);
        if (adjlist.get(i).size() * 2 <= size[i]) {
          q.push(i);
        }
      }
      adjlist.remove(temp); 
    }
    HashSet xh = adjlist.get(x);
    io.println(xh == null || xh.size() * 2 <= size[x] ? "leave" : "stay");
    io.close();
  }
}
