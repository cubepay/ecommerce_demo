<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<title>Checkout Demo</title>
	<link href="<c:url value="/resources/css/global.css" />" rel="stylesheet">
</head>

<c:set var="context" value="${pageContext.request.contextPath}"/>

<body>
    <c:choose>
          <c:when test="${success}">
            <ul class='item-list'>
                    <li class='item'>
                        <div class='item__information'>
                          <div class='item__body2'>
                            <h2 class='item__title'>Payment has been approved</h2>
                            <p class='item__description'>Receipt will be sent to your email.</p>
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
                     <h2 class='item__title'><font color="red">Oopss..something wrong just happened</font></h2>
                     <p class='item__description'>Please try again.</p>
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
