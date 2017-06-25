package com.movietime.service;

import com.movietime.dao.SeatDao;
import com.movietime.dao.ShowDao;
import com.movietime.entity.Seat;
import com.movietime.entity.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    SeatDao seatDao;
    @Autowired
    ShowDao showDao;

    public String[] getSeatMap(long id) {
        Show show = showDao.findOne(id);
        return show.getSeatMap().split("\\|");
    }

    public String[] getSoldSeat(long id) {
        List<Seat> seatList = seatDao.findAllBooked(id);
        List<String> soldSeatList_str = new LinkedList<String>();
        for (Seat seat : seatList) {
            if (seat.isBooked())
                soldSeatList_str.add(seat.getRow() + "_" + seat.getCol());
        }
        return soldSeatList_str.toArray(new String[1]);
    }

    @Transactional
    public boolean book(List<Seat> seatList) {
        for (Seat seat : seatList) {
            if (seatDao.occupied(seat)) return false;
        }
        for (Seat seat : seatList) {
            seatDao.update(seat);
        }
        return true;
    }
}
