package pers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiaozhe
 * @date 2022/2/23
 */
public class DoublePointerTest {

    @Test
    public void trap() {
        DoublePointer pointer = new DoublePointer();
        int[] s = {0,1,0,2,1,0,1,3,2,1,2,1};
        pointer.trap(s);
    }
}