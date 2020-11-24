package solution.dto;

import lombok.Data;
import solution.model.Location;
import solution.model.Picture;
import solution.model.UserName;

@Data
public class UserResponseDto {
    private UserName name;
    private Picture picture;
    private String gender;
    private String email;
    private String phone;
    private String nat;
    private Location location;
}
