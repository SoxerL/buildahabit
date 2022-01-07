package net.ddns.buildahabit.habit;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface HabitRepository extends CrudRepository<Habit, Long> {
    List<Habit> findByName(String habitName);
    List<Habit> findByRecurrence(HabitRecurrence recurrence);
}
