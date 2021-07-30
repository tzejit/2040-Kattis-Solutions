import java.util.LinkedList;

public class FerryLoadingIV {
  public static void main(String[] args) {
    LinkedList<Integer> left = new LinkedList<>();
    LinkedList<Integer> right = new LinkedList<>();
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    for (int i = 0; i < n; i++) {
      int l = io.getInt() * 100;
      int m = io.getInt();
      for (int j = 0; j < m; j++) {
        int len = io.getInt();
        String dir = io.getWord();
        if (dir.equals("left")) {
          left.offer(len);
        } else {
          right.offer(len);
        }
      }
      int trips = 0;
      boolean isleft = true;
      while(!left.isEmpty() || !right.isEmpty()) {
        int sum = l;
        if (isleft) {
          while (!left.isEmpty() && sum - left.peek() >= 0) {
            sum -= left.poll();
            
          }
          trips++;
          isleft = false;
        } else {
          while (!right.isEmpty() && sum - right.peek() >= 0) {
            sum -= right.poll();
          }
          trips++;
          isleft = true;
        }
      }
      io.println(trips);
    }
    io.close();
  }
}
