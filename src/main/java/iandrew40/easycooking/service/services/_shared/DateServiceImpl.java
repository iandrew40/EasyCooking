package iandrew40.easycooking.service.services._shared;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DateServiceImpl implements DateService{

    @Override
    public LocalDate getCurrentDate() {
        LocalDate localDate = LocalDate.now();
        return localDate;
    }
}
