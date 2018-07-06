package com.example.demo.mainjob;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.common.AOPCustomException;

@Component
public class MyTask {

	private static int taskNumber = 0;
	@Autowired
	CommonTask commonTask;

	@Scheduled(fixedRate = 20000)
	public void schedule() throws AOPCustomException {
		// commonTask.executeTask(taskNumber++);
		taskNumber++;
		commonTask.getMultiplication(taskNumber);
		// commonTask.executeAddition(taskNumber);
		commonTask.throwException(taskNumber);
	}
}
