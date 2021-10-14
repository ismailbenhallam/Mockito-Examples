package org.ismailbenhallam;

import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.withSettings;

class SimpleTests {

    /*
        By default, the "mock" returns default values (false, 0, null)
     */
    @Test
    void demoTest() {
        Demo demo = Mockito.mock(Demo.class);
        assertEquals(0, demo.getInt());
        assertEquals(0, demo.getInteger().intValue());
        assertEquals(0d, demo.getDouble(), 0d);
        assertFalse(demo.getBoolean());
        assertNull(demo.getObject());
        assertEquals(Collections.emptyList(), demo.getCollection());
        assertNull(demo.getArray());
        assertEquals(0L, demo.getStream().count());
        assertFalse(demo.getOptional().isPresent());
    }

    @Test
    void arrayListTestWithDefaultBehaviour() {
        List<String> list = Mockito.mock(ArrayList.class);

        assertEquals(0, list.size());
        assertFalse(list.isEmpty());
        assertFalse(list.add("ffff"));
        assertFalse(list.isEmpty());
        assertEquals(0, list.size());
    }

    /**
     * We can change the default behaviour of a mock, by passing an instance of {@link org.mockito.stubbing.Answer}.
     * PS: we can use the enum {@link Answers}
     */
    @Test
    void arrayListTestWithCallingRealMethods() {
        List<String> list = Mockito.mock(ArrayList.class, withSettings().defaultAnswer(Answers.CALLS_REAL_METHODS).useConstructor());

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        assertTrue(list.add("ffff"));
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
    }

    // We should also mock interfaces with default methods
    @Test
    void interfaceDefaultMethods() {
        interface AnInterface {
            default boolean isTrue() {
                return true;
            }
        }
        AnInterface mock = mock(AnInterface.class);
        assertFalse(mock.isTrue());
    }
}