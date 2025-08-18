package cinema;

import java.util.ArrayList;
import java.util.List;

public class SeatResponse {
    final private int rows;
    final private int columns;
    final private int price;
    final private List<Seat> seats;

    public SeatResponse(int rows, int columns, int price, List<List<Seat>> seatList) {
        this.rows = rows;
        this.columns = columns;
        this.price = price;
        this.seats = new ArrayList<>();
        for (List<Seat> row : seatList) {
            seats.addAll(row);
        }
    }

    // Getters
    public int getRows() { return rows; }
    public int getColumns() { return columns; }
    public int getPrice() { return price; }
    public List<Seat> getSeats() { return seats; }
}