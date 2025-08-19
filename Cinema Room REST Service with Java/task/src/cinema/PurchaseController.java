package cinema;

import cinema.exception.SeatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class PurchaseController {
    private final CinemaRoom cinemaRoom;
    private final Map<UUID, Seat> purchasedTickets = new ConcurrentHashMap<>();

    public PurchaseController(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseSeat(@RequestBody Map<String, Integer> request) {
        try {
            int row = request.get("row");
            int column = request.get("column");
            Seat seat = cinemaRoom.purchaseSeat(row, column);
            UUID token = UUID.randomUUID();
            purchasedTickets.put(token, seat);
            return ResponseEntity.ok(Map.of(
                    "ticket", Map.of(
                        "price", seat.getPrice(),
                        "column", seat.getColumn(),
                        "row", seat.getRow()
                    ),
                    "token", token.toString()
            ));
        } catch (SeatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@RequestBody Map<String, String> request) {
        try {
            UUID token = UUID.fromString(request.get("token"));
            Seat seat = purchasedTickets.remove(token);
            if (seat == null) {
                throw new SeatException("Wrong token!");
            }
            seat.setPurchased(false);
            return ResponseEntity.ok(Map.of(
                "ticket", Map.of(
                    "price", seat.getPrice(),
                    "column", seat.getColumn(),
                    "row", seat.getRow()
                )
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Wrong token!"));
        }
    }
}