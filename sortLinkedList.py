class Node:
    def __init__(self, data=None):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None
        self.curr = None 

    def insert(self, data):
        new = Node(data)
        if self.head is None:
            self.head = new
            return
        curr = self.head
        while curr.next and curr.next.data <= data:
            curr = curr.next
        if curr is self.head and new.data < self.head.data:
            new.next = self.head
            self.head = new
        else:
            new.next = curr.next
            curr.next = new
        
    def __iter__(self):
        return self
        
    def __next__(self):
        if self.head and not self.curr:
            self.curr = self.head
            return self.curr.data
        try:
            if self.curr.next:
                self.curr = self.curr.next
                return self.curr.data
        except AttributeError:
            print("list is empty")
            raise StopIteration

            
        else:
            self.curr=None
            raise StopIteration
        

    def __str__(self):
        curr = self.head
        table=[]
        while curr:
            table.append(curr.data)
            curr = curr.next
        return str(table)
    
    def __repr__(self):
        return self.__str__()

    
if __name__ == "__main__": 
    ll = LinkedList()
    ll.insert("Ala")
    print(ll)

    ll.insert("ela")
    print(ll)

    ll.insert("Ela")
    print(ll)

    ll.insert("Kasia")
    print(ll)

    ll.insert("Konrad")
    print(ll)

    ll.insert("konrad")
    print(ll)
    
    ll.insert("Filip")
    print(ll)
    
    ll.insert("filip")
    print(ll)
    
    ll.insert("ala")
    print(ll)

    print("--------------------------")
    
    for i in ll:
        print(i)
        
    print("--------------------------")
        
    kk=LinkedList()
    for i in kk:
        print(i)
        
    
