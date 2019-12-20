package com.internousdev.multi.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.multi.util.Person;
import com.opensymphony.xwork2.ActionSupport;

public class multipleDisplayAction extends ActionSupport{
	private List<Person> list = new ArrayList<Person>();

	public String execute(){
		Person sato = new Person("sato", 28);
		Person monzen = new Person("monzen", 22);
		Person suzuki = new Person("suzuki", 31);

		list.add(sato);
		list.add(monzen);
		list.add(suzuki);

		return SUCCESS;
		}

	public List<Person> getList(){
		return this.list;
	}
	public void setList(List<Person> list){
		this.list = list;
	}

}


