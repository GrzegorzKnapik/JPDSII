package com.jsfcourse.calc;

import javax.inject.Inject;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;




@Named
@RequestScoped
//@SessionScoped
public class CalcBB {
	private Integer value;
	private Double precent;
	private Integer time;
	private Double result;

	@Inject
	FacesContext ctx;

	

	public Integer getValue() {
		return value;
	}
	
	public void setValue(Integer value) {
		this.value = value;
	}

	public Double getPrecent() {
		return precent;
	}
	
	public void setPrecent(Double precent) {
		this.precent = precent;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public boolean calcCompute() {
			result = value/time + value/time*precent/100;
			result = Math.round(result*100.0)/100.0;

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
	}

	// Go to "showresult" if ok
	public String calc() {
		if (calcCompute()) {
			return "showresult";
		}
		return null;
	}

	// Put result in messages on AJAX call
	public String calc_AJAX() {
		if (calcCompute()) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Rata: " + result, null));
		}
		return null;
	}

	public String info() {
		return "info";
	}
}
