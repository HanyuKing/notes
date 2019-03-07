package jvm;

/**
 * VM args: -Xss100m(根据具体情况可以设置大一点，更容易验证)
 * 注意：本人只在32位JVM上运行得到了预期结果
 *
 * @author xinwe注意：本人只在32位JVM上运行得到了预期结果
 */
public class StackOutOfMemoryErrorDemo implements Runnable {
	static int depth = 0;

	public void foo() throws InterruptedException {
		depth++;
		Thread.sleep(1000);
		foo();
	}

	public static void main(String[] args) throws Throwable {
		StackOutOfMemoryErrorDemo oomed = new StackOutOfMemoryErrorDemo();
		try {
			while (true) {
				new Thread(oomed).start();
			}
		} catch (Throwable e) {
			System.out.println("depth:" + depth);
			throw e;
		}
	}

	public void run() {
		try {
			foo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
