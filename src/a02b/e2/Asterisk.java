package a02b.e2;

public class Asterisk {
    public enum Direction {
        UP,
        RIGHT,
        DOWN,
        LEFT
    }
    private Pair<Integer,Integer> position;
    private Direction currentDirection;

    public void move() {
        switch (currentDirection) {
            case RIGHT:
                position = new Pair<>(position.getX() + 1, position.getY());
                break;
            case LEFT:
                position = new Pair<>(position.getX() - 1, position.getY());
                break;
            case UP:
                position = new Pair<>(position.getX(), position.getY() + 1);
                break;
            case DOWN:
                position = new Pair<>(position.getX(), position.getY() - 1);
                break;
        
            default:
                break;
        }
    }
}
