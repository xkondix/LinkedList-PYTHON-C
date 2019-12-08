package linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoublyLinkedList<T> {
	
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
			System.out.println("Empty List");
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
			head = element;
		    tail = element;
		    head.prev=tail;
		    tail.next=head;
		    return;
		}
		
		Node curr = head;
		element.next=head;
		head.prev=element;
		head=element;
		head.prev=tail;
		tail.next = head;
		
	}
	
	
	public void pushEnd(T value)
	{
		Node element = new Node(value);
		
		if(head==null)
		{
			head = element;
		    tail = element;
		    head.prev=tail;
		    tail.next=head;
		}
        
		Node curr = tail;
		element.prev=tail;
        tail.next=element;
        tail=element;
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
        this.head.prev=this.tail;
        this.tail.next = this.head;
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
        this.tail.next=this.head;
        this.head.prev = this.tail;
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
		 Node curr = this.head.next;
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
			head = element;
		    tail = element;
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
		 Node curr = this.head.next;
		 while(curr!=head)
		 {
			 counter++;
			 if(id==counter)
			 {
				 if(curr==tail)
	              {
					  pushEnd(value);
	                  return;
	              }
				 else
				 {
				 Node prevNode = curr.prev;
				 prevNode.next=element;
				 element.prev=prevNode;
				 curr.prev=element;
				 element.next=curr;
		         return; 
				 }
			 }
			 curr = curr.next;
		 }
		}
		
		 throw new IndexOutOfBoundsException("index max = "+counter+" your index is "+id); 
		 
	}
	
	
	public static void main(String[] args) throws EmptyListException
	{
		DoublyLinkedList l = new DoublyLinkedList();
		l.pushFirst("ala");
		l.pushFirst("ma");
		l.pushFirst("Kota");
		l.pushEnd("xd");
		System.out.println(l);
		l.popEnd();
		l.popFirst();
		System.out.println(l);
		l.popEnd();
		l.popFirst();
		System.out.println(l);
		//l.popStart();
		l.pushEnd("ala");
		l.pushEnd("ma");
		l.pushEnd("Kota");
		System.out.println(l);
		l.deleteByIndex(2);
		System.out.println(l);
		l.pushEnd("Kota");
		System.out.println(l);
		l.insertByIndex(0, "nr 0");
		l.insertByIndex(3, "nr 3");
		l.insertByIndex(2, "nr 1");
		System.out.println(l);
		for(int i = 5; i>=0; i--)
		{
			l.deleteByIndex(i);
			System.out.println(l);

		}



		





	}

}

class EmptyListException extends Exception {
    public EmptyListException(String message) {
        super(message);
    }
}
