import java.util.Comparator;
import java.util.TreeMap;
import java.util.LinkedList;
class Student 
{
	int rollNo,FeesBalance;
	String Name,Cls;
	TreeMap BooksTkn;
	Student (int rollNo,String Name,String Cls,TreeMap BooksTkn,int FeesBalance)
	{
		this.rollNo=rollNo;
		this.Name=Name;
		this.Cls=Cls;
		this.BooksTkn=BooksTkn;
		this.FeesBalance=FeesBalance;
	}
	public void setBookstkn(TreeMap<Integer,LinkedList<String>> t)
	{
		this.BooksTkn=t;
	}
	
}
class Sortbyroll implements Comparator<Student>
	{ 
	    public int compare(Student a, Student b) 
	    { 
	        return a.rollNo - b.rollNo; 
	    } 
	} 
