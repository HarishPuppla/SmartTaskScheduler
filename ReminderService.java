import java.util.Timer;
import java.util.TimerTask;
import java.time.Duration;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class ReminderService {
    private static Timer timer = new Timer();

    public static void scheduleReminder(Task task) {
        Duration delay = Duration.between(LocalDateTime.now(), task.getDeadline());
        if (!delay.isNegative()) {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(null,
                            "Reminder: " + task.getTitle() + " is due now!",
                            "Task Reminder",
                            JOptionPane.WARNING_MESSAGE);
                }
            }, delay.toMillis());
        }
    }
}
