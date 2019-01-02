<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register New User</title>
</head>
<body>
<center>
    <form name="user" action="/register" method="post">
        <p>Name</p>
        <input title="Name" type="text" name="name">
        <p>Surname</p>
        <input title="Surname" type="text" name="surname">
        <p>Login</p>
        <input title="Login" type="text" name="login">
        <p>Password</p>
        <input title="Password" type="password" name="password">
        <p>Name of Your Country</p>
        <input title="Country" type="text" name="country">
        <p>About</p>
        <input title="Text about" type="text" name="about">
        <p>Birthday Date</p>
        <input title="Age" type="date" name="birthday">
        <input type="submit" value="OK">
    </form>
</center>
</body>
</html>