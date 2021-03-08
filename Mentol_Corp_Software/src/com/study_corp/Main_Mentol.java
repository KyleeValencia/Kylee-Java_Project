package com.study_corp;
import java.util.Scanner;
import java.util.Vector;
import java.util.Collections;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.Comparator;
import java.util.Random;
import com.backdata.Data_type_need;
import com.backdata.Administrator_part;
import com.backdata.Manager_part;
import com.backdata.Supervisor_part;

public class Main_Mentol
{

	private Scanner inp =  new Scanner(System.in);
	Vector<Data_type_need> datacorp= new Vector<Data_type_need>();
	public Main_Mentol()
	{
		Mainfeature();
	}
	private void Mainfeature()
	{
		while(true)
		{
			showTime mentolCorp= new showTime();
			
			System.out.println("\nLogged in at "+mentolCorp.dateDay+"WIB");
			System.out.println("+++++++++++++++++++++++++++++++++++++");
			System.out.println("|   Mentol Corp Employee Database   |");
			System.out.println("+++++++++++++++++++++++++++++++++++++");
			System.out.println("Choose operation\n");
			Listmenu();
			System.out.print("-->");
			char choose;
			do
			{
				choose = inp.next().charAt(0);
				if(choose<'1'||choose>'4')
				{
					System.out.println("No such operation. Take new input");
					Listmenu();
					
				}
			}while(choose<'1'||choose>'4');
			
			if(choose=='1')
			{
				inpdataEmployee();
				System.out.println("\nInput data success");
			}
			else if (choose=='2')
			{
				show_curr();
				System.out.println("\nShow success");
			}
			else if (choose=='3')
			{
				update_data();
				System.out.println("\nUpdate Success");
			}
			else if(choose=='4')
			{
				delete_employee();
				System.out.println("\nDelete success");
			}
			System.out.println("+=============================+");
			System.out.println("| Wish to continue (y | n) ?? |");
			System.out.println("+=============================+");
			
//			String proceed;
			chooseYN r=new chooseYN();
				if(r.proceed.equalsIgnoreCase("n"))
				{
					System.out.println("+==================================================+");
					System.out.println("| Operation finish, Thankyou for using this app :> |");
					System.out.println("+==================================================+");
					break;
				}	
		}
	}
	
	private void update_data()
	{
		while(true)
		{
//			System.out.print("Current employee data");
			show_curr();
			System.out.print("Using Employee Index to update So...");
			chooseIdx idx = new chooseIdx();
			makeData dataX = new makeData();
//			if(dataX.tire!=datacorp.get(idxdel).getJobdesk())
//			RaiseSalary(dataX.tire);
			
			if(datacorp.elementAt((idx.iddel)-1).getJobdesk().equalsIgnoreCase(dataX.tire))
			{
//				System.out.println("Before update salary is Rp."+datacorp.elementAt((idx.iddel)-1).getSalary());
				if(dataX.tire.equalsIgnoreCase("Manager"))
				{
					datacorp.set((idx.iddel)-1,new Manager_part(dataX.name, datacorp.elementAt((idx.iddel)-1).getSalary(), datacorp.elementAt((idx.iddel)-1).getId(), dataX.gender, datacorp.elementAt((idx.iddel)-1).getJobdesk()));
					
				}
				if(dataX.tire.equalsIgnoreCase("Supervisor"))
				{
					datacorp.set((idx.iddel)-1,new Supervisor_part(dataX.name, datacorp.elementAt((idx.iddel)-1).getSalary(), datacorp.elementAt((idx.iddel)-1).getId(), dataX.gender, datacorp.elementAt((idx.iddel)-1).getJobdesk()));
					
				}
				if(dataX.tire.equalsIgnoreCase("Admin"))
				{
					datacorp.set((idx.iddel)-1,new Administrator_part(dataX.name, datacorp.elementAt((idx.iddel)-1).getSalary(), datacorp.elementAt((idx.iddel)-1).getId(), dataX.gender, datacorp.elementAt((idx.iddel)-1).getJobdesk()));
					
				}
				
//				System.out.println("After update salary is Rp."+datacorp.elementAt((idx.iddel)-1).getSalary());				
			}
			
			else
			{
				if(dataX.tire.equalsIgnoreCase("Manager"))
				{
					datacorp.set((idx.iddel)-1,new Manager_part(dataX.name, 8000000,  datacorp.elementAt((idx.iddel)-1).getId(), dataX.gender, "Manager"));
					
				}
				if(dataX.tire.equalsIgnoreCase("Supervisor"))
				{
					datacorp.set((idx.iddel)-1,new Supervisor_part(dataX.name, 6000000,  datacorp.elementAt((idx.iddel)-1).getId(), dataX.gender, "Supervisor"));
					
				}
				if(dataX.tire.equalsIgnoreCase("Admin"))
				{
					datacorp.set((idx.iddel)-1,new Administrator_part(dataX.name, 4000000,  datacorp.elementAt((idx.iddel)-1).getId(), dataX.gender, "Admin"));
					
				}
				
			}
		
//			System.out.print("Data after update ");
			show_curr();
			System.out.println("+=====================================+");
			System.out.println("| Wish to update more data (y | n) ?? |");
			System.out.println("+=====================================+");
//			System.out.print("-->");
			chooseYN r=new chooseYN();
			 
				if(r.proceed.equalsIgnoreCase("n"))
				{
					System.out.println("+======================+");
					System.out.println("| Finish update data ! |");
					System.out.println("+======================+");
					break;
				}
		}
	}
	private void delete_employee()
	{
		while(true)
		{
//			System.out.print("Current employee");
			show_curr();
			 
			System.out.print("Using Employee Index to delete So...");
			chooseIdx idx = new chooseIdx();
			datacorp.remove((idx.iddel)-1);
			
			
			show_curr();
			System.out.println("+=================================+");
			System.out.println("|Continue to delete data (y | n)??|");
			System.out.println("+=================================+");

			chooseYN r=new chooseYN();
			showTime n=new showTime();
			System.out.println("Current data on "+n.dateDay+"is");
				if(r.proceed.equalsIgnoreCase("n"))
				{
					System.out.println("*==================*");
					System.out.println("|Finish delete data|");
					System.out.println("*==================*");
					break;
				}
		}
	}
	
