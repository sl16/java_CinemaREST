package cinema;

import java.util.ArrayList;
import java.util.List;

public class SeatResponse {
    private int rows;
    private int columns;
    private List<Seat> seats;

    public SeatResponse(int rows, int columns, List<List<Seat>> seatList) {
        this.rows = rows;
        this.columns = columns;
        this.seats = new ArrayList<>();
        for (List<Seat> row : seatList) {
            seats.addAll(row);
        }
    }

    // Getters
    public int getRows() { return rows; }
    public int getColumns() { return columns; }
    public List<Seat> getSeats() { return seats; }
}