import java.util.ArrayList;

class WeakVertices {
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int V = io.getInt();
    while (V != -1) {
      int[][] AdjMatrix= new int[V][V];
      ArrayList<ArrayList<Integer>> AdjList= new ArrayList<ArrayList<Integer>>(V);
      for (int i = 0; i < V; i++) {
        AdjList.add(new ArrayList<>());
        for (int j = 0; j < V; j++) {
          ArrayList<Integer> temp = AdjList.get(i);
          int num = io.getInt();
          AdjMatrix[i][j] = num;
          if (num != 0) {
            temp.add(j);
          }
        }
      }
      for (int i = 0; i < V; i++) {
        ArrayList<Integer> temp = AdjList.get(i);
        boolean weak = true;
        if (temp.size() >= 2) {
          for (int j = 0; j < temp.size() - 1; j++) {
            for (int k = j + 1; k < temp.size(); k++) {
              if (AdjMatrix[temp.get(j)][temp.get(k)] == 1) {
                weak = false;
                break;
              }
            }
          }
        }
        if (weak)
          io.print(i + " ");
      }
      V = io.getInt();
      io.println();
    }
    io.close();
  }
}