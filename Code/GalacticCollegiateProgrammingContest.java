import java.lang.Math;
import java.util.HashMap;

class GalacticCollegiateProgrammingContest {

  public static HashMap<Integer, Pair> map = new HashMap<>(); // stores all teams and scores

  public static class Pair{ //stores scores
    public int wins;
    public long penalty;

    public Pair (int w, long p) {
      wins = w;
      penalty = p;
    }

    public long compareTo(Pair p) {
      if (this.wins !=  p.wins) {
        return this.wins - p.wins;
      }
      return p.penalty - this.penalty;
    }

    public String toString() {
      return "wins: " + wins + " penalty: "+ penalty;
    }
  }

  public static class BSTVertex {
    BSTVertex(int v, Pair p) { 
      key = v; 
      parent = left = right = null; 
      height = 0; 
      score = p; 
      size = 1;
      map.put(v, p);}
    public BSTVertex parent, left, right;
    public int key; // team number
    public Pair score;
    public int height; 
    public int size; // rank of team

    public int getLeftSize() {
      if (left != null) {
        return left.size;
      }
      return 0;
    }
    public int getLeftHeight() {
      if (left != null) {
        return left.height;
      }
      return -1;
    }
    public int getRightSize() {
      if (right != null) {
        return right.size;
      }
      return 0;
    }
    public int getRightHeight() {
      if (right != null) {
        return right.height;
      }
      return -1;
    }

    public int getLeftbf() {
      if (left != null) {
        return left.bf();
      }
      return 0;
    }

    public int getRightbf() {
      if (right != null) {
        return right.bf();
      }
      return 0;
    }

    public int bf() {
      return getLeftHeight() - getRightHeight();
    }
  }

  public static class BST {
    public BSTVertex root;

    public BST() { root = null; }

    public BSTVertex rotateLeft(BSTVertex T) { // pre-req: T.right!= null
    if (T.right == null) {
      return T;
    }
    BSTVertex w = T.right;
    w.parent= T.parent;
    T.parent= w;
    T.right= w.left;
    if (w.left!= null) 
      w.left.parent= T;
    w.left= T;
    T.height = Math.max(T.getLeftHeight(), T.getRightHeight()) + 1;
    T.size = T.getLeftSize() + T.getRightSize() + 1; // Update the height of T and then w
    w.height = Math.max(w.getLeftHeight(), w.getRightHeight()) + 1;
    w.size = w.getLeftSize() + w.getRightSize() + 1;
    return w;
    }

    public BSTVertex rotateRight(BSTVertex T) { // pre-req: T.right!= null
      if (T.left == null) {
        return T;
      }
      BSTVertex w = T.left;
      w.parent= T.parent;
      T.parent= w;
      T.left= w.right;
      if (w.right!= null) 
        w.right.parent= T;
      w.right= T;
      T.height = Math.max(T.getLeftHeight(), T.getRightHeight()) + 1;
      T.size = T.getLeftSize() + T.getRightSize() + 1; // Update the height of T and then w
      w.height = Math.max(w.getLeftHeight(), w.getRightHeight()) + 1;
      w.size = w.getLeftSize() + w.getRightSize() + 1;
      return w;
      }

    public BSTVertex rotate(BSTVertex T) {
      if (T.bf() == 2 && 0 <= T.getLeftbf() && T.getLeftbf() <= 1) {
        T = rotateRight(T);
      } else if (T.bf() == 2 && T.getLeftbf() == -1) {
        T.left = rotateLeft(T.left);
        T = rotateRight(T);
      } else if (T.bf() == -2 && T.getRightbf() == 1) {
        T.right = rotateRight(T.right);
        T = rotateLeft(T);
      } else if (T.bf() == -2 && T.getRightbf() <= 0 && -1 <= T.getRightbf()) {
        T = rotateLeft(T);
      }
      return T;
    }

    //get rank of team 1
    public int rank() {
      int r = 1;
      Pair p = map.get(1);
      BSTVertex curr = root;
      while(curr != null) {
        if (p.compareTo(curr.score) < 0) {
          curr = curr.left;
        } else if (p.compareTo(curr.score) > 0) {
          r += 1 + curr.getLeftSize();
          curr = curr.right;
        } else if (curr.key > 1){
          r += 1 + curr.getLeftSize();
          curr = curr.right;
        } else {
            return r + curr.getLeftSize();
        }
      }
      return -1;
    }

    // helper method to perform search
    public BSTVertex search(BSTVertex T, int v, Pair p) { //input key, score
          if (T == null)  return null;                     // not found
      else if (T.key == v) return T;                        // found
      else if (T.score.compareTo(p) < 0)  return search(T.right, v, p);       // search to the right
      else return search(T.left, v, p);        // search to the left
    }
    
    // public method called to find Minimum key value in BST
    public BSTVertex findMin() { return findMin(root); }

