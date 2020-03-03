import java.util.Scanner;
import java.util.Set;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import java.util.TreeMap;
import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
public class Main {
	public static LinkedList<Student> st=new LinkedList<Student>();
	public static LinkedList<Book> bk=new LinkedList<Book>();
	public static TreeMap<Integer,LinkedList<String>> t;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Enter your role: \n Type \"Admin\" or \" Student\"");
		Scanner sc=new Scanner(System.in);
		String Role=sc.next();
		//addBooksInfo(book no,Name,status,issu_Date,Last_Date,Fee balance)
		t=addBooksInfo(1,"C programming","Issued","17/12/2019","30/10/2019","0");
		//adding the tree map to the student roll no 1
		st.add(new Student(1,"Kumar","3year_it",t,0));
		//creating the book list for the student roll no 2
		t=addBooksInfo(2,"Java programming","Issued","17/12/2019","30/10/2019","0");
		//adding book info the student rollNo 2
		st.add(new Student(2,"Manoj","4year_cse",t,0));
		//creating the book list for the student 
		t=addBooksInfo(3,"C++ programming","Renewed","25/12/2019","10/12/2019","0");
		st.add(new Student(3,"Rumak","2year_ece",t,0));
			
		bk.add(new Book(1,"C programming","Dennis Ritchie",120,1));
		bk.add(new Book(2,"C programming","Dennis Ritchie",120,0));
		bk.add(new Book(3,"C programming","Dennis Ritchie",120,0));
		bk.add(new Book(4,"Java programming","James Patrick",150,2));
		bk.add(new Book(5,"Java programming","James Patrick",150,0));
		bk.add(new Book(6,"Java programming","James Patrick",150,0));
		bk.add(new Book(7,"C++ programming","Schibller",120,3));
		bk.add(new Book(8,"C++ programming","Schibller",120,0));
		bk.add(new Book(9,"C++ programming","Schibller",120,0));
		
		if(Role.equals(("Admin")))
		{
			int h=9;
			
			while(h==9)
			{
				System.out.println("Enter the Operation wants to do \n \t  1 for \"Put Student \" \n\t 2 for \"Get Student\"  \n\t 3 for \"Put Book\" \n\t 4 for \"Get Book\"\n");
				System.out.println("Enter -1 to exit");
				h=sc.nextInt();
				if(h==1)
				{		
					System.out.println("The boook students taken should be \"\" and fees balance should be 0 when Student inserted");
					System.out.print("Enter the Student Roll No : ");
					int r=sc.nextInt();
					System.out.print("\nEnter the Student Name : ");
					String na=sc.next();
					System.out.println("Enter the Student Class : ");
					String s=sc.next();
					System.out.println("Enter the book student taken");
					 sc.next();
					 TreeMap m=null;
					System.out.println("Enter the Fees balance pending");
					int amt=sc.nextInt();
					st.add(new Student(r,na,s,m,amt));	
				}
				if(h==2)
				{
					System.out.println("Enter the rollNo to get the details");
					int no=sc.nextInt();
					Iterator it=st.iterator();
					while(it.hasNext())
					{
						Student s=(Student)it.next();
						System.out.println(s.Name);
						if((s.rollNo)==no)
						{
							System.out.format("%s 		: %d\n","Roll No",s.rollNo);
							System.out.format("%s			: %s\n","Name",s.Name);
							System.out.format("%s    		: %s\n","Class",s.Cls);
							System.out.format("%s     		: %s\n","Book Taken",s.BooksTkn);
							System.out.format("%s 		: %d\n","Fees Balance",s.FeesBalance);
							//System.out.println(s.rollNo+" "+s.Name+" "+s.Cls+" "+s.BookTkn+" "+s.FeesBalance);
						}
					}
				}
				if(h==3)
				{
					System.out.println("Enter the Book details \n");
					System.out.print("Enter the Book No 	: ");
					int num=sc.nextInt();
					System.out.print("\nEnter the Book Name 	: ");
					String na=sc.nextLine();
					System.out.println("Enter the Book Author : ");
					String s=sc.nextLine();
					System.out.println("Enter the Student name who taken the book");
					int roll=sc.nextInt();
					System.out.println("Enter the Amount of the book : " );
					int amt=sc.nextInt();
					bk.add(new Book(num,na,s,amt,roll));
				}
				if(h==4)
				{
					System.out.println("Enter the book no");
					int num=sc.nextInt();
					Iterator it=bk.iterator();
					while(it.hasNext())
					{
						Book s=(Book)it.next();
						if((s.no)==num)
						{
							System.out.format("%s 	: %d\n","Book No",s.no);
							System.out.format("%s 	: %s\n","Book Name",s.BkName);
							System.out.format("%s 		: %s\n","Author",s.BkAuthor);
							System.out.format("%s 		: %s\n","Amount",s.Amt);
							System.out.format("%s 	: %d\n","Taken by",s.TknBy);
						}
					}
				}
				if(h==-1)
				{
					break;
				}
				h=9;
			}
		}
		if(Role.equals(("Student")))
		{
			int u=9;
			System.out.println("Enter your roll no");
			int r=sc.nextInt();
			Iterator it=st.iterator();
			Student stu=null;
			while(it.hasNext())
			{
				Student s=(Student)it.next();
				if(r==s.rollNo)
				{
					stu=s;
					System.out.println("Roll No\t\t:"+s.rollNo+"\nName\t\t:"+s.Name+"\nClass\t\t:"+s.Cls+"\nBook Taken\t:"+s.BooksTkn);
				}
			}
			while(u==9)
			{
				System.out.println("Enter the operation needed\t");
				System.out.println("1 to see book list\t");
				System.out.println("2 to borrow the book");
				System.out.println(" 3 to return book");
				System.out.println(" -1 to exit");
				u=sc.nextInt();
				if(u==1)
				{
					System.out.println("Available book are \n");
					Iterator itr=bk.iterator();
					while(itr.hasNext())
					{
						Book b=(Book)itr.next();
						if((int)b.TknBy==0)
							System.out.println("Book No \t\t: "+b.no+"\nBook Name \t\t: "+b.BkName+"\nAuthor name \t\t: +"+b.BkAuthor+"\nBook amount\t\t"+ b.Amt);
					}
					
				}
				if(u==2)
				{
					System.out.println("Enter the book no to borrow");
					int num=sc.nextInt();
					Iterator itr=bk.iterator();
					while(itr.hasNext())
					{
						Book b=(Book)itr.next();
						System.out.println(b.no);
						if(b.no==num)
						{
							if(b.TknBy==0)
							{	
								t=addBooksInfo(b.no,b.BkName,"Issued","17/12/2019","01/01/2020","0");
								int indAl=st.indexOf(stu);
								//System.out.println("index of arraylist "+indAl);
								int indBk=bk.indexOf(b);
								//System.out.println("index of "+indBk);
								//System.out.println("treemp "+ t);
								stu.setBookstkn(t);
								System.out.println("stu  "+stu.Name);
								b.setTknBy(r);
								bk.set(indBk, b);
								st.set(indAl,stu);
								System.out.println("The book number "+b.no+" The Book Name is "+b.BkName+" was issued to "+stu.Name);
							}
							else
							{
							System.out.println("Already taken");
							}
						}
					}
				}
				if(u==3)
				{
					System.out.println("Enter the book no to return");
					int num=sc.nextInt();
					Iterator itr=bk.iterator();
					while(itr.hasNext())
					{
						Book b=(Book)itr.next();
						if(num==b.no)
						{
							int indBk=bk.indexOf(b);
							int indAl=st.indexOf(stu);
							b.setTknBy(0);
							bk.set(indBk, b);
							//stu.setBookstkn("");
							//Traversing the treemap
							Set s=stu.BooksTkn.entrySet();
							Iterator ite= s.iterator();
							while(ite.hasNext())
							{
								Map.Entry me=(Map.Entry)ite.next();
								if((int)me.getKey()==b.no)
								{
									/*LinkedList l=(LinkedList)me.getValue();
							     	Iterator<String> iter=l.iterator();
							     	while(iter.hasNext())
							     	{
							     		System.out.println(iter.next());
							     	}
							     	*/
									TreeMap p=stu.BooksTkn;
									LinkedList<String> ls=(LinkedList)p.remove(b.no);
									System.out.println(ls);
							     	System.out.println("was returned successfully");
								}
							}
									
							st.set(indAl,stu);
							System.out.println("The book named\t\t:"+b.BkName+"\nAuthor\t\t:"+b.BkAuthor+"\nAmount\t\t:"+b.Amt+"\n\t\t was returned by "+stu.rollNo);
						}
					}
				}
				if(u==-1)
				{
					break;
				}
				u=9;
			}
		}
		Jsonconvert(st);
	}
	public static TreeMap<Integer,LinkedList<String>> addBooksInfo(Integer it,String bkName,String status,String IssueDate,String LastDate,String Fees)
	{
		TreeMap<Integer,LinkedList<String>> tm=new TreeMap<Integer,LinkedList<String>>();
		LinkedList<String> bk=new LinkedList<String>();
		bk.add(bkName);
		bk.add(status);
		bk.add(IssueDate);
		bk.add(LastDate);
		bk.add(Fees);
		tm.put(it,bk);
		return tm;
	}
	static void Jsonconvert(LinkedList<Student> hp)
    {
		 GsonBuilder gsonBuilder = new GsonBuilder();
	      Gson gson = gsonBuilder.create();
	      try (FileWriter file = new FileWriter("file1.txt")) 
	      {
				file.write(gson.toJson(hp));
				System.out.println("Successfully copied to file");
	      }
	      catch(Exception e)
	      {
	    	  System.out.println(e);
	      }
				
    }
}
