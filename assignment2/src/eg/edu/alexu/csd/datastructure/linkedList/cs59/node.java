package eg.edu.alexu.csd.datastructure.linkedList.cs59;

public class node {

	private Object element ;
	private node next,prev;
	node(node there,Object here)
	{
		this.element=here;
		this.next=there;
	}
	node(node there,node thiss,Object here)
	{
		this.element=here;
		this.next=there;
		this.prev=thiss;
	}
	void setelement(Object here)
	{
		this.element = here ;
	}
	void setnext(node there)
	{
		this.next =  there;
	}
	void setprev(node there)
	{
		this.prev =  there;
	}
	Object getele()
	{
		return this.element;
	}
	node getnext()
	{
		return this.next;
	}
	node getprev()
	{
		return this.prev;
	}
}
