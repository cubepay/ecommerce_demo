<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<title>Checkout Demo</title>
	<link href="<c:url value="/resources/css/global.css" />" rel="stylesheet">
</head>

<c:set var="context" value="${pageContext.request.contextPath}"/>

<body>
        <ul class='item-list'>
          <li class='item'>
            <div class='item__information'>
              <div class='item__image'>
                <img src='http://www.arizonafoothillsmagazine.com/valleygirlblog/wp-content/uploads/michael-jackson-dangerous.jpg'>
              </div>
              <div class='item__body'>
                <h2 class='item__title'>Dangerous</h2>
                <p class='item__description'>Dangerous is the eighth studio album by American recording artist Michael Jackson. It was released on November 26, 1991 by Epic Records.</p>
              </div>
              <div class='item__price js-item-price' data-price='11.88'>$11.88</div>
            </div>
            <div class='item__interactions'>
              <p class='item__quantity'>
                <a class='js-item-increase' title='Add another copy'>+</a>
                <a class='js-item-decrease decrease--disabled' title='Remove a copy'>-</a>
                <span data-quantity='1'>
                  <b>1</b>
                  copy
                </span>
                at $11.88
              </p>
              <a class='item__remove js-item-remove' title='Remove this item'>&times;</a>
            </div>
          </li>
            <li class='item'>
            <div class='item__information'>
              <div class='item__image'>
                <img src='http://upload.wikimedia.org/wikipedia/en/a/a7/Random_Access_Memories.jpg'>
              </div>
              <div class='item__body'>
                <h2 class='item__title'>Random Access Memories</h2>
                <p class='item__description'>Random Access Memories is the fourth studio album by French electronic music duo Daft Punk.</p>
              </div>
              <div class='item__price js-item-price' data-price='11.88'>$11.88</div>
            </div>
            <div class='item__interactions'>
              <p class='item__quantity'>
                <a class='js-item-increase' title='Add another copy'>+</a>
                <a class='js-item-decrease decrease--disabled' title='Remove a copy'>-</a>
                <span data-quantity='1'>
                  <b>1</b>
                  copy
                </span>
                at $11.88
              </p>
              <a class='item__remove js-item-remove' title='Remove this item'>&times;</a>
            </div>
          </li>
        </ul>

        <div class='summary js-summary'>
          <ul class='steps'>
            <li>
              <b>Subtotal:</b>
              <span class='sum js-subtotal'>$32.86</span>
            </li>
            <li>
              <b>Taxes (5%):</b>
              <span class='sum js-taxes'>$1.64</span>
            </li>
            <li>
              <b>Shipping:</b>
              <span class='sum js-shipping'>$5.00</span>
            </li>
          </ul>
          <ul class='checkout'>
            <li>
              <b>Total:</b>
              <span class='sum js-total'>$39.50</span>
            </li>
            <li>
              <a class='button js-checkout-button' href="${context}/checkout">Checkout</a>
            </li>
          </ul>
        </div>
</body>

<script type="text/javascript" src="<c:url value='/resources/js/checkout.js' /> "></script>

</html>
