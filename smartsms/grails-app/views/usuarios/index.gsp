<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Loguin</title
    <!--css  -->
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'login.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.css')}" type="text/css">
    <!-- js -->
    <script src="${resource(dir: 'js', file: 'prefixfree.min.js')}"></script>
    <script src="${resource(dir: 'js', file: 'jquery.js')}"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
    <script src="${resource(dir: 'js', file: 'bootstrap-transition.js')}"></script>
    <script src="${resource(dir: 'js', file: 'bootstrap-alert.js')}"></script>
    <script type="text/javascript">
  			$(document).ready(function() {
    			$("#frmLogin").submit(function(event) {
      				event.preventDefault(); 
      				var $form = $( this ),
      				url = $form.attr( 'action' );
       				$.post( url,  $form.serialize(),
        				function(data) {
          					$("#frmLogin .response").html(data);
        				}
        			);                  
    			});
  			});
   </script>
  </head>
  <body> 
    <div id="wrapper" class="container">
      <div id="logo"><center><img src="${resource(dir:'img', file:'header_logo.png')}"/></center></div>
      <g:form class="form rounded-5 shadow" controller="Usuarios" action="login" id="frmLogin" name="frmLogin">
        
          <input style="height: 33px; width: 278px" id="username" type="text" name="username" placeholder="Usuario"/>
          <input style="height: 33px; width: 278px" id="password"  type="password" name="password" placeholder="Password"/>
          <input class="btn btn-success" type="submit" value="Login">
          <div class="response"></div>
        
      </g:form>
      <ul class="footer">
        <li><a href="">Soporte</a></li>
        <li><a href="">Recuperar Password</a></li>
      </ul>
    </div>
  </body>
</html>
