
package com.cigna.logreader.reader;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="BATCH_JOB_EXECUTION")
public class Batch {
	
	@Id
	private String id;
    private Long jobId;
    private Date createTime;
    private Date startTime;
    private Date endTime;
    private String status;
	
	
	public Batch(Long jobId, Date createTime, Date startTime, Date endTime, String status) {
		this.createTime = createTime;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
		this.jobId = jobId;
	}
	
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
    
}
