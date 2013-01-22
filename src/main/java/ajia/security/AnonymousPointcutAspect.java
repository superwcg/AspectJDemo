package ajia.security;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import ajia.messaging.MessageCommunicator;

/**
 * 使用匿名PointCut
 * @author spark
 *
 */
@Aspect
public class AnonymousPointcutAspect {

    private Authenticator authenticator = new Authenticator();

    @Before("call (* ajia..*Communicator.deliver(..)) && target(communicator) && args(msg0,..)")
    public void abcBefore(MessageCommunicator communicator, String msg0) {
	System.out.println("##########Before advice:基于注解的检查验证用户##############");
	System.out.println("target:" + communicator + ",arg0:" + msg0);
	authenticator.authenticate();
	System.out.println("##########Before advice end:基于注解的检查验证用户##############");
    }
    
}
