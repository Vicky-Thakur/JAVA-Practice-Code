import java.util.Scanner;

public class LinearSearch {
	
	public static int[] array; 
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arrlen = 0;
		int status = 0;
		try {
			do {
				System.out.println("Enter array length:");
				try {
					arrlen = scan.nextInt();
					status = 1;
				}catch(Exception e) {
					System.out.println("Wrong Input try again -- '" + scan.nextLine() + "'");
				}
			}while(status == 0);
		array = new int[arrlen];
		System.out.println("Enter array elements:");
		for(int i = 0;i<arrlen;i++) {
			array[i] = scan.nextInt();
		}
		scan.nextLine();
		System.out.println("Enter element to search: ");
		int srchNum = scan.nextInt();
		int i=0;
		for(;i<arrlen;i++) {
			if(array[i] == srchNum) {
				break;
			}
		}
		if(i<arrlen)
			System.out.println("Your Element is found at " + i);
		else
			System.out.println("Not found");
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			scan.close();
		}
	}
}
