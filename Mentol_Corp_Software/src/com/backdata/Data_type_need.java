package com.backdata;

abstract public class Data_type_need
{
	protected String name;
	protected Integer salary;
	protected String Id;
	protected String Gender;
	protected String jobdesk;
	
	
	public Data_type_need(String Name,  Integer Payment, String codeId, String Sex,String job)
	{
		this.Gender=Sex;
		this.Id=codeId;
		this.salary=Payment;
		this.name=Name;
		this.jobdesk=job;
	}
	


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getSalary() {
		return salary;
	}



	public void setSalary(Integer salary) {
		this.salary = salary;
	}



	public String getId() {
		return Id;
	}



	public void setId(String id) {
		Id = id;
	}



	public String getGender() {
		return Gender;
	}



	public void setGender(String gender) {
		Gender = gender;
	}



	public String getJobdesk() {
		return jobdesk;
	}



	public void setJobdesk(String jobdesk) {
		this.jobdesk = jobdesk;
	}



	abstract public void adjustSalary();
	
}