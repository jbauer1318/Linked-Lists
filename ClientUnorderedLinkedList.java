import java.util.*;
public class ClientUnorderedLinkedList {
public static void main(String[] args) {
Scanner input = new Scanner(System.in);
UnorderedLinkedList<Integer> intList = new UnorderedLinkedList<Integer>();
UnorderedLinkedList<Integer> tempList;
int num;
System.out.println("Enter integers (999 to stop)");
num = input.nextInt();//valid??
while (num != 999) {
intList.insertLast((Integer) num);
num = input.nextInt();//valid??
}
System.out.print("Testing linearSearch. Enter the number to search for/list:");
num = input.nextInt(); //valid??
if (intList.linearSearch(num))
System.out.println(num + " found in this list by linearSearch.");
else
System.out.println(num + " is not in this list by linearSearch.");
tempList = inList.clone();
System.out.println("Testing bubbleSort. Sorted list is: ");
inList.bubbleSort();
inList.print();
System.out.println("Testing selectionSort. Sorted list is: ");
tempList.selectionSort();
tempList.print();
if (intList.binarySearch(num))
System.out.println(num + " found in this list by binarySearch.");
else
System.out.println(num + " is not in this list by binarySearch.");
//Optional: add more testing here
} // add methods for input validation
}