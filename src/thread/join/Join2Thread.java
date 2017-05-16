package thread.join;

import org.apache.log4j.Logger;

/** 
 * @ClassName: Join2Thread 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author oyzy
 * @date 2017年5月16日 下午5:30:27 
 */
public class Join2Thread implements Runnable {

	private static Logger logger = Logger.getLogger(Join2Thread.class);
	@Override
	public void run() {
		Thread currentThread = Thread.currentThread();
		long id = currentThread.getId();
		logger.info("线程" + id + "启动成功，准备进入等待状态（2秒）");
		// 使用sleep方法，模型这个线程执行业务代码的过程
		try {
			synchronized (Join2Thread.class) {
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("线程" + id + "执行完成！");
	}

	public static void main(String[] args) {
		Thread joinThread1 = new Thread(new Join2Thread());
		joinThread1.start();
		Thread joinThread2 = new Thread(new Join2Thread());
		joinThread2.start();
	}

}
