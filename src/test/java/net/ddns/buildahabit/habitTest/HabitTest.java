package net.ddns.buildahabit.habitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import net.ddns.buildahabit.habit.Habit;
import net.ddns.buildahabit.habit.HabitRecurrence;

public class HabitTest {

    private List<Long> idList = List.of(0L, 1L, 1000L);
    private List<String> nameList = List.of("test", "1test", "test1");
    private List<HabitRecurrence> recurrenceList = List.of(HabitRecurrence.DAILY);
    private List<String> descriptionList = List.of("This is a description.", "This is another description!",
            "1236890asdkb+*ç%&/()");

    @Test
    public void constructorTest() {
        Object habit = new Habit();
        assertTrue(habit instanceof Habit);
        Habit emptyHabit = (Habit) habit;
        assertNull(emptyHabit.getId());
        assertNull(emptyHabit.getName());
        assertNull(emptyHabit.getDescription());
        assertNull(emptyHabit.getRecurrence());

        // Test every combination of values
        for(Long id : idList) {
            for(String name : nameList) {
                for(HabitRecurrence recurrence : recurrenceList) {
                    for(String description : descriptionList) {
                        Habit habitA = new Habit(name, recurrence, description);
                        Habit habitB = new Habit(id, name, recurrence, description);
                        assertNull(habitA.getId());
                        assertEquals(name, habitA.getName());
                        assertEquals(recurrence, habitA.getRecurrence());
                        assertEquals(description, habitA.getDescription());

                        assertEquals(id, habitB.getId());
                        assertEquals(name, habitB.getName());
                        assertEquals(recurrence, habitB.getRecurrence());
                        assertEquals(description, habitB.getDescription());
                    }
                }
            }
        }
    }

    @Test
    public void hashCodeTest() {
        for(Long id : idList) {
            for(String name : nameList) {
                for(HabitRecurrence recurrence : recurrenceList) {
                    for(String description : descriptionList) {
                        Habit habit = new Habit(id, name, recurrence, description);
                        Habit habitOther = new Habit(id, name, recurrence, description);
                        // check it is not the same object
                        assertNotSame(habit, habitOther);
                        // same key fields should result in same hashcode
                        assertEquals(habit.hashCode(), habitOther.hashCode());

                        // a change in any key field should result in a different hashcode
                        habitOther.setName("differentName");
                        assertNotEquals(habit.hashCode(), habitOther.hashCode());

                        habitOther = new Habit(id, name, recurrence, "this is a different description");
                        assertNotEquals(habit.hashCode(), habitOther.hashCode());
                        // TODO test different recurrence once available
                        /*
                        habitOther.setRecurrence(habitOther.getRecurrence() == HabitRecurrence.DAILY ? HabitRecurrence.WEEKLY : HabitRecurrence.DAILY);
                        assertNotEquals(habit.hashCode(), habitOther.hashCode());
                        */
                    }
                }
            }
        }
    }

    @Test
    public void equalsTest() {
        for(Long id : idList) {
            for(String name : nameList) {
                for(HabitRecurrence recurrence : recurrenceList) {
                    for(String description : descriptionList) {
                        Habit habit = new Habit(id, name, recurrence, description);
                        Habit habitOther = new Habit(id, name, recurrence, description);
                        // check it is not the same object
                        assertNotSame(habit, habitOther);
                        assertEquals(habit, habitOther);

                        // a change in any field should result in non equality
                        habitOther.setName("differentName");
                        assertNotEquals(habit, habitOther);

                        habitOther = new Habit(id, name, recurrence, "this is a different description");
                        assertNotEquals(habit, habitOther);
                        // TODO test different recurrence once available
                        /*
                        habitOther.setRecurrence(habitOther.getRecurrence() == HabitRecurrence.DAILY ? HabitRecurrence.WEEKLY : HabitRecurrence.DAILY);
                        assertNotEquals(habit, habitOther);
                        */
                    }
                }
            }
        }
    }

    @Test
    public void toStringTest() {
        for(Long id : idList) {
            for(String name : nameList) {
                for(HabitRecurrence recurrence : recurrenceList) {
                    for(String description : descriptionList) {
                        Habit habit = new Habit(id, name, recurrence, description);
                        String expected = "Habit [id=" + id + ", name=" + name + ", recurrence=" + recurrence.name() + ", description="
                        + description +"]";
                        assertEquals(expected, habit.toString());
                    }
                }
            }
        }
    }
}
