import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
public class GrandpaBernie {
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    int n = io.getInt();
    for (int i = 0; i < n; i++) {
      String c = io.getWord();
      if (map.containsKey(c)) {
        map.get(c).add(io.getInt());
      } else {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(io.getInt());
        map.put(c, temp);
      }
    }
    for (ArrayList<Integer> a : map.values()) {
      Collections.sort(a);
    }
    int q = io.getInt();
    for (int i = 0; i < q; i++) {
      io.println(map.get(io.getWord()).get(io.getInt() - 1));
    }
    io.close();
  }
}
