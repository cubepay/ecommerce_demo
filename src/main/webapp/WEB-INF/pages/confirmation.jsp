<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<title>Checkout Demo</title>
	<link href="<c:url value="/resources/css/global.css" />" rel="stylesheet">

	<script type="text/javascript">
        var uri = window.location.toString();
        if (uri.indexOf("?") > 0) {
            var clean_uri = uri.substring(0, uri.indexOf("?"));
            window.history.replaceState({}, document.title, clean_uri);
        }
    </script>
</head>

<c:set var="context" value="${pageContext.request.contextPath}"/>

<body>
    <c:choose>
          <c:when test="${success && !cancel}">
            <ul class='item-list'>
                <li class='item'>
                    <div class='item__information'>
                      <div class='item__body2'>
                        <h2 class='item__title'>Payment has been approved</h2>
                        <p class='item__description'>Receipt will be sent to your email.</p>
                      </div>
                    </div>
                  </li>
                  <li class='item'>
                      <div class='item__information'>
                        <div class='item__body2'>
                          <h2 class='item__title'>Items Ordered</h2>
                          <p class='item__description'>Total Amount</p>
                        </div>
                        <div class='item__price js-item-price' data-price='11.88'>$${amount}</div>
                      </div>
                    </li>
                    <li class='item'>
                        <div class='item__information'>
                          <div class='item__body2'>
                            <h2 class='item__title'>Payment Information</h2>
                            <p class='item__description'>Payment Method : ${paymentMethod}</p>
                            <p class='item__description'>Transaction Id : ${transactionId}</p>
                            <p class='item__description'>Reference No : ${refNo}</p>

                          </div>
                        </div>
                      </li>
            </ul>
          </c:when>

          <c:when test="${!success && cancel}">
              <ul class='item-list'>
                           <li class='item'>
                               <div class='item__information'>
                                 <div class='item__body2'>
                                   <h2 class='item__title'><font color="red">You have cancelled your transaction.</font></h2>
                                 </div>
                               </div>
                             </li>
                           </ul>
            </c:when>

          <c:otherwise>
            <ul class='item-list'>
             <li class='item'>
                 <div class='item__information'>
                   <div class='item__body2'>
                     <h2 class='item__title'><font color="red">Your transaction cannot be processed.</font></h2>
                     <p class='item__description'>Please contact administrator.</p>
                   </div>
                 </div>
               </li>
             </ul>
          </c:otherwise>
    </c:choose>

    <div class='summary js-summary'>
        <ul class='checkout'>
            <li>
              <a class='button js-checkout-button' href="${context}">Go Back</a>
            </li>
          </ul>
     </div>
</body>

</html>
