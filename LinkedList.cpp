#include <iostream>
using namespace std;


template <class T> class Node
	{
		private:
        T data = NULL;

        public:
		Node<T> * next;
		Node<T> * prev;


		Node<T>(){}

		Node<T>(const T &data)
		{
			this->data = data;
			this->next=NULL;
			this->prev=NULL;

		}



        T getData()
		{
			return data;
		}

		void setData(const T &data)
		{
			this->data=data;
		}
    };


template <class T> class LinkedList {


	public:

	Node<T>* head;
	Node<T>* tail;

	LinkedList()
	{
        this->head=NULL;
        this->tail=NULL;
	}

/**********************************************************/


    void print() {
      Node<T> *curr = this->head;

      if(curr == NULL){
        printf("Empty List\n");
        return;
      }

      while (curr != NULL) {
        printf("%d ", curr->getData());
        curr = curr->next;
      }
      printf("\n");
    }

    /**********************************************************/

    void pushEnd(const T &value) {

      Node<T>* element = new Node<T>;


        element->setData(value);
        element->next = NULL;

        if (this->tail == NULL){
            this->head = element;
            this->tail = element;
	    this->head->next = NULL;
	    this->tail->prev = NULL;
            return;
        }

        element->prev=this->tail;
	this->tail->next = element;
	this->tail = element;
	this->tail->next = NULL;

    }

/**********************************************************/

   void pushFirst(const T &value) {

      Node<T>* element = new Node<T>;


        element->setData(value);
        element->next = NULL;

        if (this->head == NULL){
            this->head = element;
            this->tail = element;
	    this->head->next = NULL;
	    this->tail->prev = NULL;
            return;
        }

        element->next = this->head;
	this->head->prev = element;
	this->head = element;
	this->head->prev = NULL;

    }

/**********************************************************/

   T popFirst() 
	{
        if(this->head == NULL)
        {
        	return NULL;
        }
        else if(this->tail==this->head)
        {
            T val = this->head->getData();
            this->head=NULL;
            this->tail=NULL;
            return val;
        }
        
        T val = this->head->getData();
        Node<T>* curr = this->head->next;
	free(this->head);
        this->head = curr;
	this->head->prev = NULL;
        return val;
	}

/**********************************************************/

   T popEnd() 
	{
        if(this->head == NULL)
        {
        	return NULL;
        }
        else if(this->tail==this->head)
        {
            T val = this->head->getData();
            this->head=NULL;
            this->tail=NULL;
            return val;
        }
        
        T val = this->tail->getData();
        Node<T>* curr = this->tail->prev;
	free(this->tail);
        this->tail = curr;
	this->tail->next = NULL;
        return val;
	}
	
   



	};

int main()
{

LinkedList<int> snakeGame;
snakeGame.pushEnd(21);
snakeGame.pushEnd(1);
snakeGame.pushEnd(44);
snakeGame.pushEnd(33);
snakeGame.pushFirst(99);
snakeGame.print();
snakeGame.popFirst();
snakeGame.print();
snakeGame.popEnd();
snakeGame.print();
snakeGame.popEnd();
snakeGame.print();
snakeGame.popEnd();
snakeGame.print();
snakeGame.popEnd();
snakeGame.print();



return 0;
}
