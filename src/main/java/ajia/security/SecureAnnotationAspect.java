package ajia.security;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import ajia.messaging.MessageCommunicator;

@Aspect
public class SecureAnnotationAspect {

    private Authenticator authenticator = new Authenticator();

    // @Pointcut("execution (* *.*.MessageCommunicator.deliver(..))")
    // @Pointcut("call (* ajia..MessageCommunicator.deliver(..))")
    // @Pointcut("call (* ajia..*Communicator.deliver(..)) && target(communicator) && args(msg0,msg1)")
    @Pointcut("call (* ajia..*Communicator.deliver(..)) && target(communicator) && args(msg0,..)")
    private void secureAccess(MessageCommunicator communicator, String msg0) {
    }

    @Before("secureAccess(communicator,msg0)")
    public void abcBefore(MessageCommunicator communicator, String msg0) {
	System.out.println("##########Before advice:基于注解的检查验证用户##############");
	System.out.println("target:" + communicator + ",arg0:" + msg0);
		//+ ",arg1:" + msg1);
	authenticator.authenticate();
	System.out
		.println("##########Before advice end:基于注解的检查验证用户##############");
    }
    // @After("secureAccess(communicator,msg0)")
    // public void abcAfter(MessageCommunicator communicator, String msg0) {
    // System.out.println("#################After advice#############");
    // System.out.println("#################After advice end#############");
    // }

    // @Around("secureAccess()")
    // public void abcAround() {
    // System.out.println("Around advice");
    // }
}
