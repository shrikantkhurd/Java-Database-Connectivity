//STACK and AWT component assignment

package Assignment;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class StackDemo implements ActionListener {

	public Frame f;
	public Button b1,b2;
	public Label l1,l2;
	public TextField tx1,tx2;
	
	Stack <Integer> stk = new Stack<>();
	
	public StackDemo()
	{
		l1=new Label("Enter to be push : ");
		l1.setBounds(50, 60, 100, 20);
		l2=new Label("Display : ");
		l2.setBounds(50, 200, 100, 20);
		b1=new Button("PUSH");
		b1.setBounds(150,120,80,30);
		b2=new Button("POP");
		b2.setBounds(300,120,80,30);
		tx1=new TextField(10);
		tx1.setBounds(180, 60, 200, 30);
		tx2=new TextField(20);
		tx2.setEditable(false); 
		tx2.setBounds(180, 200, 200, 30);
		
		f=new Frame("Stack Demo");
		f.add(l1);
		f.add(tx1);
		f.add(b1); 
		f.add(b2);
		f.add(l2);
		f.add(tx2);
		
		f.setSize(500,400);  
		f.setLayout(null);  
		f.setVisible(true);  
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	
		f.addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                f.dispose();  
            }  
        });  
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1)
		{
			int no=Integer.parseInt(tx1.getText());
			
			stk.push(new Integer(no));
			tx2.setText(" "+stk);
			tx1.setText(null);
		}
		else if(ae.getSource()==b2)
		{
			Integer x = (Integer) stk.pop(); 
			tx2.setText(" "+stk);
			tx1.setText(null);
		}
	}
	
	public static void main(String[] args) {
		StackDemo s=new StackDemo();
	}
	
}
