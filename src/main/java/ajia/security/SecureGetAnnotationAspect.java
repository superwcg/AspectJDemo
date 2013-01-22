package ajia.security;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecureGetAnnotationAspect {

    private Authenticator authenticator = new Authenticator();

    @Pointcut("get(* ajia..*Communicator.name)")
    private void secureAccess() {
    }

    @Before("secureAccess()")
    public void abcBefore() {
	System.out.println("get:基于注解的检查验证用户..");
	authenticator.authenticate();
    }
    @After("secureAccess()")
    public void abcAfter() {
	System.out.println("get:After advice");
    }
    
//    @Around("secureAccess()")
//    public void abcAround() {
//	System.out.println("Around advice");
//    }
}
