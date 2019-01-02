<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Forum</title>
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
    <form name="text" action= "/forums/${forumDTO.id}" method="post">
        <p>Enter new message: </p>
        <input title="Text" type="text" name="text">
        <input type="submit" value="OK">
    </form>
    <p>${forumDTO.info}</p>
    <table>
        <tr>
            <th>Id</th>
            <th>Text</th>
            <th>User</th>
            <th>Date</th>
        </tr>
    <#list messagesDTO as publicMessageDTO>
        <tr>
            <td>${publicMessageDTO.id}</td>
            <td>${publicMessageDTO.text}</td>
            <td><a href="/user/${publicMessageDTO.senderId}">${publicMessageDTO.senderLogin}</a></td>
            <td>${publicMessageDTO.date}</td>
        </tr>
    </#list>

    </table>
</center>

</body>
</html>