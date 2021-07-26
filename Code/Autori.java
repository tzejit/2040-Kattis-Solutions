import java.util.Scanner;
import java.lang.StringBuilder;

public class Autori {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    char[] name = sc.next().toCharArray();
    sc.close();
    StringBuilder a = new StringBuilder();
    a.append(name[0]);
    for (int i = 1; i < name.length; i++) {
      if (name[i] == '-')
        a.append(name[i+1]);
    }
    System.out.println(a.toString());
  }
}