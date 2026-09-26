package topic_2.assignment_problems;

public class TrafficLight {
    private static final String[] COLORS = {"RED", "GREEN", "YELLOW"};
    private final String id;
    private int colorIndex;

    public TrafficLight(String id) {
        this.id = id;
    }

    public String getColor() {
        return COLORS[colorIndex];
    }

    public void next() {
        colorIndex = (colorIndex + 1) % COLORS.length;
    }

    public String getId() {
        return id;
    }
}
