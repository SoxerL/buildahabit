package net.ddns.buildahabit.habit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

// TODO safety checks and error handling

@RestController
@RequestMapping("/api/v1/habit")
public class HabitController {
    @Autowired
    private HabitRepository habitRepository;

    @GetMapping
    public Iterable<Habit> findAll() {
        return habitRepository.findAll();
    }

    @GetMapping("name/{habitName}")
    public List<Habit> findByName(@PathVariable String habitName) {
        return habitRepository.findByName(habitName);
    }

    @GetMapping("recurrence/{habitRecurrence}")
    public List<Habit> findByRecurrence(@PathVariable HabitRecurrence habitRecurrence) {
        return habitRepository.findByRecurrence(habitRecurrence);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Habit create(@RequestBody Habit habit) {
        Habit habit1 = habitRepository.save(habit);
        return habit1;
    }

    @DeleteMapping("/id")
    public void delete(@PathVariable long id) {
        habitRepository.deleteById(id);
    }
}
