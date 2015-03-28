package com.company.web;

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

        return "redirect:" + paymentLoggingUrl
                + "?url=" + util.getURLWithContextPath(request) + "/confirmation"
                + "&transaction_type=authorization"
                + "&merchant_id=1"
                + "&req_reference_number=5001"
                + "&amount=50"
                + "&currency=SGD"
                + "&locale=en";
    }

    @RequestMapping(method = RequestMethod.GET, value = "cybersource")
    public String getCybersource(HttpServletRequest request) {

        return "payment_form";
    }

    @RequestMapping(method = RequestMethod.POST, value = "postcybersource")
    public String postToCyberSource(HttpServletRequest request) {

        return "payment_confirmation";
    }

    @RequestMapping(method = RequestMethod.GET, value = "confirmation")
    public String showConfirmation(@RequestParam(value = "success") boolean success,
                                   @RequestParam(value = "transaction_id", required = false) String transactionId,
                                   @RequestParam(value = "payment_method", required = false) String paymentMethod,
                                   @RequestParam(value = "card_type", required = false) String cardType,
                                   @RequestParam(value = "bill_to_forename", required = false) String firstName,
                                   @RequestParam(value = "bill_to_surname", required = false) String surname,
                                   @RequestParam(value = "bill_to_address_line1", required = false) String address,
                                   @RequestParam(value = "bill_to_address_city", required = false) String city,
                                   @RequestParam(value = "bill_to_address_country", required = false) String country,
                                   ModelMap model) {

        model.addAttribute("success", success);
        model.addAttribute("transactionId", transactionId);
        model.addAttribute("paymentMethod", paymentMethod);
        model.addAttribute("cardType", cardType);
        model.addAttribute("firstName", firstName);
        model.addAttribute("surname", surname);
        model.addAttribute("address", address);
        model.addAttribute("city", city);
        model.addAttribute("country", country);

        return "confirmation";
    }
}
