import java.util.Scanner;
class ScannerAnotherUse{
public static void main(String args[]){
String line  = "Hello How are You\n I am Fine\n Thank You ";
Scanner scanner = new Scanner(line);
int wordCounter = 0;
while(scanner.hasNext()){
String word = scanner.next();
wordCounter++;
System.out.println("Word "+word);
}
System.out.println("Total Words are "+wordCounter);
System.out.println("****************************************");
 scanner = new Scanner(line);
int lineCounter = 0;
while(scanner.hasNextLine()){
String currentLine = scanner.nextLine();
lineCounter++;
System.out.println("Line is  "+currentLine);
}
System.out.println("Total Lines are "+lineCounter);
scanner.close();
}
}