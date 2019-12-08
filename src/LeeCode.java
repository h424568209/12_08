import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeeCode {
    /**
     * 一个整数的各个位之积减去各个位的和
     */
    public int subtractProductAndSum(int n) {
        String s = Integer.toString(n);
        int sum = 0;
        int mul = 1 ;
        for(int i =0 ; i < s.length() ; i++){
            sum += (s.charAt(i) - '0');
            mul *= (s.charAt(i) - '0');
        }
        return mul - sum;

    }
    /**
     *  给定一个数组A，将其划分成两个数组，保持左边的数组中最大的元素永远小于右边数组的最小的元素
     *  保证至少存在一组可以划分的数组
     * @param A 数组
     * @return 左边数组的长度
     *
     * 维持一个MAX记录当前的最大的元素 维持一个LeftMax记录左边数组的最大的元素，
     * 若当前的数字小于左边的最大的数字，进行更新index为当前下标，leftmax 为当前最大的元素
     */
    public int partitionDisjoint(int[] A) {

        int leftMax = A[0],max = A[0],index = 0;
        for(int i = 0 ; i < A.length ; i++){
            max = Math.max(max,A[i]);
            if(A[i] < leftMax){
                leftMax = max;
                index = i;
            }
        }
        return index + 1 ;
    }
    /**
     * 给你个整数数组 arr，其中每个元素都 不相同。
     * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
     * 先将数组进行排序  定义一个初始的最小值，在进行最小值的比较
     * @param arr 数组
     * @return 最小的绝对差的元素对，按升序排列
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int min = Math.abs(arr[1] - arr[0]);
        for(int i = 1; i < arr.length ; i++){
            if(Math.abs(arr[i] - arr[i-1]) == min){
                List<Integer> list = new ArrayList<>();
                list.add(arr[i-1]);
                list.add(arr[i]);
                res.add(list);
            }
            else if(min > Math.abs(arr[i] - arr[i-1])){
                res.clear();
                List<Integer> list=  new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i-1]);
                res.add(list);
                min = Math.abs(arr[i] - arr[i-1]);

            }
        }
        return  res;
    }
    public static void main(String[] args) {
        LeeCode l = new LeeCode();
        System.out.println(l.minimumAbsDifference(new int []{1,2,3,4,5,9,8,-1,11,21,7,0}));
        System.out.println(l.partitionDisjoint(new int[]{5,4,1,2,9,7,11,0,12}));
        System.out.println(l.subtractProductAndSum(12340));
    }
}
