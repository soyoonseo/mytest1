package advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
//@Aspect�� �����̳ʿ��� �ڱⰡ ProxyFactoryBean�̶�� �˷��ִ� �� 
@Aspect 
public class BeforeAdvice {
	//�������κ��� ��û�� ������ ��, �ش� pointcut�� �ش��� �Ǹ�
	//���� �����̽��� �����Ѵ�. 
	// ��) today -> action, Today�� �����ϴ� ���� ������ �Ǿ��� ��
	// �׸��� execute()�� ������ ȣ��ǵ��� �Ǿ� �ִ�.
	@Before("execution(* action.Today*.execute(..))")
	public void before(JoinPoint jp) {
		
	}

}
