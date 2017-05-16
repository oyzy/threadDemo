package thread.interrupt;
/** 
 * @ClassName: InterruptProcessor 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author oyzy
 * @date 2017年5月16日 下午5:02:16 
 */
public class InterruptProcessor {

	public static void main(String[] args) {
		Thread threadOne = new Thread(new Runnable() {
			@Override
			public void run() {
				Thread currentThread = Thread.currentThread();
				// 并不是线程收到interrupt信号，就会立刻终止；
				// 线程需要检查自生状态是否正常，然后决定下一步怎么走。
				while (!currentThread.isInterrupted()) {
					System.out.println("threadOne 一直在运行！");

				}
				System.out.println("threadOne 正常结束！" + currentThread.isInterrupted());
			}
		});

		Thread threadTwo = new Thread(new Runnable() {

			@Override
			public void run() {
				Thread currentThread = Thread.currentThread();
				while (!currentThread.isInterrupted()) {
					synchronized (currentThread) {
						try {
							// 通过wait进入阻塞
							currentThread.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
							System.out.println("threadTwo 由于中断信号，异常结束" + currentThread.isInterrupted());
						}
					}

				}

			}
		});
		threadOne.start();
		threadTwo.start();
		// 您可以通过eclipse工具在这里打上端点，以保证threadOne和threadTwo完成了启动
		// 当然您还可以使用其他方式来确保这个事情
		System.out.println("两个线程正常运行，现在开始发出中断信号");
		threadOne.interrupt();
		threadTwo.interrupt();
	}
}
