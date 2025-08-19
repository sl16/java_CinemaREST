package cinema;

import cinema.exception.SeatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PurchaseController {
    private final CinemaRoom cinemaRoom;

    public PurchaseController(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseSeat(@RequestBody Map<String, Integer> request) {
        try {
            int row = request.get("row");
            int column = request.get("column");
            Seat seat = cinemaRoom.purchaseSeat(row, column);
            return ResponseEntity.ok(Map.of(
                    "price", seat.getPrice(),
                    "row", seat.getRow(),
                    "column", seat.getColumn()
            ));
        } catch (SeatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        }
    }
}