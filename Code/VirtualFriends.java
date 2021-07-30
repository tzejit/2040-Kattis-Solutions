import java.util.HashMap;

public class VirtualFriends {
  public static class UnionFind {                                              
    public int[] p;
    public int[] rank;
    public int[] size;
  
    public UnionFind(int N) {
      p = new int[N];
      rank = new int[N];
      size = new int[N];
      for (int i = 0; i < N; i++) {
        p[i] = i;
        rank[i] = 0;
        size[i] = 1;
      }
    }
  
    public int findSet(int i) { 
      if (p[i] == i) return i;
      else {
        p[i] = findSet(p[i]);
        return p[i]; 
      } 
    }
  
    public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }
  
    public void unionSet(int i, int j) { 
      if (!isSameSet(i, j)) {
        int x = findSet(i), y = findSet(j);
        // rank is used to keep the tree short
        if (rank[x] > rank[y]) {
          p[y] = x;
          size[x] += size[y];
        }
        else { 
          p[x] = y;
          size[y] += size[x];
          if (rank[x] == rank[y]) 
            rank[y] = rank[y]+1; 
        } 
      } 
    }
  }
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    for (int i = 0; i < n; i++) {
      int f = io.getInt();
      UnionFind u = new UnionFind(2*f);
      HashMap<String, Integer> map = new HashMap<>();
      int counter = 0;
      for (int j = 0; j < f; j++) {
        String n1 = io.getWord();
        String n2 = io.getWord();
        if (!map.containsKey(n1)) {
          map.put(n1,counter);
          counter++;
        }
        if (!map.containsKey(n2)) {
          map.put(n2,counter);
          counter++;
        }
        u.unionSet(map.get(n1), map.get(n2));
        io.println(u.size[u.findSet(map.get(n1))]);
      }
    }
    io.close();
  }
}
