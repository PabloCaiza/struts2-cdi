<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body >
<div class="container" style="padding-top: 3%">
    <s:form action="save" method="post" theme="simple">

        <s:hidden name="person.id" value="%{person.id}"/>
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
        <s:textfield id="name" name="person.name" label="Your name" requiredLabel="true"  class="form-control" />
        </div>
        <div class="mb-3">
            <label for="age" class="form-label">Age</label>
            <s:textfield  id="age" name="person.age" label="Your age"  type="number" requiredLabel="true"  class="form-control" />
        </div>
        <s:url action="index" var="indexUrl"/>
            <s:a href="%{indexUrl}" class="btn btn-outline-secondary" >Cancel</s:a>
            <s:submit value="Submit"  class="btn btn-outline-success"/>

    </s:form>
</div>

</body>
</html>
