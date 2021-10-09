
public class Sort {

	int[] arr;
	
	public Sort(int[] array) {
		
		this.arr = array;	
		this.arr = bubbleSort(this.arr);
		
	}

	public int[] getSort() {
		return this.arr;
	}
	
    public int[] bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
		return arr;
    }
}

//bubble sort modified from https://www.geeksforgeeks.org/bubble-sort/