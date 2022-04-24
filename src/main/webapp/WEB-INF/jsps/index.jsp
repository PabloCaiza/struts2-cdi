<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container" style="padding-top: 3%">

    <a href="<s:url action='inputPerson'/>" class="btn btn-dark">Create Person</a>
    <table class="table">
        <tr>
            <th>Name</th>
            <th>Age</th>
        </tr>
        <s:iterator value="peopleList" status="peopleStatus">
            <tr>
                <td >
                    <s:property value="name"/>
                </td>
                <td>
                    <s:property value="age"/>
                </td>
                <td>
                    <s:url action="inputPerson" var="updateUrl">
                        <s:param name="person.id" value="id"/>
                    </s:url>
                    <a href="${updateUrl}" class="btn btn-outline-primary">Edit</a>
                    <s:url action="delete" var="deleteUrl">
                        <s:param name="person.id" value="id"/>
                    </s:url>
                    <a href="${deleteUrl}" class="btn btn-outline-danger">Delete</a>

                </td>

            </tr>
        </s:iterator>

    </table>


</div>

</body>
</html>
