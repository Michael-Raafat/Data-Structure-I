package eg.edu.alexu.csd.datastructure.linkedList.cs59;

public class node {

	private Object element ;
	private node next,prev;
	public node(node there,Object here)
	{
		this.element=here;
		this.next=there;
	}
	public node(node there,node thiss,Object here)
	{
		this.element=here;
		this.next=there;
		this.prev=thiss;
	}
	public void setelement(Object here)
	{
		this.element = here ;
	}
	public void setnext(node there)
	{
		this.next =  there;
	}
	public void setprev(node there)
	{
		this.prev =  there;
	}
	public Object getele()
	{
		return this.element;
	}
	public node getnext()
	{
		return this.next;
	}
	public node getprev()
	{
		return this.prev;
	}
}
