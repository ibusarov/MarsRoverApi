package marsroverapp.model.service.impl;

import marsroverapp.model.entity.MarsRoverAppResponse;
import marsroverapp.model.service.MarsRoverAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MarsRoverAppServiceImpl implements MarsRoverAppService {
    private static final String API_KEY="O7rafhheybpEsFcqLzbqC8vgFmEEQKmRJlq74OdD";
    @Override
    public MarsRoverAppResponse getRoverDate(String roverType, Integer marsSol) {
        RestTemplate rt = new RestTemplate();

        ResponseEntity<MarsRoverAppResponse> response =
                rt.getForEntity("https://api.nasa.gov/mars-photos/api/v1/rovers/"+roverType+"/photos?sol="+marsSol+"&api_key="+API_KEY, MarsRoverAppResponse.class);
       return response.getBody();
    }
}
