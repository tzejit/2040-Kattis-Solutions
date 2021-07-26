import java.util.Arrays;

public class FroshWeek {
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int task = io.getInt();
    int interval = io.getInt();
    int[] taskArr = new int[task];
    int[] intArr = new int[interval];
    for (int i = 0; i < task; i++) {
      taskArr[i] = io.getInt();
    }
    for (int i = 0; i < interval; i++) {
      intArr[i] = io.getInt();
    }
    Arrays.sort(taskArr);
    Arrays.sort(intArr);
    int tot = 0;
    int taskIndex = taskArr.length - 1;
    int arrayIndex = intArr.length - 1;
    for (int j = arrayIndex; j >= 0;) {
      int itv = intArr[j];
      if (itv >= taskArr[taskIndex]) {
          tot++;
          j--;
      }
      taskIndex--;
      if (taskIndex < 0 ) {
        break;
      }
    }
    io.println(tot);
    io.close();
  }
}