    // helper method to perform findMin
    // Question: What happens if BST is empty?
    public BSTVertex findMin(BSTVertex T) {
      if (T.left == null) return T;                    // this is the min
      else                return findMin(T.left);           // go to the left
    }

    // public method called to find Maximum key value in BST
    public int findMax() { return findMax(root); }

    // helper method to perform findMax
    // Question: Again, what happens if BST is empty?
    public int findMax(BSTVertex T) {
      if (T.right == null) return T.key;                   // this is the max
      else                 return findMax(T.right);        // go to the right
    }

  // helper recursive method to find successor to for a given vertex T in BST
  public BSTVertex successor(BSTVertex T) {
    if (T.right != null)                       // this subtree has right subtree
      return findMin(T.right);  // the successor is the minimum of right subtree
    else {
      BSTVertex par = T.parent;
      BSTVertex cur = T;
      // if par(ent) is not root and cur(rent) is its right children
      while ((par != null) && (cur == par.right)) {
        cur = par;                                         // continue moving up
        par = cur.parent;
      }
      return par;           // this is the successor of T
    }
  }

    // public method called to perform inorder traversal
    public void inorder() { 
      inorder(root);
      System.out.println();
    }

    // helper method to perform inorder traversal
    public void inorder(BSTVertex T) {
      if (T == null) return;
      inorder(T.left);                               // recursively go to the left
      System.out.printf("Team: %d, Size: %d, Height: %d BF: %d| ", T.key, T.size, T.height, T.bf());                      // visit this BST node
      inorder(T.right);                             // recursively go to the right
    }

    // public method called to insert a new key with value v into BST
    public void insert(int v, Pair p) { 
      root = insert(root, v, p); 
    }

    // helper recursive method to perform insertion of new vertex into BST
    public BSTVertex insert(BSTVertex T, int v, Pair p) {
      if (T == null) {
        return new BSTVertex(v, p);          // insertion point is found
      }
      
      if (T.score.compareTo(p) < 0) {                                      // search to the right
        T.right = insert(T.right, v, p);
        T.right.parent = T;
      }
      else if (T.score.compareTo(p) > 0){                                                 // search to the left
        T.left = insert(T.left, v, p);
        T.left.parent = T;
      } else if (T.key > v) {
        T.right = insert(T.right, v, p);
        T.right.parent = T;
      } else {
        T.left = insert(T.left, v, p);
        T.left.parent = T;
      }
      T.height = Math.max(T.getLeftHeight(), T.getRightHeight()) + 1;
      T.size = T.getLeftSize() + T.getRightSize() + 1;
      return rotate(T);                                          // return the updated BST
    }  

    // public method to delete a vertex containing key with value v from BST
    public void delete(int v, Pair p) { root = delete(root, v, p); }

    // helper recursive method to perform deletion where
    public BSTVertex delete(BSTVertex T, int v, Pair p) {
      if (T == null) {
        return T;
      }              // cannot find the item to be deleted
      if (T.key == v) {                                            // this is the node to be deleted
        if (T.left == null && T.right == null)                   // this is a leaf
          T = null;                                      // simply erase this node
        else if (T.left == null && T.right != null) {   // only one child at right        
          T.right.parent = T.parent;
          T = T.right;                                                 // bypass T        
        }
        else if (T.left != null && T.right == null) {    // only one child at left        
          T.left.parent = T.parent;
          T = T.left;                                                  // bypass T        
        }
        else {                                 // has two children, find successor
          BSTVertex successorV = successor(T);
          T.key = successorV.key;         // replace this key with the successor's key
          T.score = successorV.score;
          map.put(T.key, T.score);
          T.right = delete(T.right, successorV.key, successorV.score);      // delete the old successorV
        }
      } else if (T.score.compareTo(p) < 0)                                    // search to the right
        T.right = delete(T.right, v, p);
        else if (T.score.compareTo(p) > 0)                            // search to the left
        T.left = delete(T.left, v, p);
        else if (T.key > v)
        T.right = delete(T.right, v, p);
        else
        T.left = delete(T.left, v, p);
      if (T != null) {
        T.height = Math.max(T.getLeftHeight(), T.getRightHeight()) + 1;
        T.size = T.getLeftSize() + T.getRightSize() + 1;
        return rotate(T);
      }
      return T;                                          // return the updated BST
    }
  }
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    int m = io.getInt();
    BST tree = new BST();
    for (int i = 0; i < m; i++) {
      int team = io.getInt();
      int penalty = io.getInt();
      if (!map.containsKey(team)) {
        tree.insert(team, new Pair(1, penalty));
      } else {
        Pair temp = map.get(team);
        Pair newp = new Pair(temp.wins + 1, temp.penalty + penalty);
        tree.delete(team, temp);
        tree.insert(team, newp);
      }
      if (map.containsKey(1)) {
        io.println(tree.root.size - tree.rank() + 1);
      } else {
        io.println(tree.root.size + 1);
      }
    }
    io.close();
  }
}