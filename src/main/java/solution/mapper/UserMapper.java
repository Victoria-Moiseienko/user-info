package solution.mapper;

import org.springframework.stereotype.Component;
import solution.dto.UserResponseDto;
import solution.model.User;

@Component
public class UserMapper {

    public User toUser(UserResponseDto dto) {
        User user = new User();
        user.setName(dto.getName().getTitle() + " "
                + dto.getName().getFirst() + " "
                + dto.getName().getLast());
        user.setLargePicture(dto.getPicture().getLarge());
        user.setThumbnailPicture(dto.getPicture().getThumbnail());
        user.setEmail(dto.getEmail());
        user.setGender(dto.getGender());
        user.setNat(dto.getNat());
        user.setPhone(dto.getPhone());
        user.setAddress(dto.getLocation().getCountry()
                + ", " + dto.getLocation().getCity());
        return user;
    }
}
