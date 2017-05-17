package thread.test.demo;
/** 
 * @ClassName: Test 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author oyzy
 * @date 2017年5月17日 下午4:24:48 
 */
public class Test {

    public static void main(String[] args) {
	ALogin aLogin = new ALogin();
	BLogin bLogin = new BLogin();
	aLogin.start();
	bLogin.start();
    }
}
