package test;
import java.util.Hashtable;
 
public class ProgressSingleton {
  //为了防止多用户并发，使用线程安全的Hashtable
  private static Hashtable<Object, Object> table = new Hashtable<>();
  private static boolean flag = true;
  public synchronized static void put(Object key, Object value){
	table.put(key, value);
    try {
		Thread.sleep(200);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
   
  public synchronized static Object get(Object key){
    try {
		Thread.sleep(200);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return table.get(key);
  }
   
  public static Object remove(Object key){
	
    return table.remove(key);
  }
}