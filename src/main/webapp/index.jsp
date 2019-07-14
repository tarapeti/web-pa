<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:url value="/style.css" var="styleUrl"/>
    <c:url value="/index.js" var="indexScriptUrl"/>
    <c:url value="/register.js" var="registerScriptUrl"/>
    <c:url value="/login.js" var="loginScriptUrl"/>
    <c:url value="/profile.js" var="profileScriptUrl"/>
    <c:url value="/products.js" var="productsSriptUrl"/>
    <c:url value="/back-to-profile.js" var="backToProfileScriptUrl"/>
    <c:url value="/logout.js" var="logoutScriptUrl"/>
    <c:url value="/cart.js" var="cartScriptUrl"/>
    <c:url value="/order.js" var="orderScriptUrl"/>
    <link rel="stylesheet" type="text/css" href="${styleUrl}">
    <script src="${indexScriptUrl}"></script>
    <script src="${loginScriptUrl}"></script>
    <script src="${profileScriptUrl}"></script>
    <script src="${productsSriptUrl}"></script>
    <script src="${backToProfileScriptUrl}"></script>
    <script src="${logoutScriptUrl}"></script>
    <script src="${cartScriptUrl}"></script>
    <script src="${orderScriptUrl}"></script>
    <title>Sk8Shop</title>
</head>
<body>
<div id="topnav" class="hidden content">
    <a id="logout-menu-button" class="active" href="javascript:void(0);">Logout</a>
    <a href="javascript:void(0);" onclick="onAllProductsClicked()">All products</a>
    <a href="javascript:void(0);" onclick="onSignaturesClicked();">Signature kits</a>
    <a href="javascript:void(0);" onclick="onCartClikced();">Cart</a>
</div>


<div id="welcome" class="hidden content">
    <h1>Welcome</h1>
    <h2>Founder:</h2>
    <ul>
        <li><h3>Péter Taraszvics</h3></li>
    </ul>
</div>

<div id="reg-content" class="hidden content">
    <h1>Registration</h1>
    <form id="reg-form" onsubmit="return false;">
        Name: <input type="text" name="name" required placeholder="First name">
        <br>
        E-mail: <input type="email" name="email" required placeholder="E-mail">
        <br>
        Password: <input type="password" name="password" required placeholder="*****">
        <br>
        Role:
        <button id="reg-button" onclick="onRegisterButtonClicked()">Register</button>
    </form>
</div>

<div id="login-content" class="content">
    <h1>Login</h1>
    <form id="login-form" onsubmit="return false;">
        <input type="text" name="email" required>
        <input type="password" name="password" required>
        <button id="login-button">Login</button>
        <button id="go-reg-button" onclick="showRegisterDiv()">Register</button>
    </form>
</div>

<div id="back-to-profile-content" class="hidden content">
    <br>
    <button onclick="onBackToProfileClicked();">Back to profile</button>
</div>

<div id="profile-content" class="hidden content">

</div>

<div id="product-content" class="hidden content">
    <a href="javascript:void(0);" onclick="onAllGripsClicked();">Grips</a><br>
    <a href="javascript:void(0);" onclick="onAllDecksClicked();">Decks</a><br>
    <a href="javascript:void(0);" onclick="onAllTrucksClicked();">Trucks</a><br>
    <a href="javascript:void(0);" onclick="onAllWheelsClicked();">Wheels</a><br>
    <a href="javascript:void(0);" onclick="onAscendingOrderClicked();">All products ascending order</a><br>
    <a href="javascript:void(0);" onclick="onDescendingOrederClicked();">All products descending order</a>
</div>

<div id="product-display" class="hidden content"></div>

<div id="cart-display" class="hidden content"></div>

<div id="logout-content" class="hidden content">
    <button id="logout-button">Logout</button>
</div>

</body>
</html>