	private class chooseIdx
	{
		int iddel;
		public chooseIdx() 
		{
			while(true)
			{
				System.out.print("Choose index :");
				iddel=inp.nextInt();
				if(iddel<0||iddel>datacorp.size())
				{
					System.out.println("Input index out of bound");
				}
				else
				{
					break;
				}
			}
		}
	}
	private void inpdataEmployee()
	{
		while(true)
		{
			makeData dataC = new makeData();
			
			RaiseSalary(dataC.tire);
			
			if(dataC.tire.equalsIgnoreCase("Manager"))
			{
				
				datacorp.add(new Manager_part(dataC.name, 8000000, dataC.genId, dataC.gender, "Manager"));
			}
			if(dataC.tire.equalsIgnoreCase("Supervisor"))
			{
				datacorp.add(new Supervisor_part(dataC.name, 6000000, dataC.genId, dataC.gender, "Supervisor"));
				
			}
			if(dataC.tire.equalsIgnoreCase("Admin"))
			{
				datacorp.add(new Administrator_part(dataC.name, 4000000, dataC.genId, dataC.gender, "Admin"));
				
			}
			
			System.out.println("\nSuccess added employee with id "+dataC.genId+"\n");
			
			String jobdesk = null;
			if(dataC.tire.equalsIgnoreCase("Manager"))
			{
				jobdesk="10%";
			}
			else if(dataC.tire.equalsIgnoreCase("Supervisor"))
			{
				jobdesk="7.5%";
			}
			else if(dataC.tire.equalsIgnoreCase("Admin"))
			{
				jobdesk="5%";
			}
			System.out.println("Bonus about "+jobdesk+" are given to employee with id :");
			for(Data_type_need dig : datacorp)
			{
				if(dig.getJobdesk().equalsIgnoreCase(dataC.tire)&& dig.getId()!=dataC.genId)
				{
					System.out.println("->"+dig.getId());
				}
			}
			
			System.out.println("\n");
			show_curr();
			System.out.println("");
			System.out.println("+======================================+");
			System.out.println("| Wish to add more employee (y | n) ?? |");
			System.out.println("+======================================+");
			chooseYN r=new chooseYN();
			 
				
				if(r.proceed.equalsIgnoreCase("n"))
				{
					System.out.println("+===========================+");
					System.out.println("| Input added to database ! |");
					System.out.println("+============================");
					break;
				}	
			
		}
	}
	private void show_curr()
	{
		
		Collections.sort(datacorp, new Comparator<Data_type_need>() 
		{
			
			@Override
			public int compare(Data_type_need  f1, Data_type_need f2)
			{
				return f1.getName().compareTo(f2.getName());
			}
		});
		
		int r=1;
		showTime nw= new showTime();
		System.out.println("Current employee in corporation on "+nw.dateDay+" is :\n");
		System.out.println("|-------|---------|---------------------|--------|------------|---------------|");
		System.out.printf("|%-7s|%-9s|%-21s|%-8s|%-12s|%-18s|\n","No","Code Id","Employee Name","Gender","Department","Salary (Rp)");
		System.out.println("|-------|---------|---------------------|--------|------------|---------------|");
		for(Data_type_need show:datacorp)
		{
			
			if(show.getGender().equalsIgnoreCase("Male") )
			{
				System.out.printf("|%7d|%9s|%21s|%8s|%12s|%18d|",r,show.getId(),show.getName(),"Male",show.getJobdesk(),show.getSalary());
			}
			if(show.getGender().equalsIgnoreCase("Female"))
			{
				System.out.printf("|%7d|%9s|%21s|%8s|%12s|%18d|",r,show.getId(),show.getName(),"Female",show.getJobdesk(),show.getSalary());
			}
			

			System.out.println();
			r++;
		}
		System.out.println("|-------|---------|---------------------|--------|------------|---------------|");
	}
	private void RaiseSalary(String type)
	{
		for(Data_type_need data:datacorp)
		{
			if(data instanceof Manager_part && type.equalsIgnoreCase("Manager"))
			{
				data.adjustSalary();
//				System.out.println("Added as Manager");
			}
			if(data instanceof Administrator_part && type.equalsIgnoreCase("Admin"))
			{
				data.adjustSalary();
//				System.out.println("Added as Admin");
			}
			if(data instanceof Supervisor_part && type.equalsIgnoreCase("Supervisor"))
			{
				data.adjustSalary();
//				System.out.println("Added as Supervisor");
			}
		}
	}
	private class makeData
	{
		Random rand = new Random();
		String name,gender,tire,genId;
		makeData()
		{
//			int d=0;
			while (true)
			{
				System.out.print("Input employee name [>=3]:");
				System.out.print("-->");
				name = inp.nextLine();
//				inp.wait();
//				inp.next();
				if(name.length()<3&&name.length()>0)
				{
					System.out.println("Input name length not enough.");
//					System.out.println("Please get new input");
				}
				
				else if(name.length()>=3)
				{
					break;
				}
			}
			name=name.trim();
//				d++;
			while(true)
			{
				System.out.print("Input gender [Male | Female]:");
//				System.out.print("-->");
				gender=inp.nextLine();
				if(!(gender.equalsIgnoreCase("Male")||gender.equalsIgnoreCase("Female")))
				{
					System.out.println("No such gender");
				}
				else
				{
					break;
				}
			}
			while(true)
			{
				System.out.print("Input department [Manager | Supervisor | Admin]:");
//				System.out.print("-->");
				tire=inp.nextLine();
				if(!(tire.equalsIgnoreCase("Manager")||tire.equalsIgnoreCase("Supervisor")||tire.equalsIgnoreCase("Admin")))
				{
					System.out.println("No such department");
				}
				else
				{
					break;
				}
			}
			
			while(true)
			{
				String alp = rand.ints(65,91).limit(2).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();//ascii big alphabet
				String num = rand.ints(48,58).limit(4).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();//ascii numeric
				genId=alp+"-"+num;
				
				boolean getX=true;
				for(Data_type_need data: datacorp)
				{
					if(genId==data.getId())
					{
						getX=false;
						break;
					}
				}
				if(getX==true)
				{
					break;
				}
			}

		}
	}
	
	private class chooseYN
	{
		String proceed;
		chooseYN()
		{
			while(true)
			{
				System.out.print("-->");
				proceed = inp.next();
//				proceed = inp.nextLine();
				if(!(proceed.equalsIgnoreCase("y") ||proceed.equalsIgnoreCase("n")))
				{
					System.out.println("Not the expected input");
				}
				else
				{
					break;
				}
			}
		}
	}
	private void Listmenu()
	{
		System.out.println("[1] Input New Employee");
		System.out.println("[2] Show Current Employee");
		System.out.println("[3] Update Employee Data");
		System.out.println("[4] Delete Retire Employee");
	}
	private class showTime
	{ 
		String dateDay=null;
		showTime()
		{
			SimpleDateFormat GMTdate = new SimpleDateFormat("EEE dd-MMM-yyyy hh:mm:ss aa");
			GMTdate.setTimeZone(TimeZone.getTimeZone("GMT+07:00"));//WIB timeline
			dateDay=GMTdate.format(new Date());
//			System.out.println();
			
		}
	}
	public static void main(String[] args)
	{
		new Main_Mentol();
	}
	
	
}
