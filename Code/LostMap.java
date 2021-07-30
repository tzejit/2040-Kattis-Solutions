import java.util.ArrayList;
class LostMap {

  public static final int INF = 1000000000;

  public static class Int2 {
    int v;
    int d;
    public Int2(int i, int k) {
      v = i;
      d = k;
    }
  }

  public static class IntPair {
    int v;
    int d;
    public IntPair(int i, int j) {
      v = i;
      d = j;
    }
  }
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    Int2[] A = new Int2[n];
    ArrayList<ArrayList<IntPair>> adjlist = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjlist.add(new ArrayList<>());
    }
    for (int i = 0; i < n; i++) {
      A[i] = new Int2(-1,INF);
      for (int j = 0; j < i; j++) {
        int i1 = io.getInt();
        if (i1 != 0) {
          adjlist.get(i).add(new IntPair(j, i1));
          adjlist.get(j).add(new IntPair(i, i1));
        }
      }
      for (int j = 0; j < n - i; j++) {
        io.getInt();
      }
    }
    A[0] = new Int2(0,0);
    boolean[] visited = new boolean[n];
    int count = 0;
    while (count != n) {
      Int2 small = null;
      int sm0l = 0;
      int size = INF;
      for (int i = 0; i < n; i++) {
        Int2 s = A[i];
        if (s.d < size  && !visited[i]) {
          small = s;
          sm0l = i;
          size = s.d;
        }
      }
      count++;
      small.d = INF;
      visited[sm0l] = true;
      for (IntPair p : adjlist.get(sm0l)) {
        if (!visited[p.v] && A[p.v].d > p.d) {
          A[p.v] = new Int2(sm0l,p.d);
        }
      }
    }
    for (int i = 1; i < n; i++) {
      io.println((A[i].v+1) + " "+ (i+1));
    } 
    io.close();
  }
}