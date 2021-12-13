package pers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author qiaozhe
 * @date 2021/12/11
 */
public class BfsTest {

    @Test
    public void shortestPathBinaryMatrix() {
        Bfs bfs = new Bfs();
        int[][] dd = {
                {0,1},
                {1,0}
        };
        System.out.println(bfs.shortestPathBinaryMatrix(dd));
    }

    @Test
    public void shortestPathBinaryMatrix2() {
        Bfs bfs = new Bfs();
        int[][] dd = {
                {0,0,0},
                {1,1,1}
        };
        System.out.println(bfs.shortestPathBinaryMatrix(dd));
    }

    @Test
    public void shortestPathBinaryMatrix3() {
        Bfs bfs = new Bfs();
        int[][] dd = {
                {0,0,0},
                {1,1,0},
                {1,1,0}
        };
        System.out.println(bfs.shortestPathBinaryMatrix(dd));
    }

    @Test
    public void numSquares() {
        Bfs bfs = new Bfs();
        System.out.println(bfs.numSquares(1));
        System.out.println(bfs.numSquares(2));
        System.out.println(bfs.numSquares(4));
        System.out.println(bfs.numSquares(12));
        System.out.println(bfs.numSquares(13));
    }

    @Test
    public void ladderLength() {
        Bfs bfs = new Bfs();
        String[] a = {"hot","dot","dog","lot","log","cog"};
        List<String> list = Arrays.asList(a);

        System.out.println(bfs.ladderLength("hit", "cog", list));
    }

    @Test
    public void ladderLength2() {
        Bfs bfs = new Bfs();
        String[] a = {"hot","dot","dog","lot","log"};
        List<String> list = Arrays.asList(a);

        System.out.println(bfs.ladderLength("hit", "cog", list));
    }
}