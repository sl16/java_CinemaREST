package cinema;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class SeatController {
    private final CinemaRoom cinemaRoom;

    public SeatController(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    @GetMapping("/seats")
    public SeatResponse returnSeats() {
//        cinemaRoom.printSeats();
        return new SeatResponse(cinemaRoom.getRows(), cinemaRoom.getColumns(), cinemaRoom.getSeats());
    }

    @GetMapping("/test")
    public List<String> returnTest() {
        return (List.of("kokot", "velky"));
    }
}