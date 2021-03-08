package com.backdata;

public class Supervisor_part extends Data_type_need
{
	public Supervisor_part(String Name,  Integer Payment, String codeId, String Sex,String job)
	{
		super(Name, Payment, codeId, Sex,job);
	}
	

	public void adjustSalary()
	{
		this.salary+=(int)(this.salary*0.075);
	
	}
}