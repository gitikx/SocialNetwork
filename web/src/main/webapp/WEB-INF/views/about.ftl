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
    <p>Country: ${info.login}</p>
    <p>Birthday: ${info.birthday}</p>
    <p>About: ${info.about}</p>
    <#if isFriend == true>
         <td><a href="/deleteFriend/${info.id}">Delete friend</a></td>
    <#else>
     <td><a href="/addFriend/${info.id}">Add friend</a></td>
    </#if>
</center>
</body>
</html>