package org.ismailbenhallam;

import org.ismailbenhallam.service.PasswordEncoder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class VerifyTests {

    @Test
    void verifyTest() {
        PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);
        when(passwordEncoder.encode("a")).thenReturn("1");
        passwordEncoder.encode("a");

        //  “Hey, Mockito, make sure this method was called with these arguments.”
        verify(passwordEncoder).encode("a");
        verify(passwordEncoder).encode("a");


        Mockito.reset(passwordEncoder);
        verifyNoInteractions(passwordEncoder);

        passwordEncoder.encode("john");
        passwordEncoder.encode("john");
        verify(passwordEncoder, times(2)).encode("john");
    }

}
