<%@ taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Save Customer</title>

<style>
/* Global Reset */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

/* Body and Wrapper */
body {
    font-family: 'Arial', sans-serif;
    background-color: #f2f2f2;
    color: #333;
    padding: 20px;
}

#wrapper {
    max-width: 600px;
    margin: 0 auto;
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

/* Header */
#header {
    text-align: center;
    margin-bottom: 20px;
}

#header h2 {
    font-size: 24px;
    color: #333;
}

/* Container */
#container {
    font-size: 14px;
}

h3 {
    font-size: 18px;
    margin-bottom: 10px;
    color: #333;
}

/* Form Styling */
form table {
    width: 100%;
    margin-bottom: 20px;
}

form table th,
form table td {
    padding: 8px;
    text-align: left;
}

form table td {
    vertical-align: middle;
}

/* Label Styling */
label {
    font-size: 14px;
    color: #555;
    font-weight: normal;
}

/* Input Fields */
input[type="text"], input[type="email"], input[type="submit"] {
    width: 100%;
    padding: 8px;
    font-size: 14px;
    margin-top: 4px;
    border: 1px solid #ccc;
    border-radius: 4px;
    background-color: #f9f9f9;
    color: #333;
}

input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    font-weight: bold;
    border: none;
    cursor: pointer;
}

input[type="submit"]:hover {
    background-color: #45a049;
}

/* Link Styling */
a {
    color: #4CAF50;
    font-size: 14px;
    text-decoration: none;
}

a:hover {
    text-decoration: underline;
}

</style>


<body>
<div id="wrapper">
<div id="header">
<h2>CRM Customer Relationship Manager</h2>
</div>
</div>
<div id="container">
<h3>Save Customer</h3>
<form:form action="saveCustomer" modelAttribute="customer" method="POST">
    <!-- Need to associate this data with customer id -->
    <form:hidden path="id"/>
    <table>
        <thead>
            <tr><th></th></tr>
        </thead>
        <tbody>
            <tr>
                <td><label for="firstName">First name: </label></td>
                <td><form:input path="firstName" id="firstName" required="true" /></td>
            </tr>
            <tr>
                <td><label for="lastName">Last name: </label></td>
                <td><form:input path="lastName" id="lastName" required="true"/></td>
            </tr>
            <tr>
                <td><label for="email">Email: </label></td>
                <td><form:input path="email" id="email" required="true"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save" class="save"/></td>
            </tr>
        </tbody>
    </table>
</form:form>
<div style="clear:both;"></div>
<p>
    <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
</p>
</div>
</body>
</html>