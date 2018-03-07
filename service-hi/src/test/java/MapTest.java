import org.junit.Test;
import org.springframework.util.StopWatch;

import com.hongxp.util.ArrayList;

import java.util.*;


public class MapTest {
    @Test
    public void hashTableTest() {
        /*Hashtable<String, String> table = new Hashtable<>();
        table.put(null, "a");
        table.put("a", null);*/
        HashMap<String, String> map = new HashMap<>();
        map.put("", null);
        map.put(null, null);
    }

    public static class Father {

    }

    public static class Son extends Father {

    }

    @Test
    public void test6260652() {
        /**
         Son[] sons = new Son[]{new Son(), new Son()};
         System.err.println(sons.getClass());

         Father[] fathers = sons;
         System.err.println(fathers.getClass());

         //fathers[0] = new Father(); throw ArrayStoreException
         System.err.println(fathers.getClass().getComponentType());
         List<String> ss = new ArrayList<>();
         ss.add("ss");
         Object[] objects = ss.toArray();
         System.err.println(objects);

         Father[] fs = new Father[]{new Son(), new Father()};
         Class<?> componentType = fs.getClass().getComponentType();
         System.err.println(componentType);


         List<Object> ff = new ArrayList<>();
         ff.add(new Father());
         ff.add(new Son());
         System.err.println(ff);

         List sss = new ArrayList(ff);
         System.err.println(sss);
         **/
        List list = new ArrayList<>(Arrays.asList(new Object()));
        System.out.println(list.getClass());//class java.util.ArrayList
        Object[] listArray = list.toArray();
        System.out.println(listArray.getClass());//class [Ljava.lang.Object;
        listArray[0] = new Object();


        List<String> asList = Arrays.asList("asList");
        System.out.println(asList.getClass());//class java.util.Arrays$ArrayList
        Object[] asListArray = asList.toArray();//java.util.Arrays$ArrayList.a.clone
        System.out.println(asListArray.getClass());//class [Ljava.lang.String;
        asListArray[0] = new Object();//! java.lang.ArrayStoreException


        String[] strings = {new String()};
        Object[] oo = strings;
        oo[0] = new Object();//! java.lang.ArrayStoreException

    }

    @Test
    public void testArray() {
        int[] ids = {1, 2, 3, 4, 5};
        int[] ids_copy = new int[5];
        System.arraycopy(ids, 0, ids_copy, 0, ids.length);
        System.err.println(Arrays.toString(ids_copy));

        Object[] o1 = {1, 2, 3, 4.5, 6.7};
        Integer[] o2 = new Integer[5];
        try {
            System.arraycopy(o1, 0, o2, 0, 5);
        } catch (Exception e) {
            // 发生存储转换，部分成功的数据会被复制过去
            System.err.println("拷贝发生异常：数据转换错误，无法存储。");
        }

        System.err.println(Arrays.toString(o2));
    }

    @Test
    public void arrayOrLinked() {
        List<Integer> array = new ArrayList<>(20);
        List<Integer> linked = new LinkedList<>();
        //首先分别给两者插入10000条数据
        for (int i = 0; i < 10000; i++) {
            array.add(i);
            linked.add(i);
        }

        randomSearch(array);
        randomSearch(linked);

        //获得两者插入数据的时间
        System.out.println("array insert time:" + insertTime(array));
        System.out.println("linked insert time:" + insertTime(linked));
    }

    public void randomSearch(List<Integer> list) {
        StopWatch watch = new StopWatch();
        watch.start();
        for (int i = 0; i < list.size(); i++) {
            int index = Collections.binarySearch(list, list.get(i));
            if (index != i) {
                System.out.println("ERROR!");
            }
        }
        watch.stop();
        System.err.println("Time:" + watch.getTotalTimeSeconds());
    }

    //插入数据
    public static double insertTime(List<Integer> list) {
        /*
         * 插入的数据量和插入的位置是决定两者性能的主要方面，
         * 我们可以通过修改这两个数据，来测试两者的性能
         */
        long num = 10000; //表示要插入的数据量
        int index = 9000; //表示从哪个位置插入
        StopWatch watch = new StopWatch();
        watch.start();
        for (int i = 1; i < num; i++) {
            list.add(index, i);
        }
        watch.stop();
        return watch.getTotalTimeSeconds();

    }
}
