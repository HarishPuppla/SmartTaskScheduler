import java.time.LocalDateTime;

public class Task implements Comparable<Task> {
    private String title;
    private int priority; // 1 = High, 2 = Medium, 3 = Low
    private LocalDateTime deadline;

    public Task(String title, int priority, LocalDateTime deadline) {
        this.title = title;
        this.priority = priority;
        this.deadline = deadline;
    }

    public String getTitle() { return title; }
    public int getPriority() { return priority; }
    public LocalDateTime getDeadline() { return deadline; }

    @Override
    public int compareTo(Task other) {
        if (!this.deadline.equals(other.deadline)) {
            return this.deadline.compareTo(other.deadline);
        }
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        String p = switch (priority) {
            case 1 -> "High";
            case 2 -> "Medium";
            case 3 -> "Low";
            default -> "Unknown";
        };
        return "[" + p + "] " + title + " - Due: " + deadline.toString();
    }
}
