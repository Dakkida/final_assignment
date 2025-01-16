package org.example;

import org.junit.jupiter.api.Test;

import jp.ac.uryukyu.ie.e245736.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {
    @Test
    public void testMain() throws Exception {
        int[][] board = new int[8][8];
        Logic main = new Logic();
        int a = 3;
        int b = 5;
        int player = 1;
        int bplayer = 2;

        assertTrue(main.check(a, b, player, bplayer));
    }
}