import java.util.Scanner;

class TrainPassengers{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int cap = sc.nextInt();
    int stn = sc.nextInt();
    int num = 0;
    int left;
    int enter;
    int wait;
    for (int i = 0; i < stn - 1; i++) {
      left = sc.nextInt();
      enter = sc.nextInt();
      wait = sc.nextInt();
      if (num - left < 0 || num - left + enter > cap) {
        System.out.println("impossible");
        return;
      } else {
        num = num - left + enter;
        if (num < cap && wait != 0) {
          System.out.println("impossible");
          return;
        }
      }
    }
    left = sc.nextInt();
    enter = sc.nextInt();
    wait = sc.nextInt();
    if (wait != 0 || enter != 0 || left != num) {
      System.out.println("impossible");
      return;
    }
    sc.close();
    System.out.println("possible");
  }
}