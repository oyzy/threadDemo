package thread.pool;

import org.apache.log4j.Logger;

/**
 * @ClassName: TestRunnable
 * @Description: 这个就是测试用的线程
 * @author oyzy
 * @date 2017年5月16日 下午6:08:10
 */
public class TestRunnable implements Runnable {

	private static Logger logger = Logger.getLogger(TestRunnable.class);
	/**
	 * 记录任务的唯一编号，这样在日志中好做识别
	 */
	private Integer index;

	public TestRunnable(int index) {
		this.index = index;
	}

	/**
	 * @return the index
	 */
	public Integer getIndex() {
		return index;
	}

	@Override
	public void run() {
		/*
		 * 线程中，就只做一件事情： 等待60秒钟的事件，以便模拟业务操作过程
		 */
		Thread currentThread = Thread.currentThread();
		logger.info("线程：" + currentThread.getId() + " 中的任务（" + this.getIndex() + "）开始执行===");
		synchronized (currentThread) {
			try {
				currentThread.wait(60000);
			} catch (InterruptedException e) {
				logger.error(e.getMessage(), e);
			}
		}
		logger.info("线程：" + currentThread.getId() + " 中的任务（" + this.getIndex() + "）执行完成");
	}

}
