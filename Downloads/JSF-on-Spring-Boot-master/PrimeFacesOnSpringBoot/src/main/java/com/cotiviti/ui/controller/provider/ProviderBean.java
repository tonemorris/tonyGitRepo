package com.cotiviti.ui.controller.provider;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cotiviti.ui.config.UrlSettings;
import com.cotiviti.ui.controller.model.Provider;
import com.cotiviti.ui.controller.model.WorkbenchStats;

@Component
@ManagedBean
@ViewScoped
public class ProviderBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name = "Sacred Heart Hospital Test";
	private RestTemplate restTemplate;
	private Provider provider;
	private Map<String, List<WorkbenchStats>> responseMap = new HashMap<String, List<WorkbenchStats>>();
	private List<WorkbenchStats> workbenchStatsList;
	
	@Autowired
	private UrlSettings urlSettings;
	
	@PostConstruct
	 public  void init() {
		 workbenchStatsList = new ArrayList<WorkbenchStats> ();
		 WorkbenchStats workbenchStats = new WorkbenchStats();
		 workbenchStats.setQname("testname");
		 workbenchStats.setCount("66");
		 workbenchStatsList.add(workbenchStats);
		 restTemplate = new RestTemplate();
		 //provider = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Provider.class);
		 
		 
	 }
	 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Map<String, List<WorkbenchStats>> getResponseMap() {
		return responseMap;
	}

	public void setResponseMap(Map<String, List<WorkbenchStats>> responseMap) {
		this.responseMap = responseMap;
	}

	public List<WorkbenchStats> getWorkbenchStatsList() {
		return workbenchStatsList;
	}

	public void setWorkbenchStatsList(List<WorkbenchStats> workbenchStatsList) {
		this.workbenchStatsList = workbenchStatsList;
	}
	
	
	
	

}
