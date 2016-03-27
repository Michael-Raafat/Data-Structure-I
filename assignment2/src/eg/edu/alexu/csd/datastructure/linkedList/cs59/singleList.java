package eg.edu.alexu.csd.datastructure.linkedList.cs59;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class singleList implements ILinkedList {
    private int size = 0;
    private node head =new node();
	@Override
	public void add(int index, Object element) {
		
		// TODO Auto-generated method stub
		if(element.equals(null))
			throw new RuntimeException("ERROR");
		if(index>size)
			throw new RuntimeException("ERROR") ;
		if (index == 0)
		{
			if(size==0)
			{
				head = new node(null,element);
				
			}
			else
			{
				node temp ;
				temp=head;
				head = new node(temp,element);
			
			}
		}
		else
		{
			node temp = new node(null , element);
			node p = head ;
			for(int i =0 ; i<index-1 ; i++)
			{
				p=p.getnext();
			}
			temp.setnext(p.getnext());
			p.setnext(temp);
		}
		size++;
	}

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		node temp = head ;
		if(element.equals(null))
			throw new RuntimeException("ERROR");
		if(size==0)
		{
			node p = new node(null,element);
			head=p;
		}
		else
		{
			while(temp.getnext()!= null)
			{
				temp=temp.getnext();
			}
			node q = new node(null,element);
			temp.setnext(q);
		}
		size++;
	}
	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		if(index>=size)
		{
			throw new RuntimeException();
		}
		node temp = head;
		int i=0;
		while( i < index )
		{
			temp=temp.getnext();
			i++;
		}
		return temp.getele();
	}

	@Override
	public void set(int index, Object element) {
		// TODO Auto-generated method stub
		if(index>=size && size !=0)
			throw new RuntimeException() ;
		if (index == 0)
		{
				head.setelement(element);
		}
		else
		{
			node p = head ;
			for(int i =0 ; i<index ; i++)
			{
				p=p.getnext();
			}
			p.setelement(element);	
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head= new node(null,null);
		size=0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(size==0)
			return true;
		return false;
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		if(index>=size)
			throw new RuntimeException();
		node temp ;
		if(index==0)
		{
			temp = head;
			head=head.getnext();
			temp.setnext(null);
		}
		else
		{
			int i = 0 ;
			temp=head;
			while(i<index-1)
			{
				temp = temp.getnext();
				i++;
			}
			node p ;
			p = temp ;
			temp=temp.getnext();
			p.setnext(temp.getnext());
			temp.setnext(null);
		}
		size--;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		if(fromIndex <0 || toIndex>=size || fromIndex>toIndex || size==0)
		{
			throw new RuntimeException();
		}
		node m =head;
		for(int i=1;i<=fromIndex;i++)
		{
			m = m.getnext();
		}
		singleList dd = new singleList();
		dd.add(m.getele());
		for(int i=fromIndex;i<toIndex;i++)
		{
			m=m.getnext();
			dd.add(m.getele());
		}
		return dd;
	
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		node p =head;
		boolean flag=true;
		if(p.getele().equals(o))
		{
			flag=false;
		}
		while(flag && p.getnext()!= null)
		{	
			p=p.getnext();
			if(p.getele().equals(o))
			{
				flag=false;
			}
			
		}
		return !flag;
	}

}
