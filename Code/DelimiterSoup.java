import java.util.Stack;
import java.util.Scanner;

public class DelimiterSoup {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Stack<Character> s = new Stack<>();
    int n = sc.nextInt();
    sc.nextLine();
    char[] c = sc.nextLine().toCharArray();
    for (int i = 0; i < n; i++) {
      if (c[i] != '}' && c[i] != ']' && c[i] != ')') {
        if (c[i] != ' ') {
          s.push(c[i]);
        }
      } else {
          if (s.empty()) {
            System.out.println(c[i] + " " + i);
            return; 
          } else if ((c[i] == ')' && s.peek() == '(') || (c[i] == ']' && s.peek() == '[')||(c[i] == '}' && s.peek() == '{')) {
            s.pop();
          } else {
            System.out.println(c[i] + " " + i);
            return;
          }
        }
    }
    sc.close();
    System.out.println("ok so far");
  }
}
