package ajia.security;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecureSetAnnotationAspect {

    private Authenticator authenticator = new Authenticator();

    @Pointcut("set(* ajia..*Communicator.name)")
    private void secureAccess() {
    }

    @Before("secureAccess()")
    public void abcBefore() {
	System.out.println("set:基于注解的检查验证用户..");
	authenticator.authenticate();
    }
    
    @After("secureAccess()")
    public void abcAfter() {
	System.out.println("set:After advice");
    }
    
//    @Around("secureAccess()")
//    public void abcAround() {
//	System.out.println("Around advice");
//    }
}
