package jsondemo.data;

import java.time.LocalDate;

public class Task {

    private String description;

    private LocalDate deadline;

    public Task(String description, LocalDate deadline) {
        this.description = description;
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}