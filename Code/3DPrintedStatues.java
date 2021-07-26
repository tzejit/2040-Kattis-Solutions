public class a3DPrintedStatues {
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    int printers = 1;
    int days = 0;
    while (printers < n) {
      printers = printers * 2;
      days++;
    }
    io.println(days + 1);
    io.close();
    
  }
}
