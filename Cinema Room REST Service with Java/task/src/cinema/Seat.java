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

    public int getPrice() { return price; }

    void setRow(int row) {
        this.row = row;
    }

    void setColumn(int column) {
        this.column = column;
    }

    void setPurchased() {
        this.purchased = true;
    }
}

