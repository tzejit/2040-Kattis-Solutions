import java.util.Arrays;

public class SortOfSorting {
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    do {
      String[] names = new String[n];
      for (int i = 0; i < n; i++) {
        names[i] = io.getWord();
      }
      Arrays.sort(names, (x, y) -> x.charAt(1) - y.charAt(1));
      Arrays.sort(names, (x, y) -> x.charAt(0) - y.charAt(0));
      for (String name : names) {
        io.println(name);
      }
      n = io.getInt();
      if (n != 0) {
        io.println();
      }
    }
    while (n != 0);
    io.close();
  }
}
