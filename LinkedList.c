#include <stdio.h>
#include <stdlib.h>
#define memoryExit -1

typedef struct node {
  int data;
  struct node *next;
} Node;

Node *head = NULL;



/**********************************************************/

void cout() {
  Node *curr = head;

  if(curr == NULL){
    printf("Empty List\n");
    return;
  }

  while (curr != NULL) {
    printf("%d ", curr->data);
    curr = curr->next;
  }
  printf("\n");
}

/**********************************************************/

void pushEnd(int value) {

  Node* element;
  Node* curr = head;

  if( (element = (Node*)malloc(sizeof(Node))) == NULL ) {
    fprintf(stderr, "To small memory\n");
    exit(memoryExit);
  }
    element->data = value;
    element->next = NULL;

    if (curr == NULL){
        free(curr);
        head = element;
        return;
    }

    while (curr->next != NULL){
        curr = curr->next;
 }

    curr->next = element;

}

/**********************************************************/

void pushFirst(int value) {

  Node* element;

  if( (element = (Node*)malloc(sizeof(Node))) == NULL ) {
    fprintf(stderr, "To small memory\n");
    exit(memoryExit);
  }

    if (head == NULL){
        head = element;
        head->data = value;
        head->next = NULL;
        return;
    }


  element -> next = head;
  element->data = value;
  head = element;
}

/**********************************************************/


int popFirst() {
  int defaultValue = -1;
  Node *buffor = NULL;

  if (head == NULL) {
     printf("Empty List\n");
     return defaultValue;
  }

  int val = head->data;
  buffor = head;
  head = head->next;
  free(buffor);
  return val;
}

/**********************************************************/

int popEnd(){
  Node *curr = head;
  int defaultValue = -1;

  if(curr == NULL){
    printf("Empty List\n");
    return defaultValue;

  }

  if(curr->next==NULL)
  {
        int val = curr->data;
        free(curr);
        head = NULL;
        return val;
  }

  while (curr != NULL) {
    if(curr->next->next == NULL){
        int val = curr->next->data;
        free(curr->next);
        curr->next=NULL;
        return val;

    }
    curr = curr->next;
}


return defaultValue;


}

/**********************************************************/

int deleteIndx(int indx){
  int defaultValue = -1;
  int counter = 0;

  if(head == NULL){
    printf("Empty List\n");
    return defaultValue;
  }

  else if(counter==indx)
 {
   return popFirst();
 }
 else if(indx==1)
  {
   Node * buffor = head->next->next;
   free(head->next);
   head->next=buffor;
   return;
  }

  else{
      Node *curr = head->next;
      while(curr!=NULL)
      {
          counter++;
          if(indx-1==counter)
          {
              if(curr->next==NULL)
              {
                  if(indx+1>counter)
                  {
                      return;
                  }
                  return popEnd();
              }
              else{
              int val = curr->next->data;
              Node * buffor = curr->next->next;
              free(curr->next);
              curr->next=buffor;
              return val;
              }
          }
          curr = curr -> next;

      }
  }

  return defaultValue;

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


  if (head == NULL)
    {
    head = element;
    head->data = value;
    head->next = NULL;
    return;
    }
  else if(indx==counter)
  {
   free(element);
   return pushFirst(value);
  }
  else if(indx==1)
  {
   element->next = head->next;
   head->next = element;
   return;
  }
  else
  {
      Node *curr = head->next;
      while(curr!=NULL)
      {
          counter++;
          if(indx-1==counter)
          {
              if(curr->next==NULL)
              {
                  free(element);
                  return pushEnd(value);
              }
              else{
              element -> next = curr->next;
              curr -> next = element;
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
     pushFirst(2);
    pushFirst(3);
    pushFirst(4);
    pushFirst(53);
    pushEnd(22);
    cout();



    printf("\n");
    deleteIndx(4);
    cout();

    printf("\n");
    deleteIndx(0);
    cout();

    printf("\n");
    deleteIndx(5);
    cout();

    printf("\n");
    deleteIndx(2);
    cout();

    printf("\n");
    deleteIndx(2);
    cout();

    printf("\n");
    deleteIndx(0);

    cout();

    printf("\n");
    deleteIndx(0);
    cout();

    printf("\n");
    insertIndx(1,0);
    cout();

    printf("\n");
    insertIndx(2,0);
    cout();

    printf("\n");
    insertIndx(3,0);
    cout();

    printf("\n");
    insertIndx(4,2);
    cout();

    printf("\n");
    insertIndx(5,1);
    cout();

    printf("\n");
    insertIndx(111,22);
    cout();




    return 0;
}

