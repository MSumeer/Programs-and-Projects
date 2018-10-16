import java.util.Scanner;
public class MergeSort
{
    public static void main(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("input number of elements");
        int[] a = new int[scanner.nextInt()];
        System.out.println("Enter elements");
        for(int i = 0;i<a.length;i++){
            a[i] = scanner.nextInt();
            System.out.println("input: "+ a[i]);
        }
        mergeSort(a,0,a.length-1,new int[a.length]);
        for(int b:a){
            System.out.print(b+", ");
        }
    }

    private static void mergeSort(int[] a, int start, int end,int[] temp){
        if(start>=end){
            return ;
        }
        int mid = (start+end)/2;
        mergeSort(a, start, mid,temp);
        mergeSort(a, mid+1, end,temp);
        merge(a,start,end,temp);
    }

    private static void merge(int[] a, int start, int end,int[] temp){
        int leftEnd = (end+start)/2;
        int rightStart = leftEnd+1;
        int size = end-start+1;

        int left = start;
        int right = rightStart;
        int index = start;

        while(left<= leftEnd && right<=end){
            if(a[left]<=a[right]){
                temp[index] = a[left];
                index++;
                left++;
            }else{
                temp[index] = a[right];
                index++;
                right++;
            }
        }
        try{
            System.arraycopy(a,left,temp,index,leftEnd-left+1);
        }
        catch(ArrayIndexOutOfBoundsException e){}
        try{
            System.arraycopy(a,right,temp,index,end-right+1);
        }catch(ArrayIndexOutOfBoundsException e){}
        System.arraycopy(temp,start,a,start,size);
    }
}
