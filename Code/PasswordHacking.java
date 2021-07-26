import java.util.Arrays;

public class PasswordHacking {
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int pass = io.getInt();
    double[] p = new double[pass];
    for (int i = 0; i < pass; i++) {
      io.getWord();
      p[i] = io.getDouble();
    }
    Arrays.sort(p);
    double prob = 0;
    for (int i = 0; i < pass; i++) {
      prob += (i + 1) * p[p.length - 1 - i];
    }
    io.println(prob);
    io.close();
  }
}
