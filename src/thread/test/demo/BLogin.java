package thread.test.demo;
/** 
 * @ClassName: BLogin 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author oyzy
 * @date 2017年5月17日 下午4:24:40 
 */
public class BLogin extends Thread{

    @Override
    public void run() {
	//LoginServlet.doPost("bb", "b123456");//线程不安全
	LoginServlet2.doPost("bb", "b123456");//线程安全
    }

}
