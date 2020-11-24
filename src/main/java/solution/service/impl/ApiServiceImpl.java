package solution.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;
import solution.dto.UserListResponseDto;
import solution.service.ApiService;

@Service
public class ApiServiceImpl implements ApiService {
    private static final String URL = "https://randomuser.me/api/?results=20";
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private final ObjectMapper mapper;

    public ApiServiceImpl(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public UserListResponseDto getUserData() {
        HttpGet request = new HttpGet(URL);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            return mapper.readValue(response.getEntity().getContent(), UserListResponseDto.class);
        } catch (IOException e) {
            throw new RuntimeException("Can't send request to " + URL, e);
        }
    }
}
