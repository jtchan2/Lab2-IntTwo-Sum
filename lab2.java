import java.util.*;
public class lab2{
	//basically sorts through array where given start index is kept as smallest
	//but if not, hcanges index to the next smallest index of array and returns the index place
	public int findSmallest (int [] arr, int start){
		int smallest= start;
		for(int i=start+1; i<arr.length; i++){
			if(arr[i]<arr[smallest]){
				smallest=i;
			}
		}
		return smallest;
		
	}
	//Swaps positions of 2 indexes of an array
	public void swap( int [] arr, int i, int j){
		int holder=arr[i];
		arr[i]=arr[j];
		arr[j]=holder;
	}
	//Makes an rray sorted through selection sort, where array is now sorted smallest to biggest
	public void sort(int [] arr){
		for (int i=0; i<arr.length; i++){
			swap(arr, i, findSmallest(arr,i));
		}
	}
	//takes in an array, creates an array so taht indicies found that equal the sum can be saved and returned
	//if indicies sum equal the target sum and returns the indicies, if not reutrns created array with -1 values
	public int [] twoSum(int [] num, int sum){
		int [] indicies= new int[2];
		indicies[0]=-1;
		indicies[1]=-1;
		for(int i=0; i<num.length; i++){
			for(int j=1; j<num.length; j++){
				if(num[i]+num[j]==sum&& num[i]!=num[j]){
					indicies[0]=i;
					indicies[1]=j;
					return indicies;
				}
			}
			
		}
		return indicies;
		
	}
	public static void main(String [] args){

		int [] numbers= new int[] {1,13,18,20,20,30};

		lab2 sumFinder= new lab2();

		int target=40;

		System.out.println("Given array: ");

		//For loop jjust prints out the array
		for(int i=0; i<numbers.length; i++){
			if(i==numbers.length-1){
				System.out.println(numbers[i]+" ");
			}else{
				System.out.print(numbers[i]+" ");
			}
		}

		//sorts the array
		sumFinder.sort(numbers);

		//prints array out again
		System.out.println("Sorted given array:");

		for(int j=0; j<numbers.length; j++){
			if(j==numbers.length-1){
				System.out.println(numbers[j]);
			}else{
				System.out.print(numbers[j]+" ");
			}
		}

		int [] places= sumFinder.twoSum(numbers,target);

		int place1= places[0];

		int place2=places[1];

		//if first index of answer array equals -1 it prints that target sum cannot be reached 
		if(places[0]==-1){
			System.out.println(places[0]);
			System.out.println("No valid nums can equal target or same number cannot add to each other");
		}else{
			//It prints the indicies where sum is made and prints addition of the two nums
			System.out.println("["+places[0]+", "+ places[1]+"]");
			System.out.println("Because "+ numbers[place1]+" + " +numbers[place2]+" = "+target);
		}
	}
}