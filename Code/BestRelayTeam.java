import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class BestRelayTeam {

  public static class Runner implements Comparable<Runner>{
    public String name;
    public double time1;
    public double time2;

    public Runner(String name, double time1, double time2) {
      this.name = name;
      this.time1 = time1;
      this.time2 = time2;
    }
    //for debugging
    @Override
    public String toString() {
      return this.name;
    }

    @Override
    public int compareTo(Runner r) {
      return this.time2 - r.time2 > 0 ? 1 : -1;
    }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    List<Runner> runners = new ArrayList<>();
    for (int i = 0; i < num; i++) {
      runners.add(new Runner(sc.next(), sc.nextDouble(), sc.nextDouble()));
    }
    sc.close();
    Collections.sort(runners);
    double tot = Double.MAX_VALUE;
    String[] names = new String[4];
    String[] namesfinal = new String[4];
    int i;
    for (i = 0; i < num; i++) {
      double time;
      Runner r1 = runners.get(i);
      time = r1.time1;
      names[0] = r1.name;
      List<Runner> runners2 = new ArrayList<>();
      runners2.addAll(runners);
      runners2.remove(i);
      for (int j = 0; j < 3; j++) {
        Runner r = runners2.get(j);
        names[j + 1] = r.name;
        time += r.time2;
      }
      if (time < tot) {
        tot = time;
        namesfinal = names.clone();
      }
    }
    System.out.println(tot);
    for (String s : namesfinal) {
      System.out.println(s);
    }
  }
}
