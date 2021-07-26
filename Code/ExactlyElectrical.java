public class ExactlyElectrical {
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int x = io.getInt();
    int y = io.getInt();
    x = Math.abs(x - io.getInt());
    y = Math.abs(y - io.getInt());
    int tot = x + y;
    int energy = io.getInt();
    if (energy < tot) {
      io.println("N");
    } else if (energy % 2 != tot % 2) {
      io.println("N");
    } else {
      io.println("Y");
    }
    io.close();
  }
}
