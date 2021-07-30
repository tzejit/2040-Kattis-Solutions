import java.util.ArrayList;
public class Dominos {
  public static ArrayList <Integer> toposort;
  public static ArrayList <ArrayList<Integer>> AdjList;
  public static int count;
  public static boolean[] visited;
  public static boolean[] visited2;

  public static void dfs(int u) { //topo sort
    visited[u] = true;
    ArrayList<Integer> t = AdjList.get(u);
    for (int i : t) {
      if (!visited[i]) {
        dfs(i);
      }
    }
    toposort.add(u);
  }

  public static void dfs2(int u) { //Kosaraju's algo
    visited2[u] = true;
    ArrayList<Integer> t = AdjList.get(u);
    for (int i : t) {
      if (!visited2[i]) {
        dfs2(i);
      }
    }
  }

  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    for (int i = 0; i < n; i++) {
      count = 0;
      toposort = new ArrayList<>();
      int num = io.getInt();
      int m = io.getInt();
      visited  = new boolean[num];
      visited2 = new boolean[num];
      AdjList= new ArrayList<ArrayList<Integer>>();
      for (int j = 0; j < num; j++) {
        AdjList.add(new ArrayList<>());
      }

      for (int j = 0; j < m; j++) { //initialization 
        AdjList.get(io.getInt() - 1).add(io.getInt() - 1);
      }

      for (int key = 0; key < num; key++) {
        if (!visited[key]) {
          dfs(key);
        }
      }

      for (int v = num - 1; v >= 0; v--) {
        int t = toposort.get(v);
        if (!visited2[t]) {
          dfs2(t);
          count++;
        }
      }
      io.println(count);
    }
    io.close();
  }
}
