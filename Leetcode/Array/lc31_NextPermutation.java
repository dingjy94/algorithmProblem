/**
* Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
* If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
* The replacement must be in-place, do not allocate extra memory.
* Basic idea: backtrack to find the num[n] < num[n + 1], swap num[n] with the smallest element larger
* than num[n] in (n + 1, num.length), than sort (n+1, num.length)
* Sort: Arrays.sort(num, start, end); end exclusive;
*/
public void nextPermutation(int[] num) {
    int n=num.length;
    if(n<2)
        return;
    int index=n-1;        
    while(index>0){
        if(num[index-1]<num[index])
            break;
        index--;
    }
    if(index==0){
        reverseSort(num,0,n-1);
        return;
    }
    else{
        int val=num[index-1];
        int j=n-1;
        while(j>=index){
            if(num[j]>val)
                break;
            j--;
        }
        swap(num,j,index-1);
        reverseSort(num,index,n-1);
        return;
    }
}

public void swap(int[] num, int i, int j){
    int temp=0;
    temp=num[i];
    num[i]=num[j];
    num[j]=temp;
}

public void reverseSort(int[] num, int start, int end){   
    if(start>end)
        return;
    for(int i=start;i<=(end+start)/2;i++)
        swap(num,i,start+end-i);
}
