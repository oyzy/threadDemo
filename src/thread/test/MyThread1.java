package thread.test;

import org.apache.log4j.Logger;

/**
 * @ClassName: MyThread
 * @Description: 线程中的实例变量共享 （不安全）
 * @author oyzy
 * @date 2017年5月17日 下午3:27:30
 */
public class MyThread1 extends Thread {

	private int count = 5;
	private static Logger logger = Logger.getLogger(MyThread1.class);

	public MyThread1() {
	    super();
	}

	public MyThread1(String name) {
		super();
		this.setName(name);// 设置线程名称
	}

	@Override
	public void run() {
		super.run();
		count--;
		logger.info("由" + this.currentThread().getName() + "计算，count=" + count);
	}

}
