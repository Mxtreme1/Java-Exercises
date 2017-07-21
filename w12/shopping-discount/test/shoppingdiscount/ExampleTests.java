package shoppingdiscount;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ExampleTests {

    @Test
    public void test() {
        assertEquals(
                153,
                Main.checkout(Arrays.asList(
                        new CartItem("shoes", 25),
                        new CartItem("bag", 50),
                        new CartItem("shoes", 85),
                        new CartItem("hat", 15))),
                0.1
        );
    }

}