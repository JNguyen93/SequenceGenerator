import java.util.ArrayList;


public class Main {
	public static ArrayList<Integer> sequenceGenerator(int n) throws IllegalArgumentException{
		//Recursively generates the sequence given a positive integer n
		ArrayList<Integer> sequence = new ArrayList<Integer>();
		return sequenceGenerator(n, sequence);
	}
	
	public static ArrayList<Integer> sequenceGenerator(int n, ArrayList<Integer> sequence) throws IllegalArgumentException{
		//A function overload to utilize the ArrayList generated in the initial function call
		
		ArrayList<Integer> sequence1 = null;
		
		if(n <= 0){	//Checks to make sure it's a positive integer
			throw new IllegalArgumentException("Invalid input. Must be a positive integer.");
		}
		
		sequence.add(n);
		
		if(n == 1){		//Base Case for recursion
			return sequence;
		}
		else if(n % 2 == 0){	//If n is even, generate next sequence with n/2
			sequence1 = sequenceGenerator(n/2, sequence);
		}
		else if(n % 2 == 1){	//If n is odd, generate next sequence with (3*n) + 1
			sequence1 = sequenceGenerator((3*n) + 1, sequence);
		}
		return sequence1;
	}
	
	public static void main(String[] args){
		//Test case 0-10
		/*String output = "";
		int A[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		for(int a : A){
			ArrayList<Integer>temp1 = sequenceGenerator(a);
			for(int j: temp1){
				output += j + ", ";
			}
			System.out.println("Sequence for " + a + ": ");
			System.out.println(output);
			System.out.println("Sequence Length: " + temp1.size() + "\n");
			output = "";
			temp1.clear();
		}*/
		
		//Sequence generation for n = 27
		ArrayList<Integer> sequence27 = sequenceGenerator(27);
		String sequence = "";
		for(int i: sequence27){	//Adds the elements of the sequence to a string
			sequence += i + ", ";
		}
		System.out.println("Sequence for 27:");
		System.out.println(sequence);
		System.out.println("Sequence Length: " + sequence27.size());
		
		int max = 100000;	//upper bound of problem
		int num = 0;	//n with the largest sequence
		int ans = 0;	//size of the largest sequence
		
		for(int i = 1; i < max; i++){	//Runs through the range (1, 100000)
			ArrayList<Integer>temp1 = sequenceGenerator(i);
			if(temp1.size() > ans){	//If current sequence is longer, record it.
				num = i;
				ans = temp1.size();
			}
			temp1.clear();
		}
		
		System.out.println("Computing number with largest sequence...");
		System.out.println("Number: " + num + " Sequence Length: " + ans);

	}
}
