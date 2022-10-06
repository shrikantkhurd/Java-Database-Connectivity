

import java.util.*;

class Employee
{
	 int id;
	 String name;
	
	Employee(int id, String name)
	{
		this.id=id;
		this.name=name;
	}

	/*	@Override
	public String toString() {
		//return "Employee [id=" + id + ", name=" + name + "]";
		return "id= " + id ;//+ ", name= " + name;

	}
	public String toString1() {
		//return "Employee [id=" + id + ", name=" + name + "]";
		return "name= " + name;

	}*/
}



class Information //extends Employee
{
	
	int id;    
    String name;
 
	Employee info[]=new Employee[100];
	static int InfoCount=0; 
	
	Scanner in=new Scanner(System.in);

	void getData()
	{	
		System.out.println("Employee details :");
		
		System.out.println("Enter Employee name :");
		name=in.next();

		System.out.println("Enter Employee id :");
		id=in.nextInt();
		
		Employee e= new Employee(id,name);
		info[InfoCount]=e;
	}
	void putData()
	{
	for(int i=0;i<InfoCount;i++)
		{
			
		System.out.println("Employee id :"+info[i].id);
		System.out.println("Employee name :"+ info[i].name);
	
		}
	}
	public  int choice()
	{
		//InfoCount=0;
		int ch;
		do
		{
		
		System.out.println("--------- Options ---------");
		System.out.println("1.Add employee details.");
		System.out.println("2.Display all details.");
		System.out.println("3.Exit");
		
		System.out.println("--------------------------");
			System.out.println("Enter your option :");
			ch=in.nextInt();
		System.out.println("--------------------------");

			switch(ch)
			{
			case 1://Add employees details.
				getData();
				InfoCount++;
				break;
				
			case 2://Display all details.
				System.out.println("All details of employees :");
				
					putData();
				
				//InfoCount++;
				break;
				
			case 3://Exit.
				System.out.println("Thank you.");
				System.exit(1);
				break;
				
			default :
				System.out.println("Invalid choice.");
			}
		}while(ch !=3);
		return choice();
		//return ch;
	}
}

public class EmpDetails
{
	public static void main(String[] args) 
	{
		Information e=new Information();
		e.choice();
	}
}
