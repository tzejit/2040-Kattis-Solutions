class AbInitio {

  public static long mod = 1000000007;

  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    int e = io.getInt();
    int q = io.getInt();
    int size = n;
    int[][] adjmat = new int[4000][4000];
    boolean transpose = false;
    boolean complement = false;
    for (int i = 0; i < e; i++) {
      adjmat[io.getInt()][io.getInt()] = 1;
    }
    for (int i = 0; i < q; i++) {
      int num = io.getInt();
      switch(num) {
        case 1: 
          if (complement) {
            for (int j = 0; j < size; j++) {
              adjmat[j][size] = 1;
              adjmat[size][j] = 1;
            }
          }
          size++;
          break;
        case 2:
          int i1 = io.getInt();
          int i2 = io.getInt();
          if (transpose) {
            if (complement)
              adjmat[i2][i1] = 0;
            else
              adjmat[i2][i1] = 1;
          } else {
            if (complement)
              adjmat[i1][i2] = 0;
            else
              adjmat[i1][i2] = 1;
          } 
          break;
        case 3:
          int i3 = io.getInt(); 
          if (!complement) {
            for (int j = 0; j < size; j++) {
              adjmat[j][i3] = 0;
              adjmat[i3][j] = 0;
            }
          } else {
            for (int j = 0; j < size; j++) {
              adjmat[j][i3] = 1;
              adjmat[i3][j] = 1;
            }
          }
          break;
        case 4: 
          int i4 = io.getInt();
          int i5 = io.getInt();
          if (transpose) {
            if (complement)
              adjmat[i5][i4] = 1;
            else
              adjmat[i5][i4] = 0;
          } else {
            if (complement)
              adjmat[i4][i5] = 1;
            else
              adjmat[i4][i5] = 0;
          }
          break;
        case 5: 
          if (transpose) {
            transpose = false;
          } else 
            transpose = true;
          break;
        case 6: 
          if (complement) {
            complement = false;
          } else 
            complement = true;
          break;
      }
    }
    io.println(size);
    if (!complement && !transpose) {
      for (int i = 0; i < size; i++) {
        int count = 0;
        long h = 0;
        long multiply = 1;
        for (int j = 0; j < size; j++) {
          if (adjmat[i][j] == 1 && i != j) {
            h = (h + multiply * j) % mod;
            multiply = (multiply * 7) % mod;
            count++;
          }
        }
        io.println(count + " " + h);
      }  
    } else if (complement && !transpose) {
      for (int i = 0; i < size; i++) {
        int count = 0;
        long h = 0;
        long multiply = 1;
        for (int j = 0; j < size; j++) {
          if (adjmat[i][j] == 0 && i != j) {
            h = (h + multiply * j) % mod;
            multiply = (multiply * 7) % mod;
            count++;
          }
        }
        io.println(count + " " + h);
      }
    } else if (!complement && transpose) {
      for (int i = 0; i < size; i++) {
        int count = 0;
        long h = 0;
        long multiply = 1;
        for (int j = 0; j < size; j++) {
          if (adjmat[j][i] == 1 && i != j) {
            h = (h + multiply * j) % mod;
            multiply = (multiply * 7) % mod;
            count++;
          } 
        }
        io.println(count + " " + h);
      }
     } else {
      for (int i = 0; i < size; i++) {
        int count = 0;
        long h = 0;
        long multiply = 1;
        for (int j = 0; j < size; j++) {
          if (adjmat[j][i] == 0 && i != j) {
            h = (h + multiply * j) % mod;
            multiply = (multiply * 7) % mod;
            count++;
          }
        }
        io.println(count + " " + h);
      }
    }
    io.close();
  }
}