<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content='true' name='HandheldFriendly' />
    <meta content='width' name='MobileOptimized' />
    <meta content='yes' name='apple-mobile-web-app-capable' />
    <title>Авторизация</title>
    <link rel="stylesheet" href="styles/style.css"/>
</head>

<body>
<div class="content">
    <form action="#" method="post">
        <div class="container signup">
            <div>
                <img class="logo" src="<c:url value="/pictures/logo.png"/>" alt="Logo">
            </div>

            <h1>Авторизация</h1>
            <hr>

            <label for="email" class="bold">Электронная почта</label>
            <input type="email" placeholder="something@mail.ru" id="email" name="email" class="pop_field" required>
            <span class="pop_msg">Формат адреса: something@mail.ru</span>

            <label for="pwd" class="bold">Пароль</label>
            <input type="password" class="pwd pop_field" minlength="6" placeholder="qW1!eR2@tY3#" id="pwd" name="pwd" required>
            <span class="pop_msg">Длина пароля должна быть > 6 символов</span>

            <button type="submit" class="registerbtn">Войти</button>
        </div>

        <div class="container signin">
            <p>Нет аккаунта? <a href="/registration">Зарегистрироваться</a></p>
        </div>
    </form>
</div>
</body>

</html>