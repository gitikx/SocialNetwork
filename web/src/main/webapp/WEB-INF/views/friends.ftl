<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My Friends</title>
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
    <form name="user" action="/searchUser" method="post">
        <p>Search user: </p>
        <input title="Name" type="text" name="name">
        <input title="Surname" type="text" name="surname">
        <input type="submit" value="OK">
    </form>
    <table>
        <tr>
            <th>Login of friend</th>
        </tr>
    <#list users as userDTO>
        <tr>
            <td><a href="/user/${userDTO.id}">${userDTO.login}</a></td>
            <#if isSearch = 0>
            <td><a href="/deleteFriend/${userDTO.id}">Delete Friend</a></td>
            </#if>
        </tr>
    </#list>
    </table>
     <#if isSearch = 0>
    <table>
        <tr>
            <th>Requests</th>
        </tr>
    <#list requests as user>
        <tr>
            <td><a href="/user/${user.id}">${user.login}</a></td>
            <td><a href="/deleteFriend/${user.id}">Decline</a></td>
            <td><a href="/acceptFriend/${user.id}">Accept</a></td>
        </tr>
    </#list>
    </table>
     </#if>
</center>
</body>
</html>