package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request) {

        String name = request.getParameter("name");

        if (name == null) {
            name = "World";
        }

        return "Hello, " + name + "!";
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {

        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<select name='lang'>" +
                "<option value='eng'>English</option>" +
                "<option value='fre'>French</option>" +
                "<option value='spa'>Spanish</option>" +
                "<option value='rus'>Russian</option>" +
                "<option value='jap'>Japanese</option>" +
                "<input type='submit' value='Greet Me!' />" +
                "</form>";

        return html;

    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request) {

        String name = request.getParameter("name");
        String lang = request.getParameter("lang");

        // [ ] Bonus Mission 1: Add a bit of HTML to the response string to make it look nicer.

        // [ ] Bonus Mission 2: Restructure the code so that the controller class doesn't know anything about the specific languages available. In other words, it asks the model for available languages to present to the user.

        // [ ] Bonus Mission 3: Add some additional output that displays the number of times the user has been greeted. Hint: Use a static property to keep track of the count.

        // [ ] Bonus Mission 4: The bonus mission above doesn't discriminate between requests made by you or somebody else. In other words, it counts total greetings rather than greetings to a specific user. Fix this by using cookies. (See original instructions for how to do this...)

        if (lang.equals("eng")) {
            return "Hello, " + name + "!";
        }
        else if (lang.equals("spa")) {
            return "Hola, " + name + "!";
        }
        else if (lang.equals("fre")) {
            return "Bonjour, " + name + "!";
        }
        else if (lang.equals("jap")) {
            return "Konnichiwa, " + name + "!";
        }
        else if (lang.equals("rus")) {
            return "Privet, " + name + "!";

        } else if (lang.equals("jap")) {

            return "Konnichiwa, " + name + "!";

        } else {

            return "I'm sorry. I don't know that language. D:";
        }

    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name) {

        return "Hello, " + name + "!";

    }

    @RequestMapping(value = "goodbye")
    public String goodbye() {
        return "redirect:/";
    }

}
