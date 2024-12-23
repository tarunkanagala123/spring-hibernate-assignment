    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Customer List</title>
    <style>
        /* General Body Style */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        /* Wrapper Style */
        #wrapper {
            width: 100%;
            margin: 0 auto;
            padding: 0 20px;
        }

        /* Header Styling */
        #header {
            background-color: #4CAF50;
            color: white;
            text-align: center;
            padding: 20px 0;
        }

        #header h2 {
            margin: 0;
        }

        /* Container Styling */
        #container {
            max-width: 1000px;
            margin: 20px auto;
        }

        /* Content Section Styling */
        #content {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        /* Add Customer Button */
        .add-button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            margin-bottom: 20px;
        }

        .add-button:hover {
            background-color: #45a049;
        }

        /* Table Styling */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        /* Links Styling */
        a {
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        /* Responsive Styling */
        @media (max-width: 768px) {
            #container {
                width: 100%;
                padding: 10px;
            }

            table, th, td {
                font-size: 14px;
            }

            .add-button {
                width: 100%;
                padding: 12px;
            }
        }
    </style>

</head>
<body>


    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <div id="content">
            <!-- BUTTON FOR ADDING NEW CUSTOMER -->
            <input type="button" value="Add Customer"
                onclick="window.location.href='/web_customer_tracker/customer/showFormForAdd';return false;"
                class="add-button"/>
<br>
<br>
            <table border="3">
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
                        <!-- Loop over and print customers -->
                                          <c:forEach var="tempCustomer" items="${customers}">

                    <!-- Creating an update link for each Customer -->
                    <c:url var="updateLink" value="/customer/showFormForUpdate">
                        <c:param name="customerId" value="${tempCustomer.id}"/>
                    </c:url>

                    <!-- Creating a delete link for each Customer -->
                    <c:url var="deleteLink" value="/customer/delete">
                        <c:param name="customerId" value="${tempCustomer.id}"/>
                    </c:url>

                    <tr>
                        <td>${tempCustomer.firstName}</td>
                        <td>${tempCustomer.lastName}</td>
                        <td>${tempCustomer.email}</td>
                        <td>
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}"
                               onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">
                               Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
</body>
</html>
