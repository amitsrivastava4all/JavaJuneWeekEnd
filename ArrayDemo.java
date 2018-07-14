//import java.lang.*;
import java.util.ArrayList;
class Post{
String name;
//Date date;
int likes;

}
class ArrayDemo{
public static void main(String args[]){
ArrayList l = new ArrayList();
l.add(90);
l.add(100);
l.add(0,1000);
l.remove(1);
System.out.println(l);

//int arr[][] = new int[3][3];
//int []arr[] = new int[3][3];
//int [][]arr = new int[3][3];
int [][] arr = {{10,20,30,40},{90,100,1,32,3,5,66},{111,222}};
//int [][]arr = new int[3][];
/*arr[0] = new int[10];
arr[1] =new int[20];
arr[2] = new int[30];
arr[0][1]=1;
arr[1][11]=1;
arr[2][20]=1;*/
for(int a[]:arr){
for(int b:a){
System.out.print(b+" ");

}
System.out.println("");
}
/*
for(int i = 0; i<arr.length; i++){
for(int j = 0 ; j<arr[i].length; j++){
System.out.print(arr[i][j]+" ");

}
System.out.println("");
}*/

//Post posts[] = {new Post(),new Post()}
int y[] = new int[5];
//int y[] = {10,20,30,40,50,90,100};
// Enhance For Loop Java 5
for(int z : y){
System.out.println(z);
}

/*for(int i = 0; i<y.length; i++){
System.out.println(y[i]);
}*/
//int [] y = {10,20,30,40,50};
//int y[] = new int[]{10,20,30,40,50};
//int y [] = new int[5];
Integer x;  // 4 Byte
//long y = 1000L; //8 Byte  long y = (int)1000;
String name = "Amit";
System.out.println("Name is "+name.length());
System.out.println("Name is "+name.toUpperCase());
System.out.println("Name is "+name.indexOf('m'));

// char name[] = {'A','m','i','t'};

}
}