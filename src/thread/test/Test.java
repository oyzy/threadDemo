package thread.test;
/** 
 * @ClassName: Test 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author oyzy
 * @date 2017年5月17日 下午3:33:01 
 */
public class Test {

	public static void main(String[] args) {

	
	/*MyThread a = new MyThread("A");
	MyThread b = new MyThread("B");
	MyThread c = new MyThread("C");
	a.start();
	b.start();
	c.start();*/
	  

	/*MyThread1 myThread = new MyThread1();
	Thread a = new Thread(myThread,"A");
	Thread b = new Thread(myThread,"B");
	Thread c = new Thread(myThread,"C");
	Thread e = new Thread(myThread,"E");
	Thread f = new Thread(myThread,"F");
	a.start();
	b.start();
	c.start();
	e.start();
	f.start();*/

	    MyThread2 myThread = new MyThread2();
		Thread a = new Thread(myThread,"A");
		Thread b = new Thread(myThread,"B");
		Thread c = new Thread(myThread,"C");
		Thread e = new Thread(myThread,"E");
		Thread f = new Thread(myThread,"F");
		a.start();
		b.start();
		c.start();
		e.start();
		f.start();
	}
}
