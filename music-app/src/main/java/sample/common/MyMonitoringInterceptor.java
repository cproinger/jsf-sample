package sample.common;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import net.bull.javamelody.MonitoringInterceptor;

@MonitoredCDIBean
@Interceptor
public class MyMonitoringInterceptor extends MonitoringInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {
		// TODO Auto-generated method stub
		return super.intercept(context);
	}
}
