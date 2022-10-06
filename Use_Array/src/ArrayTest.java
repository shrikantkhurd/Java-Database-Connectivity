import java.util.*;
class Data
{
	
	int salary;
	int bonus;
	long totalsalary;
	String name;
	
	void accept()
	{
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter name of employee :");
		name=s.nextLine();
		System.out.println("Enter salary of employee :");
		salary=s.nextInt();
		System.out.println("Enter bonus of employee :");
		bonus=s.nextInt();
		
	}
	void total()
	{
		totalsalary=salary+bonus;
		
	}
	void display()
	{
		System.out.println("Name of employee :"+name);
		System.out.println("Salary of employee :"+salary);
		System.out.println("bonus salary of employee :"+bonus);
		System.out.println("Total salary of employee :"+totalsalary);
	}
}
public class ArrayTest {

	public static void main(String[] args) 
	{
		/*Data d1=new Data();
		d1.accept();
		d1.total();
		d1.display();
		*/
		int i;
		Data d[]=new Data[5];
		for(i=0;i<5;i++)
		{
			d[i]=new Data();
		}
		for(i=0;i<5;i++)
		{
			d[i].accept();
		}
		for(i=0;i<5;i++)
		{
			d[i].total();
		}
		for(i=0;i<5;i++)
		{
			d[i].display();
		}
	}
}
