public class SwapToSort {

  public static class UnionFind {                                              
    public int[] p;
    public int[] rank;
  
    public UnionFind(int N) {
      p = new int[N];
      rank = new int[N];
      for (int i = 0; i < N; i++) {
        p[i] = i;
        rank[i] = 0;
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
        if (rank[x] > rank[y]) 
          p[y] = x;
        else { 
          p[x] = y;
          if (rank[x] == rank[y]) 
            rank[y] = rank[y]+1; 
        } 
      } 
    }
  }
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    int c = io.getInt();
    int count;
    boolean order = true;
    UnionFind u = new UnionFind(n);
    for (int i = 0; i < c; i++) {
      int t1 = io.getInt()-1;
      int t2 = io.getInt()-1;
      u.unionSet(t1, t2);
    }
    if (n%2 != 0) {
      count = n/2;
    } else {
      count = n/2 + 1;
    }
    for (int i = 0; i < count; i++) {
      if (!u.isSameSet(i, n-1-i)) {
        order = false;
        break;
      }
    }
    if (order)
      io.println("Yes");
    else
      io.println("No");
    io.close();
  }
}
