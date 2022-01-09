package net.ddns.buildahabit.habitTest;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import net.ddns.buildahabit.habit.Habit;
import net.ddns.buildahabit.habit.HabitController;
import net.ddns.buildahabit.habit.HabitRecurrence;
import net.ddns.buildahabit.habit.HabitRepository;

@ExtendWith(MockitoExtension.class)
public class HabitControllerTest {

    @Mock
    private HabitRepository habitRepository;
    private Habit habit;
    private List<Habit> habitList;

    @InjectMocks
    private HabitController habitController;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        habit = new Habit("exercise", HabitRecurrence.DAILY, "work out everday");
    }

    @AfterEach
    public void tearDown() {
        habit = null;
    }
/* Write RestApi Tests
    @Test
    public void getHabitTest() {
        when(habitRepository.findByName(habit.getName())).thenReturn(List.of(habit));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/habit/name/" + habit.getName())
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(habit)))
                .andDo(MockMvcResultHandlers.print());
    }
    */
}
