import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class Islands {
  public static class Pair {
    int i;
    int j;
    public Pair(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int r = io.getInt();
    int c = io.getInt();
    int[][] temp = new int[r][c];
    HashMap<Integer, Boolean> map = new HashMap<>();
    int count = 0;
    LinkedList<Integer> queue = new LinkedList<>();
    LinkedList<Pair> landqueue = new LinkedList<>();
    HashMap< Integer, ArrayList< Integer> > AdjList= new HashMap< Integer, ArrayList< Integer> >();
    HashSet<Integer> land = new HashSet<>();
    for (int i = 0; i < r; i++) {
      char[] row = io.getWord().toCharArray();
      for (int j = 0; j < c; j++) {
        if (row[j] == 'L') {
          temp[i][j] = 1;
          land.add(i *c + j);
          landqueue.offer(new Pair(i,j));
        } else if (row[j] == 'W') {
          temp[i][j] = 0;
        } else {
          temp[i][j] = -1;
        }
      }
    }
    while (!landqueue.isEmpty()) {
      Pair a = landqueue.poll();
      int i = a.i;
      int j = a.j;
      if (i - 1 >= 0 && temp[i-1][j] == -1) {
        temp[i-1][j] = 1;
        if (!land.contains((i-1) *c + j)) {
          land.add((i-1) *c + j);
          landqueue.offer(new Pair(i - 1, j));
        }
      }
      if (i + 1 <= r - 1 && temp[i+1][j] == -1) {
        temp[i+1][j] = 1;
        if (!land.contains((i+1) *c + j)) {
          land.add((i+1) *c + j);
          landqueue.offer(new Pair(i + 1, j));
        }
      }
      if (j + 1 <= c - 1 && temp[i][j+1] == -1) {
        temp[i][j+1] = 1;
        if (!land.contains((i) *c + j+1)) {
          land.add((i) *c + j+1);
          landqueue.offer(new Pair(i, j+1));
        }
      }
      if (j - 1 >= 0 && temp[i][j-1] == -1) {
        if (!land.contains((i) *c + j-1)) {
          land.add((i) *c + j-1);
          landqueue.offer(new Pair(i, j-1));
        }
      }
    }
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (temp[i][j] == 1) {
          ArrayList<Integer> arr = new ArrayList<>();
          if (i - 1 >= 0 && temp[i-1][j] == 1) {
            arr.add((i-1)*c + j);
          }
          if (i + 1 <= r - 1 && temp[i+1][j] == 1) {
            arr.add((i+1)*c + j);
          }
          if (j + 1 <= c - 1 && temp[i][j+1] == 1) {
            arr.add((i)*c + j + 1);
          }
          if (j - 1 >= 0 && temp[i][j-1] == 1) {
            arr.add((i)*c + j - 1);
          }
          map.put(i *c + j, false);
          AdjList.put(i *c + j, arr);
        }
      }
    }
    for (int i : map.keySet()) {
      if (!map.get(i)) {
        count++;
        queue.offer(i);
        map.put(i, true);
        while (!queue.isEmpty()) {
          int u = queue.poll();
          for (int j : AdjList.get(u)) {
            if (!map.get(j)) { 
              map.put(j,true);
              queue.offer(j);
            }
          }
        }
      }
    }
    io.println(count);
    io.close();
  }
}