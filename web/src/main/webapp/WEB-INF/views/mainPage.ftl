<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My Page</title>
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
    <form name="newsDTO" action="/addNews" method="post">
        <p>Add new message to your friends</p>
        <input title="Name" type="text" name="text">
        <input type="submit" value="OK">
    </form>
    <table>
        <tr>
            <th>Login</th>
            <th>Text</th>
        </tr>
    <#list news1 as newsDTO>
        <tr>
            <td><a href="/user/${newsDTO.userId}">${newsDTO.userLogin}</a></td>
            <td>${newsDTO.text}</td>
        </tr>
    </#list>

    </table>
</center>

</body>
</html>