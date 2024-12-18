package Factories;

public class NamedRunnable implements Runnable {
    private final Runnable task;
    private final String name;

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
