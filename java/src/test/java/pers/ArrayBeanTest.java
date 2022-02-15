package pers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiaozhe
 * @date 2022/2/15
 */
public class ArrayBeanTest {

    @Test
    public void search() {
        ArrayBean arrayBean = new ArrayBean();
        int[] a = {3,5,1};
        arrayBean.search(a,3);
    }
}