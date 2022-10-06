import java.util.*; 
 
class Information1
{   
    int id[10]=new id[];    
    String name;
    String store[10]=new String[];    
    Information in[]=new Information[100];  
    int InfoCount;       
  void getData()     
       {     
     System.out.println("Employee details :");     
     Scanner in=new Scanner(System.in);          
     System.out.println("Enter Employee name :");         
      name=in.nextLine();   
      int l=0;
      store[l]=name;
      System.out.println("Enter Employee id :");    
       id[l]=in.nextInt();   
  l++; 
      }    
    void putData()  
   {        
     for(int i=0;i<InfoCount;i++)   
      {         System.out.println("Employee id :"+id[i]);   
      System.out.println("Employee name :"+store[i]);       
     }     }   
  public  int choice()   
  {        
    InfoCount=0;    
     int ch;        
   do   
      {     
      System.out.println("\n1.Add employee details.");  
       System.out.println("2.Display all details.");       
     System.out.println("3.Exit");              
    Scanner s=new Scanner(System.in);           
     System.out.println("Enter your option :");       
      ch=s.nextInt();            
    switch(ch)           
     {        
     case 1://Add employees details. 
                getData();             
       InfoCount++;              
      break;             
     case 2://Display all details.                
    	 	System.out.println("All details of employees :");                 
    	 	putData();                 
    	 	InfoCount++;                
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
   } 
  } 
 
public class EmpD 
{ 
	public static void main(String[] args)     
	{
        Information e=new Information();
        e.choice();    
        } 
} 

 