package thread.test.demo;
/** 
 * @ClassName: LoginServlet 
 * @Description: 线程不安全
 * @author oyzy
 * @date 2017年5月17日 下午4:14:39 
 */
public class LoginServlet {

    private static String userNameRef;
    private static String passwordRef;
    
    public static void doPost(String userName, String password) {
	 try {
	userNameRef = userName;
	if (userName.equals("a")) {
	    Thread.sleep(5000);
	} 
	passwordRef = password;
	System.out.println("userName="+userNameRef+" password="+passwordRef);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	
	}
	
    }
}
