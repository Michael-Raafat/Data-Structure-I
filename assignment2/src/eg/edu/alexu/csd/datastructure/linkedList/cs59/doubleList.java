package eg.edu.alexu.csd.datastructure.linkedList.cs59;


import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class doubleList implements ILinkedList {

	 int size = 0;
	    node head ;
		@Override
		public void add(int index, Object element) {
			
			// TODO Auto-generated method stub
			if(element==null)
				return;
			if(index>=size)
				throw new RuntimeException() ;
			
			if (index == 0)
			{
				if(size==0)
				{
					head = new node(null,null,element);
					
				}
				else
				{
					node temp ;
					temp=head;
					head = new node(temp,null,element);
					temp.setprev(head);
				
				}
			}
			else
			{
				node temp = new node(null ,null, element);
				node p = head ;
				for(int i =0 ; i<index-1 ; i++)
				{
					p=p.getnext();
				}
				temp.setnext(p.getnext());
				temp.setprev(p);
				p.setnext(temp);
				temp.getnext().setprev(temp);
			}
			size++;
		}

		@Override
		public void add(Object element) {
			// TODO Auto-generated method stub
			node temp = head ;
			if(element==null)
				return;
			if(size==0)
			{
			 head.setelement(element);
			}
			else
			{
				while(temp.getnext()!= null)
				{
					temp=temp.getnext();
				}
				node q = new node(null,temp,element);
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
			size++;
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
			head= new node(null,null,null);
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
				head.setprev(null);
				temp.setnext(null);
				temp.setprev(null);
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
				temp.getnext().setprev(p);
				temp.setnext(null);
				temp.setprev(null);
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
			doubleList List = new doubleList();
			if(fromIndex>=0 && toIndex<size && toIndex>=fromIndex)
			{
				int i = 0;
				node temp = head ;
				for(i = 0 ; i<fromIndex ; i++)
				{
					temp = temp.getnext();
				}
				List.head=temp;
				node p = head;
				List.size++;
				for(; i< toIndex ; i++)
				{
					List.size++;
					p=p.getnext();
					List.add(p.getele());
				}
				return List;
			}
			else
				throw new RuntimeException();
		
		}

		@Override
		public boolean contains(Object o) {
			// TODO Auto-generated method stub
			node p =head;
			boolean flag=true;
			while(flag && p.getnext()!= null)
			{
				if(p.getele()==o)
				{
					flag=false;
				}
				p=p.getnext();
			}
			return !flag;
		}
}
