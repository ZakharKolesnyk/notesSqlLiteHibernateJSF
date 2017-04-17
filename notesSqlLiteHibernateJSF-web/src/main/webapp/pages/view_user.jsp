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
                <h:commandLink action="#{taskBoardBean.addUser}" disabled="#{not authBean.user.hasRole('LEADER')}" styleClass="navbar-brand" style="margin-left: 10px;" value="add User"/>
                <h:commandLink action="#{taskBoardBean.addNote}" disabled="#{not authBean.user.hasRole('LEADER')}" styleClass="navbar-brand" style="margin-right: 10px;" value="add Note"/>
            </h:form>
        </div>
    </nav>
    <div class="container" style="width: 100%">
        <div class="row vertical-align"> <!--
                    ^--  Additional class -->
            <div class="col-xs-3">
                <div class="panel panel-default">
                    <h:form>
                        <div class="panel-heading"><h4><h:outputText value="#{viewUserBean.login}"/> </h4>
                        </div>
                        <div class="panel-body">
                            <h:outputText value="firstName"/><br>
                            <h:inputText readonly="#{not (authBean.user.hasRole('LEADER') || authBean.user.login.equals(viewUserBean.login))}" value="#{viewUserBean.firstName}"/><br><br>

                            <h:outputText value="lastName"/><br>
                            <h:inputText readonly="#{not (authBean.user.hasRole('LEADER') || authBean.user.login.equals(viewUserBean.login))}" value="#{viewUserBean.lastName}"/><br><br>

                            <h:outputText value="email"/><br>
                            <h:inputText readonly="true"  value="#{viewUserBean.email}"/><br><br>

                            <h:outputText value="login"/><br>
                            <h:inputText readonly="true"  value="#{viewUserBean.login}"/><br><br>

                            <h:outputText value="authority"/><br>
                            <h:inputText readonly="true"  value="#{viewUserBean.authority}"/><br><br>

                            <h:commandLink styleClass="pull-left notes" action="#{viewUserBean.applyUser}"
                                           value="apply"/>

                            <h:commandLink styleClass="pull-right notes" action="#{viewUserBean.backToTaskBoard}"
                                           value="back"/>
                        </div>
                    </h:form>
                </div>
            </div>
            <div class="col-xs-3">
                <div class="panel panel-default">
                    <h:form>
                        <div class="panel-heading"><h4>ASSIGNED NOTES</h4>
                        </div>
                        <div class="panel-body">
                            <h:dataTable var="note" value="#{viewUserBean.assignedNotes}">
                                <h:column>
                                    <h:commandLink styleClass="pull-left notes"
                                                   value="#{viewUserBean.cutString(note.name)}"
                                                   action="#{viewUserBean.viewNote(note)}"/>
                                </h:column>
                                <h:column>
                                    <h:selectOneMenu disabled="#{not authBean.user.hasRole('LEADER')}"
                                                     styleClass="notes" value="#{note.state}" onchange="submit()"
                                                     valueChangeListener="#{viewUserBean.changeListener}">
                                        <f:attribute name="note" value="#{note}"/>
                                        <f:selectItem itemValue="" itemLabel=""/>
                                        <f:selectItem itemValue="ASSIGNED" itemLabel="ASSIGNED"/>
                                        <f:selectItem itemValue="PERFORMING" itemLabel="PERFORMING"/>
                                        <f:selectItem itemValue="DONE" itemLabel="DONE"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:dataTable>
                        </div>
                    </h:form>
                </div>
            </div>
            <div class="col-xs-3">
                <div class="panel panel-default">
                    <h:form>
                        <div class="panel-heading"><h4>PERFORMING NOTES</h4>
                        </div>
                        <div class="panel-body">
                            <h:dataTable var="note" value="#{viewUserBean.performingNotes}">
                                <h:column>
                                    <h:commandLink styleClass="pull-left notes"
                                                   value="#{viewUserBean.cutString(note.name)}"
                                                   action="#{viewUserBean.viewNote(note)}"/>
                                </h:column>
                                <h:column>
                                    <h:selectOneMenu disabled="#{not authBean.user.hasRole('LEADER')}"
                                                     styleClass="notes" value="#{note.state}" onchange="submit()"
                                                     valueChangeListener="#{viewUserBean.changeListener}">
                                        <f:attribute name="note" value="#{note}"/>
                                        <f:selectItem itemValue="" itemLabel=""/>
                                        <f:selectItem itemValue="PERFORMING" itemLabel="PERFORMING"/>
                                        <f:selectItem itemValue="ASSIGNED" itemLabel="ASSIGNED"/>
                                        <f:selectItem itemValue="DONE" itemLabel="DONE"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:dataTable>
                        </div>
                    </h:form>
                </div>
            </div>
            <div class="col-xs-3">
                <div class="panel panel-default">
                    <h:form>
                        <div class="panel-heading"><h4>DONE NOTES</h4>
                        </div>
                        <div class="panel-body">
                            <h:dataTable var="note" value="#{viewUserBean.doneNotes}">
                                <h:column>
                                    <h:commandLink styleClass="pull-left notes"
                                                   value="#{viewUserBean.cutString(note.name)}"
                                                   action="#{viewUserBean.viewNote(note)}"/>
                                </h:column>
                                <h:column>
                                    <h:selectOneMenu disabled="#{not authBean.user.hasRole('LEADER')}"
                                                     styleClass="notes" value="#{note.state}" onchange="submit()"
                                                     valueChangeListener="#{viewUserBean.changeListener}">
                                        <f:attribute name="note" value="#{note}"/>
                                        <f:selectItem itemValue="" itemLabel=""/>
                                        <f:selectItem itemValue="DONE" itemLabel="DONE"/>
                                        <f:selectItem itemValue="ASSIGNED" itemLabel="ASSIGNED"/>
                                        <f:selectItem itemValue="PERFORMING" itemLabel="PERFORMING"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:dataTable>
                        </div>
                    </h:form>
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
