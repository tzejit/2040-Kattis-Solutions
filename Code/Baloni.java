import java.util.ArrayList;
import java.util.List;

public class Baloni {
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = (io.getInt());
    }
    List<Integer> arrows = new ArrayList<>();
    arrows.add(a[0] - 1);
    for (int i = 1; i < n; i++) {
      int index = arrows.indexOf(a[i]);
      if ( index != -1) {
        arrows.set(index, arrows.get(index) - 1);
      } else {
        arrows.add(a[i] - 1);
      }
    }
    io.println(arrows.size());
    io.close();
  }

}
