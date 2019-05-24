package edu.ufp.afmiguez.tk.ufp_api.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
public class Schedule {

    private DayOfWeek dayOfWeek;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime startTime;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime endTime;

    public Schedule() {
    }


    public Schedule(DayOfWeek day, LocalTime start, LocalTime end) {
        this.dayOfWeek = day;
        this.startTime = start;
        this.endTime = end;
    }

}
