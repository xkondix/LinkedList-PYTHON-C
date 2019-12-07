#include <stdio.h>
#include <stdlib.h>
#define memoryExit -1

typedef struct node {
  int data;
  struct node *next;
  struct node *prev;
} Node;

Node *head = NULL;
Node *tail = NULL;



/**********************************************************/

void cout() {
  Node *curr = head;

  if(curr == NULL){
    printf("Empty List\n");
    return;
  }

  while (curr) {
    printf("%d ", curr->data);
    curr = curr->next;
    if(curr == head)
    {
        return;
    }
  }
}

/**********************************************************/

void pushEnd(int value) {

  Node* element;

  if( (element = (Node*)malloc(sizeof(Node))) == NULL ) {
    fprintf(stderr, "To small memory\n");
    exit(memoryExit);
  }
    element->data = value;


    if (head == NULL){

        element->next = head;
        element->prev = tail;
        head = element;
        tail = element;

        return;
    }



    element -> next = head;
    element->prev = tail;
    tail->next = element;
    head->prev = element;
    tail = element;

}

/**********************************************************/


void pushFirst(int value) {

  Node* element;

  if( (element = (Node*)malloc(sizeof(Node))) == NULL ) {
    fprintf(stderr, "To small memory\n");
    exit(memoryExit);
  }
    element->data = value;


    if (head == NULL){

        element->next = head;
        element->prev = tail;
        head = element;
        tail = element;

        return;
    }



    element -> next = head;
    element->prev = tail;
    tail->next = element;
    head->prev = element;
    head = element;


}

/**********************************************************/

int popEnd(){//zroc wartosc z ostatniego elementu i usun ostatni element
  int defaultVaule = -1;

  if(head == NULL || tail == NULL){
    printf("Empty List\n");
    return defaultVaule;
  }



  if(head==tail)
  {
        int val = tail->data;
        head = NULL;
        tail = NULL;
        return val;
  }

  int val = tail->data;
  head->prev = tail->prev;
  tail->prev->next = head;
  free(tail);
  tail = head->prev;
  return val;


}

/**********************************************************/

int popFirst(){//zroc wartosc z ostatniego elementu i usun ostatni element
  int defaultVaule = -1;

  if(head == NULL || tail == NULL){
    printf("Empty List\n");
    return defaultVaule;
  }

  if(head==tail)
  {
        int val = tail->data;
        head = NULL;
        tail = NULL;
        return val;
  }

  int val = head->data;
  tail->next = head->next;
  head->next->prev = tail;
  free(head);
  head = tail->next;
  return val;


}

/**********************************************************/

int deleteIndx(int indx){
  int defaultVaule = -1;
  int counter = 0;

  if(head == NULL || tail == NULL){
    printf("Empty List\n");
    return defaultVaule;
  }
  else if(indx==counter)
  {
  int val = tail->data;
  head = NULL;
  tail = NULL;
  return val;
  }
  else
  {
      Node *curr = head->next;
      while(curr!=head)
      {
          counter++;
          if(indx==counter)
          {
              if(curr==tail)
              {
                  free(curr);
                  return popEnd();
              }
              else{
              int val = curr -> data;
              curr -> prev -> next = curr -> next;
              curr -> next -> prev = curr -> prev;
              free(curr);
              return val;
              }
          }
          curr = curr -> next;

      }
  }

  return defaultVaule;

}

/**********************************************************/

void insertIndx(int value,int indx){
  Node* element;
  int counter = 0;


  if( (element = (Node*)malloc(sizeof(Node))) == NULL ) {
    fprintf(stderr, "To small memory\n");
    exit(memoryExit);
  }
    element->data = value;


  if (head == NULL){
    element->next = head;
    element->prev = tail;
    head = element;
    tail = element;
    return;
    }
  else if(indx==counter)
  {
   free(element);
   return pushFirst(value);
  }
  else
  {
      Node *curr = head->next;
      while(curr!=head)
      {
          counter++;
          if(indx==counter)
          {
              if(curr==tail)
              {
                  free(element);
                  free(curr);
                  return popEnd(value);
              }
              else{
              element -> next = curr;
              element -> prev = curr -> prev;
              curr -> prev -> next = element;
              curr -> prev = element;
              return;
              }
          }
          curr = curr -> next;

      }
  }


}

/**********************************************************/

int main()
{

    for(int i = 0; i<5; i++)
    {
        pushEnd(i);
        cout();
        printf("\n");
    }

    insertIndx(2,1);
    cout();
    printf("\n");

    insertIndx(22,1);
    cout();
    printf("\n");

    deleteIndx(1);
    cout();
    printf("\n");

    deleteIndx(1);
    cout();
    printf("\n");



    return 0;
}

