import java.util.Scanner;

public class Pot {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int sum = 0;
    for (int i = 0; i < n; i++) {
      int p = sc.nextInt();
      sum += Math.pow((int) p / 10, p % 10);
    }
    sc.close();
    System.out.println(sum);
  }  
}
