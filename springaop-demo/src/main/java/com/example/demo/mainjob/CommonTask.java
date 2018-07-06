package com.example.demo.mainjob;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.example.demo.aspect.Loggable;

@Component
public class CommonTask {

	// @Async("threadPoolTaskExecutor")
	public int executeTask(int num) {
		System.out.println(
				"Seperate Thread-->[" + Thread.currentThread().getName() + "] " + num + "   " + this.toString());

		return num + num;

	}

	@Loggable
	public int getMultiplication(int num) {
		int num1 = num * num;
		System.out.println("Multiplicaton Done --->" + num1);
		return num1;
	}

	@Loggable
	public void executeAddition(int num) {
		int add = num + num;
		System.out.println("Addition Done --->" + add);
	}

}
