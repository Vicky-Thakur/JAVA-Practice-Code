import java.util.Scanner;

public class BinarySearch {
	
	public static int[] array; 
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arrlen = 0;
		System.out.println("Enter length of array " + arrlen);
		array = new int[arrlen];
		for(int i=0;i<arrlen;i++) {
			array[i] = scan.nextInt();
		}	
		
		scan.close();
	}
}
