import java.util.ArrayList;
import java.util.LinkedList;

public class Hyacinth {
  public static class Pair {
    int f1;
    int f2;
    public Pair(int i, int j) {
      f1 = i;
      f2 = j;
    }
  }
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    Pair[] p = new Pair[n];
    int count = 1;
    ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
    for (int i = 0; i < n ; i++) {
      adjlist.add(new ArrayList<>());
      p[i] = new Pair(-1,-1);
    } 
    for (int i = 0; i < n -1 ; i++) {
      int n1 = io.getInt()-1;
      int n2 = io.getInt()-1;
      adjlist.get(n1).add(n2);
      adjlist.get(n2).add(n1);
    }
    LinkedList<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[n];
    visited[0] = true;
    q.offer(0);
    while (!q.isEmpty()) {
      int t = q.poll();
      Pair tp = p[t];
      boolean alt = true;
      if (tp.f1 == -1) {
        tp.f1 = count++;
      }
      if (tp.f2 == -1) {
        tp.f2 = count++;
      } 
      ArrayList<Integer> nei = adjlist.get(t);
      if (nei.size() == 1 && !visited[nei.get(0)]) {
        Pair neip = p[nei.get(0)]; 
        visited[nei.get(0)] = true;
        if (neip.f1 != -1)
          tp.f1 = neip.f1;
        else 
         neip.f1 = tp.f1;
        if (neip.f2 != -1)
          tp.f2 = neip.f2;
        else 
          neip.f2 = tp.f2;
        q.offer(nei.get(0));
      }
      for (int i : nei) {
        if (!visited[i]) {
          visited[i] = true;
          if (p[i].f1 == -1) {
            if (alt)
              p[i].f1 = tp.f2;
            else 
              p[i].f1 = tp.f1;
          } else if (alt) {
            p[i].f2 = tp.f2;
          } else {
            p[i].f2 = tp.f1;
          }
          if (alt) {
            alt = false;
          } else 
            alt = true;
          q.push(i);
        }
      }
    }
    for (Pair pr : p) {
      io.println(pr.f1 + " " + pr.f2);
    }
    io.close();
  }
}
