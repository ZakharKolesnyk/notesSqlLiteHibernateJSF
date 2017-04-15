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
        <title>Holo Theme</title>
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
            <button type="button" class="navbar-toggle" data-toggle="offcanvas" data-target=".sidebar-nav">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Task Board</a>
        </div>
    </nav>
    <div class="container">
        <h:form>
        <div class="row vertical-align"> <!--
                    ^--  Additional class -->
            <div class="col-xs-5 col-sd-5 col-ld-5 col-md-5">
                <div class="panel panel-default">
                    <div class="panel-heading"><h4>VIEW NOTE</h4>
                    </div>
                    <div class="panel-body" align="center" style="height: 320px;">

                            <%--<h:dataTable>--%>
                            <%--<h:outputText id="detailed" value="#{taskBoardBean.detailedNote}"/>--%>
                            <%--<h:column>--%>
                            <%--<h:outputText value="description"/><br>--%>
                            <%--<h:inputTextarea rows="5" cols="90" value="#{viewNoteBean.description}"/><br><br>--%>

                            <h:outputText value="name"/><br>
                            <h:inputText value="#{viewNoteBean.name}"/><br><br>
                            <%--</h:column>--%>
                            <%--<h:column>--%>

                            <%--</h:column>--%>
                            <%--<h:column>--%>
                            <h:outputText value="last modified"/><br>
                            <h:inputText readonly="true" value="#{viewNoteBean.createDate}"/><br><br>
                            <%--</h:column>--%>
                            <%--<h:column>--%>
                            <h:outputText value="state"/><br>
                            <h:inputText readonly="true" value="#{viewNoteBean.state}"/><br><br>
                            <%--</h:column>--%>
                            <%--<h:column>--%>
                            <h:outputText value="responcible"/><br>
                            <h:inputText value="#{viewNoteBean.login}"/><br><br>
                            <%--</h:column>--%>
                            <%--<h:column>--%>
                                <h:commandLink styleClass="pull-left notes" action="#{viewNoteBean.applyNote}"
                                               value="apply"/>
                                    <%--</h:column>--%>
                                    <%--</h:dataTable>--%>

                                    <%--<h:form>--%>
                                <h:commandLink styleClass="pull-left notes" action="#{viewNoteBean.backToTaskBoard}"
                                               value="back"/>

                    </div>
                </div>
            </div>

            <div class="col-xs-7 col-sd-7 col-ld-7 col-md-7">
                <div class="panel panel-default">
                    <div class="panel-heading"><h4>DESCRIPTION</h4>
                    </div>
                    <div class="panel-body" align="center" style="height: 320px;">

                            <%--<h:dataTable>--%>
                            <%--<h:outputText id="detailed" value="#{taskBoardBean.detailedNote}"/>--%>
                            <%--<h:column>--%>
<%--<h:form>--%>
                        <%--<h:outputText value="description"/><br>--%>
                        <h:inputTextarea rows="12" style="width: 90%" value="#{viewNoteBean.description}"/><br><br>
<%--</h:form>--%>
                            <%--<h:outputText value="name"/><br>--%>
                            <%--<h:inputText id="name" value="#{viewNoteBean.name}"/><br><br>--%>
                            <%--&lt;%&ndash;</h:column>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<h:column>&ndash;%&gt;--%>

                            <%--&lt;%&ndash;</h:column>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<h:column>&ndash;%&gt;--%>
                            <%--<h:outputText value="last modified"/><br>--%>
                            <%--<h:inputText readonly="true" value="#{viewNoteBean.createDate}"/><br><br>--%>
                            <%--&lt;%&ndash;</h:column>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<h:column>&ndash;%&gt;--%>
                            <%--<h:outputText value="state"/><br>--%>
                            <%--<h:inputText readonly="true" value="#{viewNoteBean.state}"/><br><br>--%>
                            <%--&lt;%&ndash;</h:column>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<h:column>&ndash;%&gt;--%>
                            <%--<h:outputText value="responcible"/><br>--%>
                            <%--<h:inputText value="#{viewNoteBean.login}"/><br><br>--%>
                            <%--&lt;%&ndash;</h:column>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<h:column>&ndash;%&gt;--%>
                            <%--<h:commandLink styleClass="pull-left notes" action="#{viewNoteBean.applyNote}" value="apply"/>--%>
                            <%--&lt;%&ndash;</h:column>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</h:dataTable>&ndash;%&gt;--%>

                            <%--<h:form>--%>
                            <%--<h:commandLink styleClass="pull-left notes" action="#{viewNoteBean.backToTaskBoard}" value="back"/>--%>
                            <%--</h:form>--%>

                                <%--</h:form>--%>
                    </div>
                </div>
            </div>
        </div>
            </h:form>
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
