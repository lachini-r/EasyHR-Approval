package HR;

import java.util.concurrent.atomic.AtomicInteger;

public class Employee {
    private static final AtomicInteger idCounter = new AtomicInteger(0);
    private int id;
    private String name;
    private String position;
    private boolean isApproved;

    public Employee(String name, String position) {
        this.id = idCounter.incrementAndGet();
        this.name = name;
        this.position = position;
        this.isApproved = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void approve() {
        this.isApproved = true;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', position='" + position + "', isApproved=" + isApproved + "}";
    }
}
