package sample.common;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Interceptor
@Log
public class LogInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	private final static Logger log = LoggerFactory.getLogger(LogInterceptor.class);
	
	@AroundInvoke
	public Object logMethodInvocation(InvocationContext ctx) throws Exception {
		log.info("entering method: " + ctx.getMethod().getDeclaringClass() + "." + ctx.getMethod().getName());
		return ctx.proceed();
	}
}
