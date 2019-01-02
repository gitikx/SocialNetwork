<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Forums</title>
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
    <form name="forumDTO" action="/registerForum" method="post">
        <p>Register your forum, set info: </p>
        <input title="Info" type="text" name="info">
        <input type="submit" value="OK">
    </form>
    <table>
        <tr>
            <th>Id</th>
            <th>Text</th>
            <th>Admin</th>
        </tr>
    <#list forums as forumDTO>
        <tr>
            <td><a href="/forums/${forumDTO.id}">${forumDTO.id}</a></td>
            <td>${forumDTO.info}</td>
            <td><a href="/user/${forumDTO.adminLogin}">${forumDTO.adminLogin}</a></td>
        </tr>
    </#list>

    </table>
</center>

</body>
</html>