import java.util.Arrays;
import java.util.Collections;
public class Akcija {
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    Integer[] books = new Integer[n];
    for (int i = 0; i < n; i++) {
      books[i] = io.getInt();
    }
    Arrays.sort(books, Collections.reverseOrder());
    int groups = (int) n / 3;
    int price = 0;
    int total = 0;
    for (int i = 0; i < n; i++){
      total += books[i];
    }
    for (int i = 0; i < groups; i++){
      price += books[i * 3 + 2];
    }
    io.println(total - price);
    io.close();

  }
}
