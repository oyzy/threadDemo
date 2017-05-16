package thread.pool;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/** 
 * @ClassName: PoolThreadSimple 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author oyzy
 * @date 2017年5月16日 下午6:03:18 
 */
public class PoolThreadSimple {

	public static void main(String[] args) throws Exception {
		/*
		 * corePoolSize：核心大小，线程池初始化的时候，就会有这么大 maximumPoolSize：线程池最大线程数
		 * keepAliveTime：如果当前线程池中线程数大于corePoolSize。
		 * 多余的线程，在等待keepAliveTime时间后如果还没有新的线程任务指派给它，它就会被回收
		 * 
		 * unit：等待时间keepAliveTime的单位
		 * 
		 * workQueue：等待队列。这个对象的设置是本文将重点介绍的内容
		 */
		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 1, TimeUnit.MINUTES,
				new SynchronousQueue<Runnable>());
		for (int i = 0; i < 10; i++) {
			poolExecutor.submit(new TestRunnable(i));
		}
		// 没有特殊含义，只是为了保证main线程不会退出
		synchronized (poolExecutor) {
			poolExecutor.wait();
		}
	}
}
