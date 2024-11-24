package priority;

public class PriorityItem<T> implements Comparable<PriorityItem> {
    private T item;
    private int priority;
    public PriorityItem(T item, int priority) {
        this.item = item;
        this.priority = priority;
    }
    public T getItem() {
        return item;
    }
    public int getPriority() {
        return priority;
    }
    @Override
    public int compareTo(PriorityItem o) {
        return Integer.compare(priority, o.priority);
    }
}
