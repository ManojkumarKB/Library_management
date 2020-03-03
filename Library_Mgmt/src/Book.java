import java.util.Comparator;

public class Book {
	int no;
	String BkName;
	String BkAuthor;
	int Amt;
	int TknBy;
	Book(int no,String Name,String Author,int Amount,int TknBy)
	{
		this.no=no;
		this.BkName=Name;
		this.BkAuthor=Author;
		this.Amt=Amount;
		this.TknBy=TknBy;
	}
	public void setTknBy(int roll)
	{
		this.TknBy=roll;
	}
}
class SortByNo implements Comparator<Book>
{
	public int compare(Book a, Book b) 
	{ 
		return a.no - b.no; 
	} 
}
