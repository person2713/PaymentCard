<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>ForgotPassword</title>
    <link href="/static/images/favicon%20(3).ico" rel="shortcut icon" type="image/x-icon" />
</head>
<body>
Enter your registered email address:
<form action="resetPassword" method="post">
    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
    <table>
        <tr>

            <td colspan="2"><input type="text" name="email"> </td>
        </tr>

        <tr>
            <td><input type="Submit" value="Reset Password">  </td>
            <td><input type="reset" value="Cancel">  </td>
        </tr>

    </table>
</form>
</body>
</html>