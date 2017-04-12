<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<f:view>
<!DOCTYPE html>

    <html lang="en">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel='stylesheet prefetch' href='css/bootstrap.css'>
        <link rel="stylesheet" type="text/css" href="css/registration.css">
        <link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
        <title>Login</title>
    </head>
    <body>

    <div class="container">
        <div class="row main">
            <div class="panel-heading">
                <div class="panel-title text-center">
                    <h1 class="title">Notes Network</h1>
                    <hr/>
                </div>
            </div>
            <div class="main-login main-center">
                <h:form styleClass="form-horizontal">
                <%--<form class="form-horizontal">--%>

                    <div class="form-group">
                        <label <%--for="username"--%> class="cols-sm-2 control-label">Login or email</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                                <h:inputText styleClass="form-control" required="true" id="username"
                                       value="#{authBean.username}"/>
                                <%--<script type="text/javascript">--%>
                                    <%--"$('input.search).attr('placeholder','search')";--%>
<%--//                                </script>--%>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label <%--for="password"--%> class="cols-sm-2 control-label">Password</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg"
                                                                   aria-hidden="true"></i></span>
                                <h:inputText styleClass="form-control" required="true" id="password" value="#{authBean.password}"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group ">
                        <h:commandButton action="#{authBean.login}" styleClass="btn btn-primary btn-lg btn-block login-button" value="Login"/>
                        <%--<h:commandLink  styleClass="btn btn-primary btn-lg btn-block login-button" value="Login"/>--%>
                    </div>
                <%--</form>--%>
                </h:form>
            </div>
        </div>
    </div>

    <%--<p><h:outputText value="#{loginBean.name}"/></p>--%>
    </body>
    </html>
</f:view>
