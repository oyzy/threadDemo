package thread.join;

import org.apache.log4j.Logger;

/** 
 * @ClassName: JoinThread 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author oyzy
 * @date 2017年5月16日 下午5:18:52 
 */
public class JoinThread implements Runnable {

	private static Logger logger = Logger.getLogger(JoinThread.class);
	@Override
	public void run() {
		Thread currentThread = Thread.currentThread();
		long id = currentThread.getId();
		logger.info("线程" + id + "启动成功，准备进入等待状态（5秒）");
		// 使用sleep方法，模仿这个线程执行业务代码的过程
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("线程" + id + "执行完成！");
	}

	public static void main(String[] args) {
		/*
		 * 启动一个子线程joinThread，然后等待子线程joinThread运行完成后 这个线程再继续运行
		 */
		Thread currentThread = Thread.currentThread();
		long id = currentThread.getId();
		Thread joinThread = new Thread(new JoinThread());
		joinThread.start();
		try {
			// 等待，知道joinThread执行完成后，main线程才继续执行
			joinThread.join();
			logger.info("线程" + id + "继续执行！");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
