class Node:
    def __init__(self, data=None):
        self.data = data
        self.next = None
        self.prev = None


class LinkedList:
    def __init__(self):
        self.head = None
        self.curr = None 
        self.tail = None

        
    def addEnd(self,data):
        new = Node(data)
        if self.head is None:
            self.head = new
            self.tail= new
            self.head.prev=self.tail
            self.tail.next=self.head
        
        curr = self.tail
        new.prev=self.tail
        self.tail.next=new
        self.tail=new
        self.tail.next=self.head
        self.head.prev=self.tail
        
        
    def addStart(self,data):
        new = Node(data)
        if self.head is None:
            self.head = new
            self.tail= new
            self.head.prev=self.tail
            self.tail.next=self.head
        
        curr = self.head
        new.next=self.head
        self.head.prev=new
        self.head=new
        self.head.prev=self.tail
        self.tail.next = self.head
        
        
    def popStart(self):
        if self.head is None:
            raise IndexError("list is empty")
        
        curr = self.head.next
        self.head = curr
        self.head.prev=self.tail
        self.tail.next = self.head
        
    def popEnd(self):
        if self.head is None:
            raise IndexError("list is empty")
        
        curr = self.tail.prev
        self.tail = curr
        self.tail.next=self.head
        self.head.prev = self.tail
        
        

    def insert(self,data,i):
        new = Node(data)
        counter = 0
        if self.head is None:
            self.head = new
            self.tail= new
            self.head.prev=self.tail
            self.tail.next=self.head
            return
        
        curr = self.head
        while curr.next!=self.head and counter < i:
            curr = curr.next
            counter+=1
        if curr is self.head:
            self.addStart(data)
        elif curr is self.tail:
            self.addEnd(data)
        else:
            prevNode = curr.prev
            prevNode.next=new
            new.prev=prevNode
            curr.prev=new
            new.next=curr
            
            
    def delete(self,i):
        counter = 0
        if self.head is None:
            raise IndexError("list is empty")
        
        curr = self.head
        while curr.next!=self.head and counter < i:
            curr = curr.next
            counter+=1
        if curr is self.head:
            self.popStart()
        elif curr is self.tail:
            self.popEnd()
        else:
            prevNode=curr.prev
            nextNode=curr.next
            prevNode.next=nextNode
            nextNode.prev=prevNode
            
    def __iter__(self):
        return self
        
    def __next__(self):
        if self.head and not self.curr:
            self.curr = self.head
            return self.curr.data
        try:
            if self.curr.next!=self.head:
                self.curr = self.curr.next
                return self.curr.data
        except AttributeError:
            raise StopIteration("list is empty")

            
        else:
            self.curr=None
            raise StopIteration
        

    def __str__(self):
        curr = self.head
        table=[]
        while curr:
            #print(curr.prev.data,curr.data,curr.next.data)
            table.append(curr.data)
            curr = curr.next
            if curr == self.head:
                return str(table)

                
    
    def __repr__(self):
        return self.__str__()


if __name__ == "__main__": 
    s = LinkedList()
    s.addEnd(1)
    print(s)

    s.addEnd(2)
    print(s)

    s.addEnd(3)
    print(s)

    s.addStart(4)
    print(s)

    s.addStart(5)
    print(s)

    s.addStart(6)
    print(s)
    
    s.insert(22,1)
    print(s)
    
    s.delete(6)
    print(s)
    
    s.popStart()
    print(s)
    
    s.popStart()
    print(s)
    
    s.popEnd()
    print(s)

    print("--------------------------")
    
    for i in s:
        print(i)
        
    print("--------------------------")
        
#     kk=LinkedList()
#     for i in kk:
#         print(i)
        
#     print("--------------------------")
        
#     m=LinkedList()
#     m.popEnd()
    
    
#     print("--------------------------")
        
#     m=LinkedList()
#     m.popStart()
    
        
    
