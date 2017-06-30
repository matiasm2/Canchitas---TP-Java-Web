<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><c:out value="${nombre}"/></h1>
        <h1><c:out value="${email}"/></h1>
        <h1><c:out value="${password}"/></h1>
        <h1><c:out value="${hash1}"/></h1>
        <h1><c:out value="${hash2}"/></h1>
    </body>
</html>
