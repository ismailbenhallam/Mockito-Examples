package org.ismailbenhallam;

import org.ismailbenhallam.service.PasswordEncoder;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalMatchers;
import org.mockito.ArgumentMatcher;

import java.io.File;
import java.io.FileFilter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArgumentsMatcherTests {

    @Test
    void argumentsMatcher() {
        PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);

        when(passwordEncoder.encode(anyString())).thenReturn("exact");
        assertEquals("exact", passwordEncoder.encode("1"));
        assertEquals("exact", passwordEncoder.encode("abc"));

        when(passwordEncoder.encode(eq("P@$$W0RD"))).thenReturn("DON't USE THIS PASSWORD!");

        assertEquals("DON't USE THIS PASSWORD!", passwordEncoder.encode("P@$$W0RD"));
        assertEquals("exact", passwordEncoder.encode("abc"));
    }

    @Test
    void customArgumentsMatcher() {
        FileFilter fileFilter = mock(FileFilter.class);
        ArgumentMatcher<File> hasLuck = file -> file.getName().endsWith("luck");
        when(fileFilter.accept(argThat(hasLuck))).thenReturn(true);
        assertFalse(fileFilter.accept(new File("/deserve")));
        assertTrue(fileFilter.accept(new File("/deserve/luck")));
    }

    @Test
    void combiningArgumentsMatcher() {
        PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);
        when(passwordEncoder.encode(AdditionalMatchers.or(eq("1"), contains("a")))).thenReturn("ok");
        assertEquals("ok", passwordEncoder.encode("1"));
        assertEquals("ok", passwordEncoder.encode("123abc"));
        assertNull(passwordEncoder.encode("123"));
    }
}
