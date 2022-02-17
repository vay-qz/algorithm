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
}