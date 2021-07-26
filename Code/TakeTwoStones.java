import java.util.Scanner;

public class TakeTwoStones {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();
    String name;
    if (n % 2 == 0) {
      name = "Bob";
    } else {
      name = "Alice";
    }
    System.out.println(name);
  }
}
