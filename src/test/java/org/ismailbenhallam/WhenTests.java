package org.ismailbenhallam;

import org.junit.jupiter.api.Test;
import org.mockito.Answers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WhenTests {

    @Test
    void whenTest() {
        List<String> list = mock(ArrayList.class, Answers.RETURNS_DEFAULTS);

        // Stubbing methods
        when(list.add("Ismaïl")).thenReturn(true);
        when(list.add("Liamsi")).thenThrow(IllegalArgumentException.class);

        assertFalse(list.add("name"));
        assertFalse(list.add("another name"));
        assertTrue(list.add("Ismaïl"));
        assertEquals(0, list.size());
        assertFalse(list.remove("éfff"));
        assertThrows(IllegalArgumentException.class, () -> {
            list.add("Liamsi");
        });


        doReturn(495).when(list).size();
        assertEquals(495, list.size());
    }

}
