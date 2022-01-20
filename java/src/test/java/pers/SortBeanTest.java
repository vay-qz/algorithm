package pers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiaozhe
 * @date 2022/1/17
 */
public class SortBeanTest {

    SortBean sortBean = new SortBean();

    @Test
    public void findKthLargest() {
        int[] k = {3,2,3,1,2,4,5,5,6};
        sortBean.findKthLargest(k, 1);
    }

    @Test
    public void quickSort() {
        int[] nums = {3,2,1,5,6,4};
        sortBean.quickSort(nums);
    }

    @Test
    public void heapSort() {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        sortBean.heapSort(nums);
    }

}