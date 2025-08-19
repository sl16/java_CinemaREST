package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class StatsController {
    private final CinemaRoom cinemaRoom;

    public StatsController(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    @GetMapping("/stats")
    public ResponseEntity<?> getStats(@RequestParam(required = false) String password) {
        if (!"super_secret".equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "The password is wrong!"));
        }
        int income = cinemaRoom.getCurrentIncome();
        int available = cinemaRoom.getAvailableSeatsCount();
        int purchased = cinemaRoom.getPurchasedTicketsCount();
        return ResponseEntity.ok(Map.of(
                "income", income,
                "available", available,
                "purchased", purchased
        ));
    }
}