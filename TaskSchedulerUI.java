import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskSchedulerUI {
    private TaskManager manager = new TaskManager();
    private DefaultListModel<Task> listModel = new DefaultListModel<>();
    private JList<Task> taskJList = new JList<>(listModel);

    public TaskSchedulerUI() {
        JFrame frame = new JFrame("Smart Task Scheduler");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");

        addButton.addActionListener(e -> showAddDialog());
        deleteButton.addActionListener(e -> {
            Task selected = taskJList.getSelectedValue();
            if (selected != null) {
                manager.removeTask(selected);
                listModel.removeElement(selected);
            }
        });

        JPanel panel = new JPanel();
        panel.add(addButton);
        panel.add(deleteButton);

        taskJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        frame.add(new JScrollPane(taskJList), BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void showAddDialog() {
        JTextField titleField = new JTextField();
        JComboBox<String> priorityBox = new JComboBox<>(new String[]{"High", "Medium", "Low"});
        JTextField deadlineField = new JTextField("yyyy-MM-dd HH:mm");

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Priority:"));
        panel.add(priorityBox);
        panel.add(new JLabel("Deadline:"));
        panel.add(deadlineField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add New Task",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String title = titleField.getText();
                int priority = priorityBox.getSelectedIndex() + 1;
                LocalDateTime deadline = LocalDateTime.parse(deadlineField.getText(),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                Task task = new Task(title, priority, deadline);
                manager.addTask(task);
                listModel.addElement(task);
                ReminderService.scheduleReminder(task);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input: " + ex.getMessage());
            }
        }
    }
}
