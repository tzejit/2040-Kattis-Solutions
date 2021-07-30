import java.util.Arrays;

class Ladice {

  public static class Pair{
    int num; //total number of pairs in tree
    int value; //original number
    int filled = 0;
    public Pair(int j, int i){
      num = i;
      value = j;
    }

    public String toString() {
      return "NVF:" + num + " " + value + " " + filled;
    }
  }

  public static class UnionFind {                                              
    public Pair[] p;
    public int[] rank;

    public UnionFind(int N) {
      p = new Pair[N];
      rank = new int[N];
      for (int i = 0; i < N; i++) {
        p[i] = new Pair(i, 1);
        rank[i] = 0;
      }
    }
  
    public Pair findSet(int i) { 
      if (p[i].value == i) return p[i];
      else {
        p[i] = findSet(p[i].value);
        return p[i]; 
      } 
    }
  
    public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }
  
    public void unionSet(int i, int j) { 
      if (!isSameSet(i, j)) {
        Pair x = findSet(i), y = findSet(j);
        // rank is used to keep the tree short
        if (rank[x.value] > rank[y.value]) {
          p[y.value].value = x.value;
          x.num += y.num;
          x.filled += y.filled;
        } else { 
          p[x.value].value = y.value;
          y.num += x.num;
          y.filled += x.filled;
          if (rank[x.value] == rank[y.value]) 
            rank[y.value] = rank[y.value]+1; 
        } 
      } 
    }
  }
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    int l = io.getInt();
    UnionFind u = new UnionFind(l);
    for (int i = 0; i < n; i++) {
      //io.println(Arrays.toString(u.p));
      int one = io.getInt() - 1;
      int two = io.getInt() - 1;
      Pair x = u.findSet(one); 
      Pair y = u.findSet(two);
      if (x.filled < x.num) {
        x.filled++;
        u.unionSet(one, two);
        io.println("LADICA");
      } else if (y.filled < y.num) {
        y.filled++;
        u.unionSet(one, two);
        io.println("LADICA");
      } else {
        io.println("SMECE");
      }
    }
    io.close();
  }
}