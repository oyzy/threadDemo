package thread.test;

import org.apache.log4j.Logger;

/**
 * @ClassName: MyThread
 * @Description: 线程中的实例变量不共享
 * @author oyzy
 * @date 2017年5月17日 下午3:27:30
 */
public class MyThread extends Thread {

	private int count = 5;
	private static Logger logger = Logger.getLogger(MyThread.class);

	public MyThread(String name) {
		super();
		this.setName(name);// 设置线程名称
	}

	@Override
	public void run() {
		super.run();

		while (count > 0) {
			count--;
			logger.info("由" + this.currentThread().getName() + "计算，count=" + count);
		}

	}

}
