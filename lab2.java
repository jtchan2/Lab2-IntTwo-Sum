import java.util.*;
public class lab2{
	public int findSmallest (int [] arr, int start){
		int smallest= start;
		for(int i=start+1; i<arr.length; i++){
			if(arr[i]<arr[smallest]){
				smallest=i;
			}
		}
		return smallest;
		
	}
	public void swap( int [] arr, int i, int j){
		int holder=arr[i];
		arr[i]=arr[j];
		arr[j]=holder;
	}

	public void sort(int [] arr){
		for (int i=0; i<arr.length; i++){
			swap(arr, i, findSmallest(arr,i));
		}
	}
	
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

		int [] numbers= new int[] {2,13,8,7};

		lab2 sumFinder= new lab2();

		int target=9;

		System.out.println("Given array: ");

		for(int i=0; i<numbers.length; i++){
			if(i==numbers.length-1){
				System.out.println(numbers[i]+" ");
			}else{
				System.out.print(numbers[i]+" ");
			}
		}

		sumFinder.sort(numbers);

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

		if(places[0]==-1){
			System.out.println(places[0]);
			System.out.println("No valid nums can equal target or same number cannot add to each other");
		}else{
			System.out.println("["+places[0]+", "+ places[1]+"]");
			System.out.println("Because "+ numbers[place1]+" + " +numbers[place2]+" = "+target);
		}
	}
}