import java.util.LinkedList;

public class GregorytheGrasshopper {
  public static class Pair {
    int r;
    int c;
    public Pair(int i, int j) {
      r = i;
      c = j;
    }
  }
  public static int[][] hops = new int[][] {{-1,2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2},{2,-1},{2,1},{1,2}};
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    while (io.hasMoreTokens()) {
      int r = io.getInt();
      int c = io.getInt();
      int gr = io.getInt()-1;
      int gc = io.getInt()-1;
      int lr = io.getInt()-1;
      int lc = io.getInt()-1;
      boolean[][] visited = new boolean[r][c];
      Pair[][] p = new Pair[r][c];
      LinkedList<Pair> q = new LinkedList<>();
      visited[gr][gc] = true;
      q.offer(new Pair(gr,gc));
      while (!q.isEmpty()) {
        Pair t = q.poll();
        for (int[] a : hops) {
          int rt = t.r + a[0];
          int ct = t.c + a[1];
          if (rt >= 0 && rt < r && ct >= 0 && ct < c && !visited[rt][ct]) {
            visited[rt][ct] = true;
            p[rt][ct] = t;
            q.offer(new Pair(rt,ct));
          }
        }
      }
      if (!visited[lr][lc]) {
        io.println("impossible");
      } else {
        int count = 0;
        Pair curr = p[lr][lc];
        while (curr != null) {
          count++;
          curr = p[curr.r][curr.c];
        }
        io.println(count);
      }
    }
    io.close();
  }
}
