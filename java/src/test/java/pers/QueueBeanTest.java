package pers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiaozhe
 * @date 2022/3/29
 */
public class QueueBeanTest {

    QueueBean queueBean = new QueueBean();

    @Test
    public void minWindow() {
        queueBean.minWindow("ADOBECODEBANC", "ABC");
        queueBean.minWindow("a", "a");
        queueBean.minWindow("a", "aa");
    }
}