// charAt method..
import java.util.*;

class String1
{
	String s1;
	char ch;
	int i;
	
	Scanner in=new Scanner(System.in);
	
	void getData()
	{
		try
		{
	System.out.println("Enter String :");
	s1=in.nextLine();
	System.out.println("String length :"+s1.length());
	System.out.println("Enter index number :-");
	i=in.nextInt();
	ch=s1.charAt(i);
	}
	
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
	void display()
	{
		System.out.println("String :-"+s1);
		System.out.println("String length :"+s1.length());
		
		System.out.println("Search index number is : "+i);
		
		
		System.out.println("index "+ i +" character is :-" +ch);
	}
}
public class String_Demo {

	public static void main(String[] args) {
		String1 s=new String1();
		s.getData();
		s.display();

	}

}
