import java.util.Scanner;

public class DetailedDifferences {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    String result = "";
    for (int i = 0; i < num;i++) {
      String s1 = sc.next();
      String s2 = sc.next();
      int len = s1.length();
      result += s1 + "\n" + s2 + "\n";
      for (int j = 0; j < len; j++) {
        if (s1.charAt(j) == s2.charAt(j)) {
          result += ".";
        } else {
          result += "*";
        }
      }
      result += "\n\n";
      }
    sc.close();
    System.out.println(result);
  }
}