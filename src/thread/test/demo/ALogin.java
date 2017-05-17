package thread.test.demo;
/** 
 * @ClassName: ALogin 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author oyzy
 * @date 2017年5月17日 下午4:24:28 
 */
public class ALogin extends Thread{

    @Override
    public void run() {
	//LoginServlet.doPost("aa", "a123456");//线程不安全
	LoginServlet2.doPost("aa", "a123456");//线程安全
    }

    
}
