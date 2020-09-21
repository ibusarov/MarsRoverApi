package marsroverapp.model.service;

import marsroverapp.model.entity.MarsRoverAppResponse;

public interface MarsRoverAppService {

    MarsRoverAppResponse getRoverDate(String roverType, Integer marsSol);
}
