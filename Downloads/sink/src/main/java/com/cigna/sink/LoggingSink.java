/**
 * 
 */
package com.cigna.sink;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class LoggingSink {

	@StreamListener(Sink.INPUT)
	public void loggerSink(SinkTimeInfo sinkTimeInfo) {
		System.out.println("Received: " + sinkTimeInfo.toString());
	}
	
	public static class SinkTimeInfo{
		 
		private String time;
		private String label;
 
		public String getTime() {
			return time;
		}
 
		public void setTime(String time) {
			this.time = time;
		}
 
		public void setSinkLabel(String label) {
			this.label = label;
		}
 
		public String getLabel() {
			return label;
		}
 
		@Override
		public String toString() {
			return "SinkTimeInfo [time=" + time + ", label=" + label + "]";
		}
 
	}
}
