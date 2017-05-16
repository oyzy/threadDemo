package thread.threadLock;

import org.apache.log4j.Logger;

/** 
 * @ClassName: ThreadLock 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author oyzy
 * @date 2017年5月16日 下午2:48:25 
 */
public class ThreadLock {

	// 拿来加锁的对象
	private static final Object WAIT_OBJECT = new Object();

	private static Logger logger = Logger.getLogger(ThreadLock.class);

	public static void main(String[] args) throws Exception {
		Thread threadA = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (ThreadLock.WAIT_OBJECT) {
					logger.info("做了一些事情");
				}

			}
		});
		Thread threadB = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (ThreadLock.WAIT_OBJECT) {
					logger.info("做了另外一些事情");
				}

			}
		});
		threadA.start();
		threadB.start();
	}
}
