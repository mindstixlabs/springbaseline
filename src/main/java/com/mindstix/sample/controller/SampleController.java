/**
 * Released under the Creative Commons License.
 */
package com.mindstix.sample.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

/**
 * Sample spring MVC controller.
 *
 * @author: Roshan Kulkarni
 */
@Controller
public class SampleController {

    // Get log4j handler
    private static final Logger logger = Logger.getLogger(SampleController.class);

    // Controller Action
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        // Some business logic here
        logger.error("Testing Log Message");

        // Render a view
        model.addAttribute("message", "Spring 3 MVC Hello World");
        return "hello";

    }

}
