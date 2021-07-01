package com.yener.testproject.basic;

import com.yener.testproject.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AssertAllTest {

    /*
    Assertions.*
    assertEquals
    assertEquals with message
    assertNotEquals
    assertTrue
    assertFalse
    assertNull
    assertNotNull
    assertArrayEquals
    assertSame
    */

    @Test
    @DisplayName("User name test")
    void studentNameTest() {
        User erhan = new User("erhan", "yener", null);
        assertEquals("erhan", erhan.getFirstName());
    }

    @Test
    @DisplayName("User Test Group")
    void studentTest() {
        User erhan = new User("erhan", "yener", null);
        Assertions.assertAll("User name check",
                () -> assertEquals("erhan", erhan.getFirstName()),
                () -> assertEquals("yener", erhan.getLastName(), "1.soyad alanı yanlış"),
                () -> assertNotEquals("yenerr", erhan.getLastName(), "2.soyad alanı yanlıs"));
    }
}
