# SmartTaskScheduler

This is a desktop-based *Task Manager* application built in Java using Swing. It allows users to add, edit, delete, and prioritize tasks based on urgency and deadlines. Tasks are ordered using a `PriorityQueue`, and reminders pop up as deadlines approach.


# Features

- ✅ Add tasks with *title*, *priority (High/Medium/Low)*, and *deadline*
- ✅ Automatically sorts tasks by *urgency*
- ✅ Desktop pop-up *reminders* using `Timer`
- ✅ Simple and user-friendly *GUI* built with Java Swing
- ✅ Filter & manage tasks with ease

# Technologies Used

- Java 17+
- Java Swing (for GUI)
- Java Timer & PriorityQueue
- VS Code 

---

# Project Structure

SmartTaskScheduler/
│
├── Task.java # Represents a task (title, deadline, priority)
├── TaskManager.java # Manages tasks in a PriorityQueue
├── ReminderService.java # Schedules desktop reminders
├── TaskSchedulerUI.java # Builds the GUI using Swing
├── Main.java # Program entry point
├── README.md # Project guide
└── tasks.json # (Optional) File to save/load tasks
