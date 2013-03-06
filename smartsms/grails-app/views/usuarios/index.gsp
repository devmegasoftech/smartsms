<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Loguin</title>
    <style type="text/css">
      label{
        float:left;
        width:65px;
      }
    </style>
  </head>
  <body>
  <g:form controller="user" action="login" style="padding-left:200px">
    <div style="width: 220px">
      <label>Nombre:</label> <input type="text" name="username"/>
      <label>Password:</label> <input type="password" name="password"/>
      <label>&nbsp;</label><input type="submit" value="Login">
    </div>
  </g:form>
  </body>
</html>
