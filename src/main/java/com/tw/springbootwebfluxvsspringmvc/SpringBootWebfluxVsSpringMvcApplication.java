package com.tw.springbootwebfluxvsspringmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class SpringBootWebfluxVsSpringMvcApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootWebfluxVsSpringMvcApplication.class, args);

		FunctionWebClient functionWebClient = new FunctionWebClient();
		System.out.println(functionWebClient.getResult());


		System.out.println("No. of active thread: " + Thread.activeCount());

		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		for ( Thread t : threadSet){
			if ( t.getThreadGroup() == Thread.currentThread().getThreadGroup() && !t.isDaemon()){
				System.out.println("Thread :"+t+":"+"state:"+t.getState() + "    IsDaemon : "+ t.isDaemon());
			}
		}

	}
}
