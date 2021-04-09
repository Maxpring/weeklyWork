import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author: zhangyk
 * @Date: 2021/4/7 16:57
 * @Description:
 * @Version: 1.0
 */
public class demo {
    static class MyHashMap<K, V> extends HashMap<K, V> {
        @Override
        public String toString() {
            return "OHHHHHHHHHHH";
        }


    }

    static class MyException extends RuntimeException {
        public MyException() {
        }

        public MyException(String message) {
            super(message);
        }
    }
    public static void main(String[] args) {
        HashMap<Object, Object> map = new MyHashMap<>();
        map.put(1, "a");
        System.out.println(map.get(1));
        map.put(1, "b");
        System.out.println(map.get(1));
        map.put(2, "c");
        map.put(3, "d");
        System.out.println(map.values());
        System.out.println(map.entrySet());
        System.out.println(map);

        throw new MyException("my exception");

    }
}
