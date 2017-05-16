package thread.notify;

import org.apache.log4j.Logger;

/** 
 * @ClassName: ChildNotifyThread 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author oyzy
 * @date 2017年5月16日 下午3:39:15 
 */
public class ChildNotifyThread implements Runnable {

	private static Logger logger = Logger.getLogger(ChildNotifyThread.class);
	@Override
	public void run() {
		Thread currentThread = Thread.currentThread();
		long id = currentThread.getId();
		logger.info("线程" + id + "启动成功，准备进入等待状态");
		synchronized (ParentNotifyThread.WAIT_OBJECT) {
			try {
				ParentNotifyThread.WAIT_OBJECT.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		logger.info("线程" + id + "被唤醒");
	}

}
