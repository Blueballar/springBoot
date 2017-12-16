public class Sort{

	public static void main(String[]args){
		int []data = {1,22,333,212,321,-32,232,-332,-123,-32};
		System.out.println("排序之前的数组：");
		print(data);
		//dubbleSort(data);
	//	insertSort(data);
	//	selectSort(data);
	//	shellSort(data);
	//	quickSort(data,0,data.length-1);
	//	mergeSort(data,0,data.length-1);
	//	initHead(data);
		
		headSort(data);
		System.out.println("排序之后的数组：");
		print(data);
	}
	
	public static void headSort(int data[]){
		initHead(data,0,data.length);
		for(int i=data.length-1;i>0;i--){
			swap(data,0,i);
			//recover(data,0,data.length-i,0);
			initHead(data,0,i-1);
		}
	
	}
	private static void initHead(int[] data,int begin,int length){
		for(int i=begin;i<length/2;i++){
			recover(data,begin,length,i);
		}
	}
	private static void recover(int[] data,int begin,int end,int index){
		int max = index*2+1;
		int right =index*2+2;
		if(max+1<end&&data[max]<data[right]){
			max = index*2+2;
		}
		if(max>end){
			return;
		}
		if(data[index]>data[max]){
			return;
		}else{
			swap(data,index,max);
			recover(data,begin,end,max);
		}

	}

	public static void mergeSort(int[]data,int begin,int end){
		if(begin>=end){
			return;
		}
		int center = (begin+end)/2;
		mergeSort(data,begin,center);
		mergeSort(data,center+1,end);
		sort(data,begin,center,end);
	}
	private static void sort(int data[],int begin,int center,int end){
		int left = begin;
		int right = center + 1;
		int index = begin;
		int temp[] = new int[data.length];
		while(left<=center&&right<=end){
			if(left<=center&&right<=end&&data[left]<data[right]){
				temp[index++] = data[left++];
			}else{
				temp[index++] = data[right++];
			}
		}
		while(index<=end&&left<=center){
			temp[index++] = data[left++];
		}
		while(index<=end&&right<=end){
			temp[index++] = data[right++];
		}
		for(int i=begin;i<=end;i++){
			data[i] = temp[i];
		}	
	}
	public static void quickSort(int[]data,int begin,int end){
		if(begin<end){
			int location = findLocation(data,begin,end);
			quickSort(data,begin,location-1);
			quickSort(data,location+1,end);
	
		}
	}
	private static int findLocation(int[] data,int begin,int end){
		if(begin>=end){
			return begin;
		}
		int left = begin+1;
		int right = end;
		while(left<right){
			while(left<right&&data[right]<=data[begin]){
				right--;
			}	
			swap(data,left,right);
			while(left<right&&data[left]>=data[begin]){
				left++;
			}
			swap(data,left,right);
		}
		swap(data,begin,left);
		return left;
	}	

	private static void swap(int[]data,int begin,int end){
		int temp = data[begin];
		data[begin] = data[end];
		data[end] = temp;
	}

	/*
	 *希尔排序
	 */
	public static void  shellSort(int[]data){
		int step = data.length/2;
		int temp; 
		while(step>=1){
			for(int i=step;i<data.length;i++){
				temp = data[i];
				int j = i - step;
				while(j>=0&&temp<data[j]){
					data[j+step]=data[j];
					j-=step;
				
				}
					data[j+step] = temp;
			}
			step = step-1;
		}

	
	}
	
	
	/*
	 * 选择排序算法
	 */
	public static void selectSort(int []data){
		for(int i=0;i<data.length-1;i++){
			int max = i;
			int min = i;
			for(int j = i;j<data.length;j++){
				if(data[j]>data[max]){
					max = j;
				}else 
				if(data[j]<data[min]){
					min = j;
				}
			}
			if(max!=i){
				int temp = data[i];
				data[i] = data[max];
				data[max] = temp;
			}
			if(min!=i){
				int temp = data[i];
				data[i] = data[min];
				data[min]  = temp;
			}
		
		}
	
	}

	


	/*
	 *插入排序算法
	 */
	private static void insertSort(int data[]){
		for(int i=0;i<data.length;i++){
			int temp = data[i];
			int j=i;
			while(j>=1&&data[j-1]>temp){
				data[j] = data[--j];
			}
			if(j>=0)
				data[j] = temp;
		}

	
		
	}

	/*
	 *冒泡排序
	 */
	private static void dubbleSort(int[]data){
		for(int i=0;i<data.length-1;i++){
			for(int j=i+1;j<data.length;j++){
				if(data[i]<data[j]){
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		
		}
	
	}


	private static void print(int[]data){
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+" ");
		
		}
		System.out.println();
	}


}
