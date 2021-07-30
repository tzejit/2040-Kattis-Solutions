import java.util.Arrays;
import java.util.PriorityQueue;

class AssigningWorkstations {

  public static class Pair implements Comparable<Pair>{
    int start;
    int end;
    public Pair(int start, int len) {
      this.start = start;
      this.end = start + len;
    }

    @Override
    public int compareTo(Pair p) {
      int time = this.start - p.start;
      if (time == 0) {
        return this.end - p.end;
      }
      return time;
    }

    @Override
    public String toString(){
      return "Start: " + this.start + " End: "+ this.end;
    }

  }
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    int m = io.getInt();
    Pair[] p = new Pair[n];
    PriorityQueue<Pair> ws = new PriorityQueue<>((x1, x2) -> (x1.end-x2.end));
    for (int i = 0; i < n; i++) {
      p[i] = new Pair(io.getInt(), io.getInt());
    }
    int unlocks = 0;
    Arrays.sort(p);
    for (int i = 0; i < n; i++) {
      Pair p1 = p[i];
      while (!ws.isEmpty() && p1.start > ws.peek().end + m) {
        ws.poll();
      }
      if (ws.isEmpty()) {
        unlocks++;
        ws.add(p[i]);
      } else if (p1.start < ws.peek().end) {
        unlocks++;
        ws.add(p1);
      } else {
        ws.poll();
        ws.add(p1);
      }
    }
    io.println(n-unlocks);
    io.close();
  }
}