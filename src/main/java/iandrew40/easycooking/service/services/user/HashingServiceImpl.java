package iandrew40.easycooking.service.services.user;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
public class HashingServiceImpl implements HashingService{

    @Override
    public String hashPassword(String password) {
        return DigestUtils.sha256Hex(password);
    }
}
