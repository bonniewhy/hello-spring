package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
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
                "<option value='spa'>Spanish</option>" +
                "<option value='fre'>French</option>" +
                "<option value='jap'>Japanese</option>" +
                "<option value='rus'>Russian</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me!' />" +
                "</form>";

        return html;
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    // public String helloPost(HttpServletRequest request) {

    // }

    public static String createMessage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String lang = request.getParameter("lang");

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
        }
        else {
            return "Sorry, I don't know that language. D:";
        }
    }

    @RequestMapping(value = "goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye...";
    }

}
