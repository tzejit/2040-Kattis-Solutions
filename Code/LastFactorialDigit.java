import java.util.Scanner;

public class LastFactorialDigit {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      int f = sc.nextInt();
      if (f >= 5) {
        System.out.println(0);
      } else {
        switch (f) {
          case 1:
            System.out.println(1);
            break;
          case 2:
            System.out.println(2);
            break;
          case 3:
            System.out.println(6);
            break;
          case 4:
            System.out.println(4);
            break;
        }
      }
    }
    sc.close();
  }
}