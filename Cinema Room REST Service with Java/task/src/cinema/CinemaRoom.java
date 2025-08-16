package cinema;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class CinemaRoom {
    private int rows;
    final private int columns;
    final private List<List<Seat>> seats;

    CinemaRoom(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        seats = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            List<Seat> rowList = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                rowList.add(new Seat(i + 1, j + 1));
            }
            seats.add(rowList);
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public List<List<Seat>> getSeats() {
        return seats;
    }

    public void printSeats() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("[%d][%d] ", seats.get(i).get(j).getRow(), seats.get(i).get(j).getColumn());
            }
            System.out.println();
        }

    }
}
