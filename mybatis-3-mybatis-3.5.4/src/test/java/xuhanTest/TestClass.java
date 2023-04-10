package xuhanTest;

/**
 * @author XuHan
 * @date 2023/4/9 15:49
 */
public class TestClass {
  public static void main(String[] args) {
    System.out.println("hhh");

    System.out.println(TestClass.class.getClassLoader());
    System.out.println(TestClass.class.getClassLoader().getParent());

    System.out.println(String.class.getClassLoader());

    //测试一下系统的classLoader
    System.out.println(ClassLoader.getSystemClassLoader());
  }
}
