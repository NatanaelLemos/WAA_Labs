package edu.mum.waa.jsf.beans;

import java.io.Serializable;

//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

//@ManagedBean
@Named
@SessionScoped
public class Visitor implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String lastname;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
