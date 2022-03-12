package pers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiaozhe
 * @date 2022/2/17
 */
public class DpBeanTest {

    @Test
    public void knightProbability() {
        DpBean bean = new DpBean();
        bean.knightProbability(8, 30, 6, 4);
    }

    @Test
    public void countSquares() {
        DpBean bean = new DpBean();
        int[][] a = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        bean.countSquares(a);
    }
}