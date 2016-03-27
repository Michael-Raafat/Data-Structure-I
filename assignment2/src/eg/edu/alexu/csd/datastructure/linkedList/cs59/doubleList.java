package eg.edu.alexu.csd.datastructure.linkedList.cs59;


import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class doubleList implements ILinkedList {

	private node head,dumtail ;
	private int size;
	public doubleList()
	{
		head=new node(dumtail,null,null);
		size=0;
		dumtail = new node(null,head,null);
	}
	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		if(element.equals(null))
			throw new RuntimeException();
		if(index==0 && size ==0)
		{
			node U = new node(dumtail,null,element);
			head=U;
			size++;
		}
		else if(index<0 || index > size)
		{
			throw new RuntimeException();
		}
		else if(index<=size)
		{
			node s = head;
			
			for(int i=1;i<index;i++)
			{
				s=s.getnext();
			}
			node x=s.getnext();
			node m= new node(x,s,element);
			x.setprev(m);
			s.setnext(m);
			size++;
		}
	}

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		if(element.equals(null))
			throw new RuntimeException();
		if(size==0)
		{
			head.setelement(element);
		}
		else
		{
			node f = new node(dumtail,element);
			node x = dumtail.getprev();
			x.setnext(f);
			f.setprev(x);
			dumtail.setprev(f);
		}
		size++;
		
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		if(index <0 || index>=size)
		{
			throw new RuntimeException();
		}
		node m = head;
		for(int i=1;i<=index;i++)
		{
			m = m.getnext();
		}
		return m.getele();
	}

	@Override
	public void set(int index, Object element) {
		// TODO Auto-generated method stub
		if(index <0 || index>=size)
		{
			throw new RuntimeException();
		}
		node m = head;
		for(int i=1;i<=index;i++)
		{
			m = m.getnext();
		}
		m.setelement(element);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head=new node(dumtail,null,null);
		size=0;
		dumtail = new node(null,head,null);
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
		if(size<1 || index <0 || index >=size)
		{
			throw new RuntimeException();
		}
		node m =head;
		if(size==1)
		{
			this.clear();
			return;
		}
		else if(index==0)
		{
			node n = head.getnext();
			head=n;
			head.setprev(null);
			size--;
			return;
		}
		for(int i=1;i<=index;i++)
		{
			m = m.getnext();
		}
		node p = m.getprev();
		node n = m.getnext();
		m.setnext(null);
		m.setprev(null);
		p.setnext(n);
		n.setprev(p);
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
		doubleList dd = new doubleList();
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
		boolean found = false;
		if(size==0 || o.equals(null))
			return found;
		node z = head;
		if (z.getele().equals(o))
			found=true;
		while(z.getnext()!=dumtail && !found)
		{
			z=z.getnext();
			if (z.getele().equals(o))
				found=true;
		}
		return found;
	}

	}
