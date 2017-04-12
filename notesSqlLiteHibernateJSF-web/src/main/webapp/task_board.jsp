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
        <link href="css/bootstrap.css" rel="stylesheet">
        <!--[if lt IE 9]>
        <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <link href="css/styles.css" rel="stylesheet">
    </head>
    <body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="offcanvas" data-target=".sidebar-nav">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Task Board</a>
        </div>
    </nav>
    <div class="container">
        <div class="row vertical-align"> <!--
                    ^--  Additional class -->
            <div class="col-xs-6">
                <div class="panel panel-default">
                    <h:form>
                        <div class="panel-heading"><h:commandLink action="#{taskBoardBean.fullWaitingNotesList}"
                                                                  styleClass="pull-right">View all</h:commandLink> <h4>
                            WAITING NOTES</h4>
                        </div>
                        <div class="panel-body">
                            <h:dataTable var="note" value="#{taskBoardBean.waitingNotes}">
                                <h:column>
                                    <h:commandLink styleClass="pull-left"
                                                   value="#{taskBoardBean.cutString(note.name)}"/>
                                </h:column>
                                <h:column>
                                    <h:commandLink styleClass="pull-left"
                                                   value="[#{taskBoardBean.cutString(note.user.login)}]"/>
                                </h:column>
                                <%--<h:selectOneListbox style="width: 231px; height: 27px;position:absolute;left:400px;top:325px;" value="#{taskBoard.states}" size="1">--%>
                                <%--<f:selectItems value="#{taskBoard.states}" var="d" itemLabel="#{d.name}" itemValue="#{d.name}" />--%>
                                <%--</h:selectOneListbox>--%>
                                <%--<h:column>--%>
                                <%--<h:commandLink styleClass="pull-right" value="Detailed">--%>
                                <%--<f:ajax execute="#{taskBoard.viewDetailsNote(note)}" render=":content" />--%>
                                <%--</h:commandLink>--%>
                                <%--</h:column>--%>
                            </h:dataTable>
                        </div>
                    </h:form>
                </div>
            </div>
            <div class="col-xs-6">
                <div class="panel panel-default">
                    <h:form>
                        <div class="panel-heading"><a href="#" class="pull-right">View all</a> <h4>PERFORMING NOTES</h4>
                        </div>
                        <div class="panel-body">
                            <h:dataTable var="note" value="#{taskBoardBean.performingNotes}">
                                <h:column>
                                    <h:commandLink styleClass="pull-left"
                                                   value="#{taskBoardBean.cutString(note.name)}"/>
                                </h:column>
                                <h:column>
                                    <h:commandLink styleClass="pull-left"
                                                   value="[#{taskBoardBean.cutString(note.user.login)}]"/>
                                </h:column>
                            </h:dataTable>
                        </div>
                    </h:form>
                </div>
            </div>
            <div class="col-xs-6">
                <div class="panel panel-default">
                    <h:form>
                    <div class="panel-heading"><a href="#" class="pull-right">View all</a> <h4>DONE NOTES</h4>
                    </div>
                    <div class="panel-body">
                        <h:dataTable var="note" value="#{taskBoardBean.doneNotes}">
                            <h:column>
                                <h:commandLink styleClass="pull-left" value="#{taskBoardBean.cutString(note.name)}"/>
                            </h:column>
                            <h:column>
                                <h:commandLink styleClass="pull-left"
                                               value="[#{taskBoardBean.cutString(note.user.login)}]"/>
                            </h:column>
                        </h:dataTable>
                    </div>
                    </h:form>
            </div>
        </div>
    </div>
    </div>
    <div>
        <h:outputText id="detailed" value="#{taskBoardBean.detailedNote}"/>
    </div>
    <footer><!--footer-->
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
                                <%--<a href="#">Impressum</a>--%>
                        </li>
                    </ul>
                </h:form>
            </div><!--/row-->
        </div><!--/container-->
    </footer>

    <!-- script references -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
    </body>
    </html>
</f:view>