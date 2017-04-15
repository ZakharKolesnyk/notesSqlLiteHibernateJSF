<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<f:view>

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>Notes</title>
        <meta name="generator" content="Bootply"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="../css/bootstrap.css" rel="stylesheet">
        <!--[if lt IE 9]>
        <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <link href="../css/styles.css" rel="stylesheet">
    </head>
    <body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="navbar-header">
            <h:form>
                <h:commandLink action="#{taskBoardBean.addUser}" disabled="#{not authBean.user.hasRole('LEADER')}"
                               styleClass="navbar-brand" style="margin-left: 10px;" value="add User"/>
                <h:commandLink action="#{taskBoardBean.addNote}" disabled="#{not authBean.user.hasRole('LEADER')}"
                               styleClass="navbar-brand" style="margin-right: 10px;" value="add Note"/>
            </h:form>
        </div>
    </nav>
    <div class="container">
        <div class="row vertical-align"> <!--
                    ^--  Additional class -->
            <div class="col-xs-12">
                <div class="panel panel-default">

                    <div class="panel-heading"><h4>NEW USER</h4>
                    </div>
                    <div class="panel-body" align="center">
                        <h:form>
                            <h:outputText value="firstName"/><br>
                            <h:inputText required="true" readonly="#{not authBean.user.hasRole('LEADER')}"
                                         value="#{addUserBean.firstName}"/><br><br>

                            <h:outputText value="lastName"/><br>
                            <h:inputText required="true" readonly="#{not authBean.user.hasRole('LEADER')}"
                                         value="#{addUserBean.lastName}"/><br><br>

                            <h:outputText value="login"/><br>
                            <h:inputText required="true" readonly="#{not authBean.user.hasRole('LEADER')}"
                                         value="#{addUserBean.login}"/><br><br>

                            <h:outputText value="email"/><br>
                            <h:inputText required="true" readonly="#{not authBean.user.hasRole('LEADER')}"
                                         value="#{addUserBean.email}"/><br><br>

                            <h:outputText value="password"/><br>
                            <h:inputSecret required="true" readonly="#{not authBean.user.hasRole('LEADER')}"
                                           value="#{addUserBean.password}"/><br><br>

                            <h:outputText value="confirm"/><br>
                            <h:inputSecret required="true" readonly="#{not authBean.user.hasRole('LEADER')}"
                                           value="#{addUserBean.confirm}"/><br><br>

                            <h:outputText value="authority"/><br>
                            <h:selectOneMenu disabled="#{not authBean.user.hasRole('LEADER')}"
                                             styleClass="notes" value="#{addUserBean.authority}">
                                <f:selectItem itemValue="EMPLOYEE" itemLabel="EMPLOYEE"/>
                                <f:selectItem itemValue="LEADER" itemLabel="LEADER"/>
                            </h:selectOneMenu><br><br>

                            <h:commandLink disabled="#{not authBean.user.hasRole('LEADER')}"
                                           styleClass="pull-left notes" action="#{addUserBean.add}"
                                           value="add User"/>
                        </h:form>

                        <h:form>
                            <h:commandLink styleClass="pull-right notes" action="#{addUserBean.backToTaskBoard}"
                                           value="back"/>
                        </h:form>
                    </div>

                </div>
            </div>

        </div>
    </div>

    <footer>
        <div class="container">
            <div class="row">
                <h:form>
                    <ul class="list-unstyled text-right">
                        <li class="col-sm-4 col-xs-6">
                            <a href="#">About</a>
                        </li>
                        <li class="col-sm-4 col-xs-6">
                            <a href="#">Services</a>
                        </li>
                        <li class="col-sm-4 col-xs-6">
                            <a href="#">Studies</a>
                        </li>
                        <li class="col-sm-4 col-xs-6">
                            <a href="#">References</a>
                        </li>
                        <li class="col-sm-4 col-xs-6">
                            <a href="#">Login</a>
                        </li>
                        <li class="col-sm-4 col-xs-6">
                            <a href="#">Press</a>
                        </li>
                        <li class="col-sm-4 col-xs-6">
                            <a href="#">Contact</a>
                        </li>
                        <li class="col-sm-4 col-xs-6">
                            <h:commandLink action="#{authBean.logout}" value="Logout"/>
                        </li>
                    </ul>
                </h:form>
            </div><!--/row-->
        </div><!--/container-->
    </footer>

    <!-- script references -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/scripts.js"></script>
    </body>
    </html>
</f:view>
