strictfp class SecondExample{
public  static void main(String arr[]){
int a =Integer.parseInt(arr[0]); // 4 Byte
int b =Integer.parseInt(arr[1]);
float ww = 90.20f;
int c = a + b;
boolean att = true;
String name = "Amit";
String name2 = "Amit";
String name3 = new String("Amit").intern();
System.out.println(name==name2?"Same Ref ":"Not Same Ref ");
System.out.println(name==name3?"Same Ref ":"Not Same Ref ");
System.out.println("योग है "+c);
}
}