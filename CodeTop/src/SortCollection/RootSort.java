package SortCollection;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/09/11:17
 * @Description: 三尺秋水尘不染
 */

/*
215. 数组中的第K个最大元素
        给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。

        请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。


        示例 1:

        输入: [3,2,1,5,6,4] 和 k = 2
        输出: 5
        示例 2:

        输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
        输出: 4
*/

public class RootSort {
    public int findKthLagest(int[]nums,int k){
        PriorityQueue<Integer> heap =
                new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int n:nums
             ) {
            heap.add(n);
            if(heap.size()>k){
                heap.poll();
            }
            
        }return heap.poll();
    }

//    大根堆：
    class Solutionbig {
        public int findKthLargest(int[] nums, int k) {
            int heapSize = nums.length;

            //将数组，数组长度传递构造大根堆。
            buildMaxHeap(nums, heapSize);

            for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
                swap(nums, 0, i);
                --heapSize;
                maxHeapify(nums, 0, heapSize);
            }
            return nums[0];
        }

        public void buildMaxHeap(int[] a, int heapSize) {
            for (int i = heapSize / 2; i >= 0; --i) {
                maxHeapify(a, i, heapSize);
            }
        }

        public void maxHeapify(int[] a, int i, int heapSize) {
            int left = i * 2 + 1,//左子树
                    right = i * 2 + 2,//右子树
                    largest = i;//最大根
            if (left < heapSize && a[left] > a[largest]) {
                largest = left;
            }
            if (right < heapSize && a[right] > a[largest]) {
                largest = right;
            }
            if (largest != i) {
                swap(a, i, largest);
                maxHeapify(a, largest, heapSize);
            }
        }

        public void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

//    小根堆：
//    class Solutionlittle {
//        public:
//        int findKthLargest(vector<int>& nums, int k) {
//            // 对前k个元素建成小根堆
//            for (int i = 0; i < k; i++) {
//                swim(nums, i);
//            }
//            // 剩下的元素与堆顶比较，若大于堆顶则去掉堆顶，再将其插入
//            for (int i = k; i < nums.size(); i++) {
//                if (nums[i] > nums[0]) {
//                    swap(nums[0], nums[i]);
//                    sink(nums, 0, k - 1);
//                }
//            }
//            // 结束后第k个大的数就是小根堆的堆顶
//            return nums[0];
//        }
//
//        private:
//        // 若v1比v2优先度高，返回true
//        bool priorityThan(int v1, int v2) { return v1 < v2; }
//
//        // 上浮 从下到上调整堆
//        void swim(vector<int>& heap, int i) {
//            while (i > 0 && priorityThan(heap[i], heap[(i - 1) / 2])) {
//                swap(heap[i], heap[(i - 1) / 2]);
//                i = (i - 1) / 2;
//            }
//        }
//
//        // 下沉 从下到上调整堆
//        void sink(vector<int>& heap, int i, int N) {
//            while (2 * i + 1 <= N) {
//                int j = 2 * i + 1;
//                if (j + 1 <= N && priorityThan(heap[j + 1], heap[j])) {
//                    j++;
//                }
//                if (priorityThan(heap[i], heap[j])) {
//                    break;
//                }
//                swap(heap[i], heap[j]);
//                i = j;
//            }
//        }
//    };


}
