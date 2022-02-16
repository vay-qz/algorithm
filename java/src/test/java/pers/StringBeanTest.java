package pers;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringBeanTest {

    @Test
    public void longestPalindrome() {
        StringBean bean = new StringBean();
        bean.longestPalindrome("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez");
    }

    @Test
    public void isIsomorphic() {
        StringBean bean = new StringBean();
        bean.isIsomorphic("badc", "baba");
    }

    @Test
    public void countSubstrings() {
        StringBean bean = new StringBean();
        bean.countSubstrings("abc");
    }

    @Test
    public void groupAnagrams() {
        StringBean bean = new StringBean();
        String[] b = {"eat","tea","tan","ate","nat","bat"};
        bean.groupAnagrams(b);
    }
}
