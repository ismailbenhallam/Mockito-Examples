package org.ismailbenhallam;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SimpleAnnotationTests {

    @Mock
    List<String> list;

    @Test
    void listTest() {
        assertEquals(0, list.size());
        assertFalse(list.isEmpty());
        assertFalse(list.add("ffff"));
        assertFalse(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void injectedCollectionTest(@Mock Demo demo) {
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

}