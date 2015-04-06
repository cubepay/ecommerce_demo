package com.company.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by tsagita on 6/3/15.
 */
@Controller
@RequestMapping("/")
public class CheckoutDemoController {
    public static final String REFERENCE_NO = "referenceNo";
    @Autowired
    private Util util;

    @RequestMapping(method = RequestMethod.GET)
    public String showCheckout(HttpServletRequest request) {
        Long referenceNo = (Long) request.getSession().getAttribute(REFERENCE_NO);
        if(referenceNo == null) {
            request.getSession().setAttribute(REFERENCE_NO, new Long(10000001));
        }

        return "checkout";
    }

    @RequestMapping(method = RequestMethod.POST, value = "checkout")
    public String checkout(HttpServletRequest request) {
//        String mjAmt = request.getParameter("mjAmt");
//        String mjQty = request.getParameter("mjQty");
//        String dpAmt = request.getParameter("dpAmt");
//        String dpQty = request.getParameter("dpQty");
        String total = request.getParameter("total");
//
//        request.getSession().setAttribute("mjAmt", mjAmt);
//        request.getSession().setAttribute("mjQty", mjQty);
//        request.getSession().setAttribute("dpAmt", dpAmt);
//        request.getSession().setAttribute("dpQty", dpQty);
//        request.getSession().setAttribute("total", total);

        Long referenceNo = (Long) request.getSession().getAttribute(REFERENCE_NO);
        request.getSession().setAttribute(REFERENCE_NO, referenceNo + 1);

        String paymentLoggingUrl = util.getPaymentLoggingUrl();

        total=total.substring(1,total.length());
        return "redirect:" + paymentLoggingUrl
                + "?url=" + util.getURLWithContextPath(request) + "/confirmation"
                + "&transaction_type=authorization"
                + "&merchant_id=1"
                + "&req_reference_number=" + referenceNo
                + "&amount=" + total
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
    public String showConfirmation(@RequestParam(value = "success", required = false) boolean success,
                                   @RequestParam(value = "cancel", required = false) boolean cancel,
                                   @RequestParam(value = "transaction_id", required = false) String transactionId,
                                   @RequestParam(value = "payment_method", required = false) String paymentMethod,
                                   @RequestParam(value = "auth_ref_no", required = false) String authRefNo,
                                   @RequestParam(value = "reference_no", required = false) String refNo,
                                   @RequestParam(value = "auth_amount", required = false) String amount,
                                   @RequestParam(value = "card_no", required = false) String cardNo,
                                   ModelMap model) {

        model.addAttribute("success", success);
        model.addAttribute("cancel", cancel);
        model.addAttribute("transactionId", transactionId);
        model.addAttribute("paymentMethod", paymentMethod);
        model.addAttribute("refNo", refNo);
        model.addAttribute("authRefNo", authRefNo);
        model.addAttribute("amount", amount);
        model.addAttribute("cardNo", cardNo);
        model.addAttribute("amount", amount);

        return "confirmation";
    }
}
