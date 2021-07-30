import java.util.HashMap;
import java.util.HashSet;

class Conformity {
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    HashMap<HashSet<Integer>, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      HashSet<Integer> combi = new HashSet<>(5);
      for (int j = 0; j < 5; j++) {
        combi.add(io.getInt());
      }
      if (map.containsKey(combi)) {
        map.put(combi, map.get(combi) + 1);
      } else {
        map.put(combi, 1);
      }
    }
    int maxval = 0;
    int multiplier = 0;
    for (Integer value : map.values()) {
      if (value > maxval) {
        maxval = value;
        multiplier = 1;
      } else if (value == maxval) {
        multiplier++;
      } 
    }
    io.println(maxval * multiplier);
    io.close();
  }
}