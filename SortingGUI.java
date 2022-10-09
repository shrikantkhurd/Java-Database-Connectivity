// AWT component assignment
package Assignment;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SortingGUI implements ItemListener{

	public Frame f;
	public Label l1,l2,l3,l4,l5,l6;
	public CheckboxGroup c;
	public Checkbox c1,c2,c3,c4,c5;
	public TextField tf1,tf2,tf3,tf4,tf5,tf6;
	public Button btn;

	public SortingGUI() {
		btn=new Button("CLEAR");
		
		btn.setBounds(200, 400, 50, 30);
		l1=new Label("Enter first number : ");
		l1.setBounds(50, 60, 150, 20);
		l2=new Label("Enter second number : ");
		l2.setBounds(50, 90, 150, 20);
		l3=new Label("Enter third number : ");
		l3.setBounds(50, 120, 150, 20);
		l4=new Label("Enter fourth number : ");
		l4.setBounds(50, 150, 150, 20);
		l5=new Label("Enter fifth number : ");
		l5.setBounds(50, 180, 150, 20);
		l6=new Label("Sorted array : ");
		l6.setBounds(50, 350, 100, 20);
		
		tf1 =new TextField();
		tf1.setBounds(200, 60, 100, 20);
		tf2 =new TextField();
		tf2.setBounds(200, 90, 100, 20);
		tf3 =new TextField();
		tf3.setBounds(200, 120, 100, 20);
		tf4 =new TextField();
		tf4.setBounds(200, 150, 100, 20);
		tf5 =new TextField();
		tf5.setBounds(200, 180, 100, 20);
		tf6 =new TextField();
		tf6.setBounds(200, 350, 200, 25);
		tf6.setEditable(false);
	
		c=new CheckboxGroup();
		c1=new Checkbox("Bubble Sort", false, c);
		c1.setBounds(100, 220, 100, 50);
		c2=new Checkbox("Selection Sort", false, c);
		c2.setBounds(100, 260, 100, 50);
		c3=new Checkbox("Merge Sort", false, c);
		c3.setBounds(210, 220, 100, 50);
		c4=new Checkbox("Quick Sort", true, c);
		c4.setBounds(210, 260, 100, 50);
		c5=new Checkbox("Radix Sort", true, c);
		c5.setBounds(310, 220, 100, 50);
		
		f=new Frame("Sorting Methods");
		f.setLayout(null);
		f.add(l1);
		f.add(tf1);
		f.add(l2); 
		f.add(tf2);
		f.add(l3);
		f.add(tf3);
		f.add(l4); 
		f.add(tf4);
		f.add(l5);
		f.add(tf5);
		f.add(l6); 
		f.add(tf6);
		
		f.add(c1);
		f.add(c2);
		f.add(c3);
		f.add(c4);
		f.add(c5);
		
		f.add(btn);
		
		f.setSize(500,500);  
		f.setLayout(null);  
		f.setVisible(true);  
		
		c1.addItemListener(this);
		c2.addItemListener(this);
		c3.addItemListener(this);
		c4.addItemListener(this);
		c5.addItemListener(this);
		
		btn.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent e)
		{
				if(e.getSource()==btn)
				{
					tf1.setText(null);
					tf2.setText(null);
					tf3.setText(null);
					tf4.setText(null);
					tf5.setText(null);
					tf6.setText(null);
					
					c1.setState(false);
					c2.setState(false);
					c3.setState(false);
					c4.setState(false);
					c5.setState(false);
					
				}
			}
		});
		
		f.addWindowListener(new WindowAdapter()
		{  
            public void windowClosing(WindowEvent e) 
            {  
                f.dispose();  
            }  
        });
	}

	@Override
	public void itemStateChanged(ItemEvent ae) 
	{
		int n1,n2,n3,n4,n5;
		n1=Integer.parseInt(tf1.getText());
		n2=Integer.parseInt(tf2.getText());
		n3=Integer.parseInt(tf3.getText());
		n4=Integer.parseInt(tf4.getText());
		n5=Integer.parseInt(tf5.getText());
		int[] nos={n1,n2,n3,n4,n5};
		
		if(ae.getSource()==c1)
		{
			//bubble sort
			
			int temp = 0;  
			
			for(int i=0; i < nos.length; i++)
			{  
                for(int j=1; j < (nos.length-i); j++)
				{  
                    if(nos[j-1] > nos[j])
					{  
                        //swap elements  
                        temp = nos[j-1];  
                        nos[j-1] = nos[j];  
                        nos[j] = temp;
						
                    }//end if     
                }//end for j  
			}//end for i  
			
			tf6.setText("BUBBLE SORT - "+nos[0]+","+nos[1]+","+nos[2]+","+nos[3]+","+nos[4]);
				
		}
		
		if(ae.getSource()==c2)
		{
			//selection sort
			
			for (int i = 0; i < nos.length - 1; i++)  
			{  
				int index = i;  
				
				for (int j = i + 1; j < nos.length; j++)
				{  
					if (nos[j] < nos[index])
					{  
						index = j;//searching for lowest index  
					}//end if  
				} //end for j 
				
				int temp = nos[index];   
				nos[index] = nos[i];  
				nos[i] = temp;  
			} //end for i 
			
			tf6.setText("SELECTION SORT - "+nos[0]+","+nos[1]+","+nos[2]+","+nos[3]+","+nos[4]);
			
		}
		
		if(ae.getSource()==c3)
		{
			//merge sort
			
			sort(nos, 0, nos.length - 1);  
			
			tf6.setText("MERGE SORT - "+nos[0]+","+nos[1]+","+nos[2]+","+nos[3]+","+nos[4]);
		}
		
		if(ae.getSource()==c4)
		{
			//quick sort
			
			qsort(nos, 0, nos.length-1);
			
			tf6.setText("QUICK SORT - "+nos[0]+","+nos[1]+","+nos[2]+","+nos[3]+","+nos[4]);
			
		}
		
		if(ae.getSource()==c5)
		{
			//radix sort
			
			radixsort(nos,nos.length);
			
			tf6.setText("RADIX SORT - "+nos[0]+","+nos[1]+","+nos[2]+","+nos[3]+","+nos[4]);
			
		}//end if
			
	}//end itemStateChanged
	
	//For merge sort
		 void merge(int arr[], int l, int m, int r) 
		{ 
			// Find sizes of two subarrays to be merged 
			int n1 = m - l + 1; 
			int n2 = r - m; 
	  
			/* Create temp arrays */
			int L[] = new int[n1]; 
			int R[] = new int[n2]; 
	  
			/*Copy data to temp arrays*/
			for (int i = 0; i < n1; ++i) 
				L[i] = arr[l + i]; 
			for (int j = 0; j < n2; ++j) 
				R[j] = arr[m + 1 + j]; 
	  
			/* Merge the temp arrays */
	  
			// Initial indexes of first and second subarrays 
			int i = 0, j = 0; 
	  
			// Initial index of merged subarry array 
			int k = l; 
			while (i < n1 && j < n2) 
			{ 
				if (L[i] <= R[j]) 
				{ 
					arr[k] = L[i]; 
					i++; 
				} 
				else 
				{ 
					arr[k] = R[j]; 
					j++; 
				} 
				k++; 
			} 
	  
			/* Copy remaining elements of L[] if any */
			while (i < n1) 
			{ 
				arr[k] = L[i]; 
				i++; 
				k++; 
			} 
	  
			/* Copy remaining elements of R[] if any */
			while (j < n2) 
			{ 
				arr[k] = R[j]; 
				j++; 
				k++; 
			} 
		}//end
  
		// Main function that sorts arr[l..r] using 
		// merge() 
		void sort(int arr[], int l, int r) 
		{ 
			if (l < r) 
			{ 
				// Find the middle point 
				int m = (l + r) / 2; 
	  
				// Sort first and second halves 
				sort(arr, l, m); 
				sort(arr, m + 1, r); 
	  
				// Merge the sorted halves 
				merge(arr, l, m, r); 
			} 
		}
		
		
		//For quick sort
		int partition(int arr[], int low, int high) 
		{ 
			int pivot = arr[high];  
			int i = (low-1); // index of smaller element 
			for (int j=low; j<high; j++) 
			{ 
				// If current element is smaller than or 
				// equal to pivot 
				if (arr[j] <= pivot) 
				{ 
					i++; 
	  
					// swap arr[i] and arr[j] 
					int temp = arr[i]; 
					arr[i] = arr[j]; 
					arr[j] = temp; 
				} 
			} 
	  
			// swap arr[i+1] and arr[high] (or pivot) 
			int temp = arr[i+1]; 
			arr[i+1] = arr[high]; 
			arr[high] = temp; 
	  
			return i+1; 
		} 
	  
	  
		/* The main function that implements QuickSort() 
		  arr[] --> Array to be sorted, 
		  low  --> Starting index, 
		  high  --> Ending index */
		void qsort(int arr[], int low, int high) 
		{ 
			if (low < high) 
			{ 
				/* pi is partitioning index, arr[pi] is  
				  now at right place */
				int pi = partition(arr, low, high); 
	  
				// Recursively sort elements before 
				// partition and after partition 
				qsort(arr, low, pi-1); 
				qsort(arr, pi+1, high); 
			} 
		} 
		
		
		//For radix sort
		// A utility function to get maximum value in arr[]
		static int getMax(int arr[], int n)
		{
			int mx = arr[0];
			for (int i = 1; i < n; i++)
				if (arr[i] > mx)
					mx = arr[i];
			return mx;
		}
	 
		// A function to do counting sort of arr[] according to
		// the digit represented by exp.
		static void countSort(int arr[], int n, int exp)
		{
			int output[] = new int[n]; // output array
			int i;
			int count[] = new int[10];
			Arrays.fill(count, 0);
	 
			// Store count of occurrences in count[]
			for (i = 0; i < n; i++)
				count[(arr[i] / exp) % 10]++;
	 
			// Change count[i] so that count[i] now contains
			// actual position of this digit in output[]
			for (i = 1; i < 10; i++)
				count[i] += count[i - 1];
	 
			// Build the output array
			for (i = n - 1; i >= 0; i--) {
				output[count[(arr[i] / exp) % 10] - 1] = arr[i];
				count[(arr[i] / exp) % 10]--;
			}
	 
			// Copy the output array to arr[], so that arr[] now
			// contains sorted numbers according to curent digit
			for (i = 0; i < n; i++)
				arr[i] = output[i];
		}
	 
		// The main function to that sorts arr[] of size n using
		// Radix Sort
		static void radixsort(int arr[], int n)
		{
			// Find the maximum number to know number of digits
			int m = getMax(arr, n);
	 
			// Do counting sort for every digit. Note that
			// instead of passing digit number, exp is passed.
			// exp is 10^i where i is current digit number
			for (int exp = 1; m / exp > 0; exp *= 10)
				countSort(arr, n, exp);
		}

	public static void main(String[] args) {
		SortingGUI s=new SortingGUI();

	}
}
