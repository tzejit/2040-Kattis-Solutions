import java.util.Scanner;

public class NumberFun {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] p = new String[n];
    for (int i = 0; i < n; i++) {
      int num1 = sc.nextInt();
      int num2 = sc.nextInt();
      int sum = sc.nextInt();
      if ((num1 + num2 == sum) || (num1 * num2 == sum)) {
        p[i] = "Possible";
      } else if ((Math.abs(num1 - num2) == sum) || 
            ((num1 / num2 == sum) && (num1 % num2 == 0)) || ((num2 / num1 == sum) && (num2 % num1 == 0))) {
        p[i] = "Possible";
      } else {
        p[i] = "Impossible";
      }
    }
    sc.close();
    for (String s : p) {
      System.out.println(s);
    }
  }
}
