package com.company.web;

import com.company.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tsagita on 6/3/15.
 */
@Controller
@RequestMapping("/")
public class CheckoutDemoController {
    @Autowired
    private Util util;

    @RequestMapping(method = RequestMethod.GET)
    public String showCheckout(ModelMap model) {
        return "checkout";
    }

    @RequestMapping(method = RequestMethod.GET, value = "checkout")
    public String checkout(HttpServletRequest request) {

        String paymentLoggingUrl = util.getPaymentLoggingUrl();

        return "redirect:" + paymentLoggingUrl + "?url=" + util.getURLWithContextPath(request) + "/confirmation";
    }

    @RequestMapping(method = RequestMethod.GET, value = "confirmation")
    public String showConfirmation(@RequestParam(value = "success") boolean success,
                                   ModelMap model) {

        model.addAttribute("success", success);

        return "confirmation";
    }
}
