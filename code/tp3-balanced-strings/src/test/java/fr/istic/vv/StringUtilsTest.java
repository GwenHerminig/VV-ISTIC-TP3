package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    // empty string
    @Test
    public void testEmptyString() {
        assertTrue(isBalanced(""));
    }

    // simple balanced symbols
    @Test
    public void testSimpleBalancedSymbols() {
        assertTrue(isBalanced("{}"));
        assertTrue(isBalanced("[]"));
        assertTrue(isBalanced("()"));
    }

    // complexe balanced symbols
    @Test
    public void testComplexeBalancedSymbols() {
        assertTrue(isBalanced("{[]}"));
        assertTrue(isBalanced("[()]"));
        assertTrue(isBalanced("{[()]}"));
    }

    // only opening symbols
    @Test
    public void testUnmatchedOpeningSymbols() {
        assertFalse(isBalanced("{("));
        assertFalse(isBalanced("("));
    }

    // only closing symbols
    @Test
    public void testUnmatchedClosingSymbols() {
        assertFalse(isBalanced(")]}"));
        assertFalse(isBalanced("}"));
        assertFalse(isBalanced(")"));
    }

    // only opening symbols with one balanced pair
    @Test
    public void testUnmatchedOpeningWithOneBalancedSymbols() {
        assertFalse(isBalanced("{[()"));
    }

    // only closing symbols with one balanced pair
    @Test
    public void testUnmatchedClosingWithOneBalancedSymbols() {
        assertFalse(isBalanced("{]}"));
        assertFalse(isBalanced("))))[)]"));
        assertFalse(isBalanced("[]]"));
    }
    // more complexe balanced
    @Test
    public void testMixedSymbols() {
        assertTrue(isBalanced("[{[()]}]"));
        assertTrue(isBalanced("{[(])}"));
    }
    // separated complexe balanced symbols
    @Test
    public void testSeparatedMixedSymbols() {
        assertTrue(isBalanced("{[()]}{[()]}"));
        assertTrue(isBalanced("{[(])}{[()]}"));
    }

    // balanced pair with other characters
    @Test
    public void testOtherCharacters() {
        assertTrue(isBalanced("abc[def]{ghi}jkl"));
        assertTrue(isBalanced("a[b{c}d]e(f)g"));
    }

    //Base Choice Coverage for the implementation line return curlyBraces == 0 && squareBrackets == 0 && parentheses == 0;
    // 0 0 0
    @Test
    public void ooo() {
        assertTrue(isBalanced("(([{}]))"));
    }
    // x 0 0
    @Test
    public void xoo() {
        assertFalse(isBalanced("({}[]"));
    }
    @Test
    public void oxo() {
        assertFalse(isBalanced("()[{}"));
    }
    // x 0 0
    @Test
    public void oox() {
        assertFalse(isBalanced("()[]{"));
    }
    @Test
    public void xxo() {
        assertFalse(isBalanced("([{}"));
    }
    @Test
    public void oxx() {
        assertFalse(isBalanced("(){["));
    }
    // x 0 0
    @Test
    public void xox() {
        assertFalse(isBalanced("({[]"));
    }
    @Test
    public void xxx() {
        assertFalse(isBalanced("({["));
    }
}