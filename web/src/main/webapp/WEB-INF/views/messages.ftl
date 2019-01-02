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
            <th>Login</th>
        </tr>
    <#list users as user>
        <tr>
            <td><a href="/messages/${user.id}">${user.login}</a></td>
        </tr>
    </#list>
    </table>
</center>

</body>
</html>