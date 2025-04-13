package shapes;

public class Square {
    private int sideLength;

    public Square(int sideLength) {
        this.sideLength = sideLength;
    }

    public int getSideLength() {
        return sideLength;
    }

    public String render() {
    
        return "Expected rendering output for Square";
    }
}
