/**
 * isWrapClass判断基本类型与包装类
 * isJavaClass判断数据类型是Java本身定义类型还是用户自定义类型
 */
public class BugMeNot {

  /*基本类型与包装类判断*/
  /**
   * Java的所有类总称Class
   * 基本类型：
   * Java的基本类型有八种：int, double, float, long, short, boolean, byte, char， void.
   * 基本类型属于Class的一个子集。
   * 因此：
   * .isPrimitive()是用来判断是否是基本类型的：void.isPrimitive() //true;
   * .class用来返回该类的Class对象的实例：int.class == intclass //基本类型
                                     int.class.isPrimitive //true
                                     Integer.class == Integer //包装类
                                     Integer.class.isPrimitive //false
   * .TYPE是返回基本类型的Class实例,所以：int.class == Integer.TYPE //true;
   * 除了int Integer，类似的有 float Float; double Double; string String等。
   * 基本类存储在栈中，包装类村住在堆中，栈是LIFO（后进先出），基本类的存取速度更快。
   * JAVA 虚机自动完成基本类与包装类的转换
   * 基本类型的包装类都采用final修饰方法，因此无法继承它们扩展的新类，也无法重写它们的方法。
   * 包装类：
   * 包装类是基本类的扩展
   * int i=2， Integer i = new Integer(2); 其实这个过程是由自动转换的，定义了int i=2就不用关心将其转换为包装类的过程。这就是为什么基本类型不需要new，例如 int i = new int() i =2;是多余的。
   * 此外，HashMap ArrayList等不能将基本类加入其中，而只能加入包装类。一个典型的实例：
   * Map<int, Object> testMap = new HashMap<int, Object>();就是错误的
   * 而应该把int换成Integer。

   * 最后，如何判断一个对象所属的类型：
   * 常见的一个典型错误是 object.getClass.isPrimitive()
   * 许多人指望靠此判断object是不是一个数字或者布尔。其实这样返回的是该对象的类型，如java.lang.double，而非类型的基本类型，因此是错误的。

   * 正确的步骤是：

   * object instanceof String
   * Number
   * Boolean
   * Character
   * null
   * 搞懂java的基本类型就不在会为判断对象而发愁。
   */
  /*判断一个类是包装类*/
  public static boolean isWrapClass(Class<?> clz) {
    try {
      return ((Class<?>)clz.getField("TYPE").get(null)).isPrimitive();
    } catch(Exception e) {
      return false;
    }
  }

  /*判断一个类型是Java本身的类型，还是用户自定义的类型*/
  public static boolean isJavaClass(Class<?> clz) {
    return clz != null && clz.getClassLoader() == null;
  }

  public static void main(String... args) {
    System.out.println((char)65);  //A
    System.out.println(int.class.isPrimitive());  //true
    System.out.println(isWrapClass(int.class));  //false
    System.out.println(isWrapClass(long.class));  //false
    System.out.println(isWrapClass(Long.class));  //true
    System.out.println(isWrapClass(Integer.class));  //true
    System.out.println(isWrapClass(Double.class));  //true
    System.out.println(isWrapClass(String.class));   //false
    System.out.println(isWrapClass(BugMeNot.class));  //false

    System.out.println(isJavaClass(Integer.class)); //true
    System.out.println(isJavaClass(BugMeNot.class)); //false
  }
}
