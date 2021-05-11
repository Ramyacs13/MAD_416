/*class Print
{
	boolean sharedflag=false;
	
	}
}*/

class ThreadDemo implements Runnable {
   Thread t;
   String name;
   boolean sharedflag;
   ThreadDemo(String threadname) {
        name = threadname;
		t = new Thread(this,name);
		sharedflag = true;
		t.start();
   }
   synchronized void print_t1(String name)
	{
		try
		{
			if(!sharedflag)
			{
				wait();
			}
		}
		catch(InterruptedException e)
	   {
		   System.out.println(name+"interrupted");
	   }
		System.out.println(name+":"+"t1");
		sharedflag=false;
		notify();
		
	}
	synchronized void print_t2(String name)
	{
		System.out.println("print");
		try
		{
			if(sharedflag)
			{
				wait();
			}
		}
		catch(InterruptedException e)
	   {
		   System.out.println(name+"interrupted");
	   }
		System.out.println(name+":"+"t2");
		sharedflag=true;
		notify();
	}
   public void run() {
	
		if(name == "One")
			print_t1(name);
		else
			print_t2(name);
			
	

   
   }
   public static void main(String args[]) {
	    
			Print p1 = new Print();
			ThreadDemo t1 = new ThreadDemo("One");
			ThreadDemo t2 = new ThreadDemo("Two");
		
		
   }
}

