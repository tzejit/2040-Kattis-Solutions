import java.util.HashMap;
class AwkwardParty {
  public static void main(String[] args) {
    HashMap<Integer, Integer> map = new HashMap<>();
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    int min = 100001;
    for (int i = 0; i < n; i++) {
      int lang = io.getInt();
      if (map.containsKey(lang)) {
        int length = i - map.get(lang);
        if (length < min) {
          min = length;
        } 
      }
      map.put(lang, i);
    }
    if (min == 100001) {
      io.println(n);
    } else {
      io.println(min);
    }
    io.close();
  }
}