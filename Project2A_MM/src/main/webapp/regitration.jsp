<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
    <script>
        function validateForm() {
            const email = document.forms["regForm"]["email"].value;
            if (!email.includes("@")) {
                alert("Enter a valid email!");
                return false;
            }
        }
    </script>
</head>
<body>
    <h1>User Registration</h1>
    <img src="Logo.png" alt="Conference Logo" width="100"/>

    <form name="regForm" method="post" action="RegisterServlet" onsubmit="return validateForm();">
        <label>Company: <input type="text" name="company" required /></label><br/>
        <label>First name: <input type="text" name="firstname" required /></label><br/>
        <label>Last name: <input type="text" name="lastname" required /></label><br/>
        <label>Email: <input type="email" name="email" required /></label><br/>
        <label>Sector:
            <select name="sector">
                <option value="Manufacturing">Manufacturing</option>
                <option value="IT">IT</option>
            </select>
        </label><br/>
        <label>Dietary Requirements: <input type="text" name="dietary" /></label><br/>
        <label>Parking Required: <input type="checkbox" name="parking" /></label><br/>
        <input type="submit" value="Register Now"/>
    </form>
</body>
</html>