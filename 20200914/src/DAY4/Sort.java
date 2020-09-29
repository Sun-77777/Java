package DAY4;

import java.util.Arrays;
import java.util.Stack;

public class Sort {
    //插入排序
    public static void insertSort(int[] array) {
        //[0,bound) 已排序
        //[bound,array.length) 待排序
        for (int bound = 1; bound < array.length; bound++) {
            int v = array[bound];
            int cur = bound - 1;//已排序区间的最后一个下标
            for (; cur >= 0; cur--) {
                if (array[cur] > v) {
                    array[cur+1] = array[cur];
                } else {
                    break;
                }
            }
            array[cur+1] = v;
        }
    }
    //希尔排序
    public static void shellSort(int[] array) {
        int gap = array.length/2;
        while (gap > 1) {
            insertSortGap(array,gap);
            gap = gap/2;
        }
        insertSortGap(array,1);
    }
    public static void insertSortGap(int[] array,int gap) {
        for (int bound = gap; bound < array.length; bound++) {
            int v = array[bound];
            int cur = bound - gap;
            for (; cur >= 0; cur -= gap) {
                if (array[cur] > v) {
                    array[cur+gap] = array[cur];
                }else {
                    break;
                }
            }
            array[cur+gap] = v;
        }
    }
    //选择排序
    //以bound位置的元素作为擂主，循环从待排序区间中取出元素和 擂主进行比较
    //如果打擂成功，就和擂主交换。
    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound+1; cur < array.length; cur++) {
                if (array[cur] < array[bound]) {
                    int tmp = array[cur];
                    array[cur] = array[bound];
                    array[bound] = tmp;
                }
            }
        }
    }

    public static void swap(int[] array,int i,int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    //堆排序
    public static void heapSort(int[] array) {
        //先建立堆
        createHeap(array);
        //循环把堆顶元素交换到最后，并进行调整堆
        //循环此时是length-.当堆中只剩一个元素的时候，也就一定是有序的了。
        for (int i = 0; i < array.length-1; i++) {
            //交换堆顶元素和堆的最后一个元素
            swap(array,0,array.length-1-i);
            //交换完成之后，要把最后一个元素从堆中删掉
            shiftDown(array,array.length-i-1,0);
        }
        
    }

    private static void shiftDown(int[] array, int length, int index) {
        int parent = index;
        int child = 2*parent+1;
        while (child < length) {
            if (child + 1 < length && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                swap(array,child,parent);
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    private static void createHeap(int[] array) {
        //从最后一个非叶子节点出发向前循环，依次进行向下调整
        for (int i = (array.length-1-1)/2; i>= 0; i--) {
            shiftDown(array,array.length,i);
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = array.length - 1; cur > bound; cur--) {
                if (array[cur - 1] > array[cur]) {
                    swap(array,cur - 1, cur);
                }
            }
        }
    }


    //快速排序
    public static void quickSort(int[] array) {
        quickHelper(array,0,array.length - 1);
    }

    private static void quickHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        //针对[left,right]区间进行管理
        //index返回值就是整理完毕后，left和right的重合位置，知道了这个位置，才能进一步进行递归

        int index = partition(array,left,right);
        quickHelper(array,left,index - 1);
        quickHelper(array,index + 1,right);

    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int key = array[right];
        while (i < j) {
            while (i < j && array[i] <= key) {
                i++;
            }
            while (i < j && array[j] >= key) {
                j--;
            }
            swap(array,i,j);
        }
        swap(array,i,right);
        return i;
    }

    public static void quickSortByLoop(int[] array) {
        //借助栈，模拟实现递归的过程
        //stack 用来存放数组下标，通过下标来表示接下来要处理的区间是啥
        Stack<Integer> stack = new Stack<>();
        //初始情况下，先把右侧边界下标入栈，再从左侧边界下标入栈，左右边界仍然构成前闭后闭区间。
        stack.push(array.length - 1);
        stack.push(0);

        while (!stack.isEmpty()){
            int left = stack.pop();
            int right = stack.pop();
            if (left >= right) {
                continue;
            }

            int index = partition(array,left,right);
            stack.push(right);
            stack.push(index + 1);
            stack.push(index - 1);
            stack.push(left);
        }

    }

    public static void main(String[] args) {
        int[] array = {1,5,3,9,2,4,6};
        //insertSort(array);
        //shellSort(array);
        //heapSort(array);
        //bubbleSort(array);
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
    
}
