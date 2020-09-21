package marsroverapp.web;

import marsroverapp.model.dto.HomeDto;
import marsroverapp.model.entity.MarsRoverAppResponse;
import marsroverapp.model.service.MarsRoverAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private MarsRoverAppService marsRoverAppService;


    @GetMapping("/")
    public String home(Model model, HomeDto homeDto){

        //if request param is empty, then set a default value
        if (StringUtils.isEmpty(homeDto.getMarsApiRoverData())){
            homeDto.setMarsApiRoverData("Opportunity");
        }
        if (homeDto.getMarsSol() == null)
            homeDto.setMarsSol(1);
        MarsRoverAppResponse roverDate = marsRoverAppService.getRoverDate(homeDto.getMarsApiRoverData(), homeDto.getMarsSol());
        model.addAttribute("roverDate",roverDate);
        model.addAttribute("homeDto",homeDto);

        return "index";
    }

}
