package hac.springsimple;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

/** IMPORTANT: IN ORDER TO RUN THIS EXAMPLE YOU NEED TO MANUALLY
 * navigate to
 * http://localhost:8080
 * to see this controller
 */
@Controller
public class SimpleController {

    private String name;

    /**
     * the main page
     */
    @GetMapping("/")
    public String landingPage(Model model) {

        return "welcome"; //view
    }

    /**
     * a controller to handle GET request
     * hello?name=someone
     * a controller to handle a GET request
     *
     * @param username
     * @param model
     * @return
     */
    @GetMapping("/hello")
    public String mainWithParam(@RequestParam(name = "yourname", required = false, defaultValue = "nothing") String username, Model model) {
        // we are sending a variable into the view
        model.addAttribute("message", username);
        // the view: viewmessage.html
        return "viewmessage"; //view
    }

    /**
     * a controller to handle POST
     *
     * @param username
     * @param model
     * @return
     */
    @PostMapping("/hello")
    public String postWithParam(@RequestParam(name = "yourname", required = false, defaultValue = "missing") String username, Model model) {
        // we are sending a variable into the view
        model.addAttribute("yourname", username);
        // the view: welcome.html
        return "welcome"; //view
    }

}