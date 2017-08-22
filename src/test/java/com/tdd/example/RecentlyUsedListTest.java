package com.tdd.example;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by veraxmedax on 22/08/2017.
 */
public class RecentlyUsedListTest {
    @Test
    public void list_is_initially_empty() {
        // WHEN:
        RecentlyUsedList<String> list = new RecentlyUsedList<>();

        // THEN:
        assertTrue(list.isEmpty());
    }

    @Test
    public void list_elements_added_to_head() {
        // GIVEN:
        RecentlyUsedList<String> list = new RecentlyUsedList<>();

        // WHEN:
        list.add("Book");
        list.add("Pencil");

        // THEN:
        assertEquals("Pencil", list.get(0));
    }

    @Test
    public void list_elements_shift_to_tail_if_new_element_added() {
        // GIVEN:
        RecentlyUsedList<String> list = new RecentlyUsedList<>();
        list.add("Book");
        assertEquals("Book", list.get(0));

        // WHEN:
        list.add("Pencil");
        list.add("Paper");

        // THEN:
        assertEquals("Pencil", list.get(1));
        assertEquals("Book", list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    public void list_not_accepts_duplicate_element_additions() {
        // GIVEN:
        RecentlyUsedList<String> list = new RecentlyUsedList<>();

        // WHEN:
        list.add("Book");
        list.add("Pencil");
        list.add("Book");

        // THEN:
        assertEquals(2, list.size());
        assertEquals("Pencil", list.get(0));
    }

    @Test
    public void list_elements_can_be_removed_by_index() {
        // GIVEN:
        RecentlyUsedList<String> list = new RecentlyUsedList<>();

        // WHEN:
        list.add("Book");
        list.add("Pencil");
        list.add("Paper");
        assertTrue(list.contains("Pencil"));
        assertEquals("Pencil", list.get(1));

        // THEN:
        list.remove("Pencil");
        assertFalse(list.contains("Pencil"));
    }

    @Test(expected = IllegalArgumentException.class) // <- THEN
    public void adding_null_element_to_list_throws_exception() {
        // GIVEN:
        RecentlyUsedList<String> list = new RecentlyUsedList<>();

        // WHEN:
        list.add(null);
    }
}
