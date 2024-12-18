package factories;

public class NamedRunnable implements Runnable {
    private final Runnable task; // Оригинальная логика функции
    private final String name;   // Название функции

    public NamedRunnable(Runnable task, String name) {
        this.task = task;
        this.name = name;
    }

    @Override
    public void run() {
        task.run();
    }

    public String getName() {
        return name;
    }
}
