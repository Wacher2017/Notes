/**
 * 关于List的一些常用方法封装
 *  · getIds:找出两个数组中相同的元素
 *  · compare:找出两个数组中不相同的元素
 */
public class ListUtils {

  /**
   * 找出两个数组中相同的元素
   */
  public static Set<Integer> getIds(Integer[] a, Integer[] b){
      Set<Integer> same = new HashSet<Integer>();  //用来存放两个数组中相同的元素
      Set<Integer> temp = new HashSet<Integer>();  //用来存放数组a中的元素
      for (int i = 0; i < a.length; i++) {
          temp.add(a[i]);   //把数组a中的元素放到Set中，可以去除重复的元素
      }
      for (int j = 0; j < b.length; j++) {
        //把数组b中的元素添加到temp中
        //如果temp中已存在相同的元素，则temp.add（b[j]）返回false
        if(!temp.add(b[j]))
            same.add(b[j]);
    }
    return same;
  }

  /**
   * 找出两个数组中不相同的元素
   */
  public static <T> List<T> compare(T[] t1, T[] t2) {
      List<T> list1 = Arrays.asList(t1);
      List<T> list2 = new ArrayList<T>();
      for (T t : t2) {
          if (!list1.contains(t)) {
              list2.add(t);
          }
      }
      return list2;
  }

  public static void main(String[] arg){
        //test getIds
        Integer[] array1 = {1,2,3,4,1,2,4,6,7,8,10,22,33};
        Integer[] array2 = {1,2,3,4,1,2,4,6,7,8,10,22,33,55,66,77,88,99};
        Set<Integer> sameElementSet = getIds(array1,array2);
        for(Integer i : sameElementSet) {
          System.out.println(i);
        }

        //test compare
        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {1, 2, 3, 4,44};
        List<Integer> list = compare(array1,array2);
        for (Integer integer : list) {
            System.out.println(integer);
        }
  }

}
