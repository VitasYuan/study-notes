<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<HTML>
    <HEAD>
        <TITLE>JSP Test Page</TITLE>
    </HEAD>
    <BODY>
        <%
            Thread.sleep(5000);
            Random rand = new Random();
            out.println("<h1>Random number:</h1>");
            out.println(rand.nextInt(99)+100);
        %>
    </BODY>
</HTML>
