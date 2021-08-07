package com.techlabs.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LogInterceptor implements Interceptor {

	@Override
	public void destroy() {
		System.out.println("Innterceptor destroyed");

	}

	@Override
	public void init() {
		System.out.println("Interceptor started");

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Before time : ");
        System.out.println(java.time.LocalTime.now());
        String result = invocation.invoke();
        System.out.println("After time : ");
        System.out.println(java.time.LocalTime.now());
        
        
        return result;
	}

}
