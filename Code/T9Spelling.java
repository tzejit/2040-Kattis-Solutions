import java.lang.StringBuilder;
import java.util.Scanner;

class T9Spelling {

  public static String convert(char c) {
    String[] dict = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    String r = "";
    for (int i = 0; i < dict.length; i++) {
      int index = dict[i].indexOf(c);
      if (index != -1) {
        for (int j = 0; j < index + 1; j++) {
          r = r + i;
        }
        return r;
      }
    }
    return r;

  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < n; i++) {
      StringBuilder s = new StringBuilder();
      s.append("Case #").append(i + 1).append(": ");
      String input = sc.nextLine();
      String converted = convert(input.charAt(0));
      s.append(converted);
      for (int j = 1; j < input.length(); j++) {
        converted = convert(input.charAt(j));
        char test = converted.charAt(0);
        if (test == s.charAt(s.length() - 1)) {
          s.append(" ");
        }
        s.append(converted);
      }
      System.out.println(s.toString());
    }
    sc.close();
  }
}