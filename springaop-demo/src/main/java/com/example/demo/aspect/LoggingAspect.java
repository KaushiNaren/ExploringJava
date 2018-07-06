package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	@Around("@annotation(com.example.demo.aspect.Loggable)")
	public Object invoke(ProceedingJoinPoint pjp) throws Throwable {

		String strClass = pjp.getTarget().getClass().getName();
		String strMethod = pjp.getSignature().getName();

		for (Object object : pjp.getArgs()) {
			System.out.println("Aspect Around------->" + strClass + " ->" + strMethod + "arg-->" + object);
		}

		Object result = pjp.proceed();
		System.out.println("Aspect Around Executed successfully !!!!");
		return result;
	}

	@Before("@annotation(com.example.demo.aspect.Loggable)")
	public void logBeforeAspect(JoinPoint joinPoint) {
		System.out.println("Aspect Before : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.example.demo.mainjob.CommonTask.getMultiplication(..))")
	public void logBeforeAspectV2(JoinPoint joinPoint) {
		System.out.println("Aspect Before V2 : " + joinPoint.getSignature().getName());
	}

	@After("@annotation(com.example.demo.aspect.Loggable)")
	public void logAfterAspect(JoinPoint joinPoint) {
		System.out.println("Aspect After : " + joinPoint.getSignature().getName());
	}

	@AfterReturning(pointcut = "@annotation(com.example.demo.aspect.Loggable)", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {

		System.out.println(
				"Aspect AfterRunning!! " + joinPoint.getSignature().getName() + "   ---ReturnResult is -->" + result);
	}

	@AfterThrowing(pointcut = "@annotation(com.example.demo.aspect.Loggable)", throwing = "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

		System.out.println(
				"Aspect After Throwing!! " + joinPoint.getSignature().getName() + "   --- Exception is  -->" + error);

	}
}
