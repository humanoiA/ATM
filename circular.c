#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

#define MAX 5
int f=-1;
int r=-1;
int max=-1;
int q[MAX];
void insert( );
void deleted();
void display();
 main()
{
 int n;
while(1)
{

 printf(" press 1 to insert \n press 2 to delete \n press 3 to display \n press 4 to exit\n\n\n");
 scanf("%d",&n);
 switch(n)
 { case 1:insert();
  break;
  case 2:deleted();
  break;
  case 3:display();
  break;
  case4:exit(0);
  break;
 }
}
}void insert()

{
 if(f==r+1||f==0&&r==max-1)
 {
 
 printf("over flow");
return;
}
if(f==-1)
{
	f=0;
}
r=r+1;
printf("enter the value ");
scanf("%d",&q[r]);
}
void deleted()
{

int item;
{ if(f==-1 ) 
{
printf("under flow");	

return;
}
item=q[f];
if(f=max-1)
{ f=0;
}
if (f==r)
{ f=-1;
r=-1;
}
else 
{ f=f+1;
}
printf("%d is deleted element ",item);
}
}
 
 /*void display()
 { 
  int j;
  printf(" elements present in the queue");
  if(f==-1)
  {
  
  printf("underflow");
  return;
}
if(f<=r)
{
 for(j=f;j<=r;j++)
{
 printf("%d",q[j]);
}
}
else
{

for(j=f;j<max-1;j++)
{

printf(" %d",q[j]);
}

for(j=0;j<=r;j++)
{

 printf(" \n %d",q[j]);
  }
}*/

