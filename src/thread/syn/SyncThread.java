package thread.syn;

import org.apache.log4j.Logger;

/** 
 * @ClassName: SyncThread 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author oyzy
 * @date 2017年5月16日 下午3:06:39 
 */
public class SyncThread implements Runnable {

	public SyncThread(int value) {
		this.value = value;
	}

	private Integer value;

	private static Integer NOWVALUE;

	private static Logger logger = Logger.getLogger(SyncThread.class);
	/**
	 * 对这个类的实例化对象进行检查
	 */

	/*
	 * private synchronized void doOtherthing() { NOWVALUE = this.value;
	 * System.out.println("当前NOWVALUE的值：" + NOWVALUE);
	 * }//此方法加synchronized后并不安全，会出现数据脏读 （对类的多个实例对象进行同步检查，那么应该对这个类的class对象进行同步检查）
	 */


	private void doOtherthing() {
		synchronized (SyncThread.class) {
			NOWVALUE = this.value;
			logger.info("当前NOWVALUE的值：" + NOWVALUE);
		}
	}

	@Override
	public void run() {
		Thread currenThread = Thread.currentThread();
		long id = currenThread.getId();
		this.doOtherthing();
	}

	public static void main(String[] args) {
		Thread syncThread1 = new Thread(new SyncThread(10));
		Thread syncThread2 = new Thread(new SyncThread(100));
		syncThread1.start();
		syncThread2.start();
	}
}
