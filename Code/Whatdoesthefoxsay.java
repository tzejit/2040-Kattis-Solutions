import java.util.Scanner;
import java.util.HashSet;

public class Whatdoesthefoxsay {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    for (int j = 0; j < n; j++){
      String[] sound = sc.nextLine().split(" ");
      String next = sc.nextLine();
      HashSet<String> set = new HashSet<>();
      while (!next.equals("what does the fox say?")) {
        set.add(next.split(" ")[2]);
        next = sc.nextLine();
      }
      for (int i = 0; i < sound.length - 1; i++) {
        if (!set.contains(sound[i])) {
          System.out.print(sound[i] + " ");
        }
      }
      if (!set.contains(sound[sound.length - 1])) {
        System.out.print(sound[sound.length - 1]);
      }
      System.out.println();
    }
    sc.close();
  }
}
