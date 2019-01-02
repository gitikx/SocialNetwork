<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>About</title>
</head>
<body>
<center>
    <a href="/myPage">My page </a>
    <a href="/aboutMe">About Me </a>
    <a href="/friends">Friends </a>
    <a href="/messages">Messages </a>
    <a href="/forums">Forums</a>
</center>
<center>
    <h1 style="color:#ff0000">${info.name} ${info.surname}</h1>
    <p>Country: ${info.country}</p>
    <p>Login: ${info.login}</p>
    <p>Birthday: ${info.birthday}</p>
    <p>About: ${info.about}</p>
    <form name="info" action="/updateInfo" method="post">
         <p>Name</p>
         <input title="Name" type="text" name="name">
         <p>Surname</p>
         <input title="Surname" type="text" name="surname">
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