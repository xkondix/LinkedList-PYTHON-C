package linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class DoublyLinkedList<T> implements Iterable<T> {
	
	Node<T> head;
	Node<T> tail;

	
	class Node<T>
	{
		private T data = null;
		Node<T> next;
		Node<T> prev;
		Node(T data)
		{
			this.data = data;
			this.next=null;
			this.prev=null;
			
		}
		
		public T getData()
		{
			return data;
		}
		
		void setData(T data)
		{
			this.data=data;
		}
		
		
	}
	
	public DoublyLinkedList()
	{
		this.head=null;
		this.tail=null;
	}
	
	@SuppressWarnings("unchecked")
	public String toString()
	{
		Node curr = head;
		List<T> object = new ArrayList<T>();
		
		if(curr == null)
		{
			return "Empty List";
		}
		
		else
		{
			while(curr!=null)
			{
			object.add((T) curr.getData());
			curr = curr.next;
			if(curr==head)
			{
				return  Arrays.toString(object.toArray());
			}
			
			
			}
		}
		
		return  Arrays.toString(object.toArray());
	}
	
	
	public void pushFirst(T value)
	{
		Node element = new Node(value);
		
		if(head==null)
		{
			this.head = element;
		    this.tail = element;
		    head.prev=tail;
		    tail.next=head;
		    return;
		}
		
		Node curr = head;
		element.next=head;
		head.prev=element;
		this.head=element;
		head.prev=tail;
		tail.next = head;
		
	}
	
	
	public void pushEnd(T value)
	{
		Node element = new Node(value);
		
		if(head==null)
		{
			this.head = element;
			this.tail = element;
		    head.prev=tail;
		    tail.next=head;
		}
        
		Node curr = tail;
		element.prev=tail;
        tail.next=element;
        this.tail=element;
        tail.next=head;
        head.prev=tail;
	}
	
	public T popFirst() throws EmptyListException 
	{
        if(head == null)
        {
        	throw new EmptyListException("EmptyList");
        }
        else if(tail==head)
        {
            T val = head.getData();
            this.head=null;
            this.tail=null;
            return val;
        }
        
        T val = head.getData();
        Node curr = head.next;
        this.head = curr;
        head.prev=tail;
        tail.next =head;
        return val;
	}
	
	public T popEnd() throws EmptyListException  
	{
        if(head == null)
        {
        	throw new EmptyListException("EmptyList");
        }
        else if(tail==head)
        {
            T val = head.getData();
            this.head=null;
            this.tail=null;
            return val;
        }
        
        T val = tail.getData();
        Node curr = tail.prev;
        this.tail = curr;
        tail.next=head;
        head.prev = tail;
        return val;
	}
	
	
	public T deleteByIndex(int id) throws EmptyListException
	{
		int counter = 0;
		
		if(this.head == null)
        {
        	throw new EmptyListException("EmptyList");
        }
		
		else if(id == counter)
	    {
	         return this.popFirst();
	    }
		else
		{
		 Node curr = head.next;
		 while(curr!=head)
		 {
			 counter++;
			 if(id==counter)
			 {
				 if(curr==tail)
	              {
	                  return popEnd();
	              }
				 else
				 {
				 T val = (T) curr.getData();
		         Node prevNode=curr.prev;
		         Node nextNode=curr.next;
		         prevNode.next=nextNode;
		         nextNode.prev=prevNode;
		         return val; 
				 }
			 }
			 curr = curr.next;
		 }
		}
		 
		 throw new IndexOutOfBoundsException("index max = "+counter+" your index is "+id); 
	}
	
	
	public void insertByIndex(int id, T value) throws EmptyListException
	{
		Node element = new Node(value);
		int counter = 0;
		
		if(head==null)
		{
			this.head = element;
			this.tail = element;
		    head.prev=tail;
		    tail.next=head;
		    return;
		}
		
		else if(id == counter)
		{
	        this.pushFirst(value);
			return;   
	    }
		else
		{
		 Node curr = head.next;
		 counter++;
		 while(curr!=head)
		 {
			
			 if(id==counter)
			 {
				 
				
				Node prevNode = curr.prev;
				prevNode.next=element;
				element.prev=prevNode;
				curr.prev=element;
				element.next=curr;
		        return; 
				 
			 }
			 counter++;
			 curr = curr.next;
		 }
		}
		
		if(counter==id)
		{
			pushEnd(value);
			return;
		}
		else
		{
		 throw new IndexOutOfBoundsException("index max = "+counter+" your index is "+id); 
		}
		 
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>()
				{
				int counter = 0;
				Node curr=head;
					public boolean hasNext()
					{
						if(curr==head)
						{
							counter++;
						}
						
						return counter<=1;
					}
					
					public T next()
					{
						T val = (T) curr.getData();
						curr=curr.next;
						return (T) val;
					}
					
					public void remove()
					{
						throw new UnsupportedOperationException();
					}
				};
	}
	
	
	public static void main(String[] args) throws EmptyListException
	{
		DoublyLinkedList<String> l = new DoublyLinkedList<String>();
		
		
		//pushEnd()
		System.out.println("pushEnd()");
		l.pushEnd("ala");
		l.pushEnd("ma");
		l.pushEnd("kota");
		l.pushEnd("nie");
		System.out.println(l);
		//popEnd()
		System.out.println("-----------------------------------");
		System.out.println("popEnd()");
		for(int i = 3; i>=0;i--)
		{
			l.popEnd();
			System.out.println(l);

		}
		//pushFirst()
		System.out.println("-----------------------------------");
		System.out.println("pushFirst()");
		l.pushFirst("ala");
		l.pushFirst("ma");
		l.pushFirst("kota");
		l.pushFirst("nie");
		System.out.println(l);
		//popFirst()
		System.out.println("-----------------------------------");
		System.out.println("popFirst()");
		for(int i = 0; i<4;i++)
		{
			l.popFirst();
		}
		System.out.println(l);
		//insertByIndex()
		System.out.println("-----------------------------------");
		System.out.println("insertByIndex()");
		l.insertByIndex(0, "ala");
		l.insertByIndex(1, "kota");
		l.insertByIndex(1, "ma");
		l.insertByIndex(3, "nie");
		System.out.println(l);
		//deleteByIndex()
		System.out.println("-----------------------------------");
		System.out.println("deleteByIndex()");
		l.deleteByIndex(0);
		System.out.println(l);
		l.deleteByIndex(2);
		System.out.println(l);
		l.deleteByIndex(1);
		System.out.println(l);
		l.deleteByIndex(0);
		System.out.println(l);
		//iterator test
		DoublyLinkedList<Integer> k = new DoublyLinkedList<Integer>();
		
		k.pushFirst(1);
		k.pushFirst(2);
		k.pushFirst(3);
		k.pushFirst(4);
		
		for( Integer s : k)
		{
			System.out.print(s+" ");
		}


	}

	

}

class EmptyListException extends Exception {
    public EmptyListException(String message) {
        super(message);
    }
}
