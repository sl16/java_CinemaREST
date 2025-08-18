package cinema;

public class Seat {
    int row;
    int column;
    int price;
    boolean purchased;

    public Seat() {

    }

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.price = row <= 4 ? 10 : 8;
        this.purchased = false;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    void setRow(int row) {
        this.row = row;
    }

    void setColumn(int column) {
        this.column = column;
    }

    int purchase() {
        if (!purchased) {
            this.purchased = true;
            return (0);
        }
        else
            return (1);
    }
}

