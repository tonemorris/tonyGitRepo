package com.cigna.processor;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.handler.annotation.SendTo;




@SpringBootApplication
@EnableBinding(Processor.class)
public class ProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessorApplication.class, args);
	}

	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)	
	public TimeInfo loggerProcessor(TimeInfo timeInfo) {
		System.out.println("Transforming: " + timeInfo.toString());

		return timeInfo;
	}
	
	
	public static class TimeInfo{
		 
		private String time;
		private String label;
 
		
		public TimeInfo() {
			super();
			// TODO Auto-generated constructor stub
		}

		public TimeInfo(String time, String label) {
			super();
			this.time = time;
			this.label = label;
		}
 
		public String getTime() {
			return time;
		}
 
		public String getLabel() {
			return label;
		}

		@Override
		public String toString() {
			return "TimeInfo [time=" + time + ", label=" + label + "]";
		}
		
		
 
	}
}

