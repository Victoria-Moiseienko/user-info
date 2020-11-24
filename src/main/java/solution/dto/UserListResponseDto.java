package solution.dto;

import java.util.List;
import lombok.Data;

@Data
public class UserListResponseDto {
    private List<UserResponseDto> results;
}
