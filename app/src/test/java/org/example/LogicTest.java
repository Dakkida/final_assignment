package org.example;

import org.junit.jupiter.api.Test;

import jp.ac.uryukyu.ie.e245736.Logic;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {
    @Test
    public void testLogic() throws Exception {
        Logic logic = new Logic();
        logic.printBoard();
    }
}
