<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Messages</title>
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
    <table>
        <tr>
            <th>Sender login</th>
            <th>Text</th>
            <th>Date</th>
        </tr>
    <#list messages as privateMessageDTO>
        <tr>
            <td><a href="/user/${privateMessageDTO.senderId}">${privateMessageDTO.senderLogin}</a></td>
            <td>${privateMessageDTO.text}</td>
            <td>${privateMessageDTO.date}</td>
        </tr>
    </#list>
    </table>
    <#if isFriend = true>
    <form name="text" action="/messages/${friendId}" method="post">
        <p>Send message</p>
        <input title="text" type="text" name="text">
        <input type="submit" value="Send">
    </form>
    </#if>
</center>

</body>
</html>