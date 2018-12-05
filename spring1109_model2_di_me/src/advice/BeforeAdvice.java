package advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
//@Aspect은 컨테이너에게 자기가 ProxyFactoryBean이라고 알려주는 것 
@Aspect 
public class BeforeAdvice {
	//서블릿으로부터 요청이 들어왔을 때, 해당 pointcut에 해당이 되면
	//이하 어드바이스를 적용한다. 
	// 예) today -> action, Today로 시작하는 모델이 생성이 되었을 때
	// 그리고 execute()가 무조건 호출되도록 되어 있다.
	@Before("execution(* action.Today*.execute(..))")
	public void before(JoinPoint jp) {
		
	}

}
