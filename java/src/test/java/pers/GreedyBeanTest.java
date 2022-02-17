package pers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiaozhe
 * @date 2022/2/17
 */
public class GreedyBeanTest {

    @Test
    public void merge() {
        GreedyBean greedyBean = new GreedyBean();
        int[][] a = {{1, 4}, {0, 4}};
        greedyBean.merge(a);
    }
}