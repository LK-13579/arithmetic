package other.plan;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/9/18 14:32
 * @description
 */
public class CountMoney {

  public static void main(String[] args) {
    double db = 100000.0;
    for (int i = 1; i <= 12; i++) {
      db = db * 0.03 + db;
      String format = String.format("%.5f", db);
      System.out.println(format);
    }
//    System.out.println(db);
  }


}
