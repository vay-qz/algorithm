package pers;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class StacksTest {
    Stacks stacks = new Stacks();

    @Test
    public void decodeString() {
        stacks.decodeString("3[a]2[bc]");
    }
}
