<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang ="en">
    <%@include file="../jsp/head.jsp" %>
    <body>
        <div class ="mdl-layout mdl-js-layout mdl-layout--fixed-header">
            <%@include file="../jsp/menu.jsp" %>
            <main class ="mdl-layout__content">
                <div class="page-content">
                    <div class="mdl-grid center-items"> 
                        <div class="mdl-cell mdl-cell--4-col">
                            <div class="mdl-card mdl-shadow--6dp">
                                <div 
                                    class="mdl-card__title mdl-color--primary mdl-color-text--white">
                                    <h2 class="mdl-card__title-text">
                                        <c:if test="${user != null}"> Edit user</c:if>
                                        <c:if test="${user == null}"> Add New user</c:if>

                                        </h2>
                                    </div>
                                    <div class ="mdl-card__supporting-text">
                                        <c:if test="${user !=null}">
                                            <form name=myForm" action="/PUMS/UserController?op=update" method="post" onsubmit ="return validateForm()">
                                            </c:if>
                                            <c:if test="${user ==null}">
                                                <form name=myForm" action="/PUMS/UserController?op=insert" method="post" onsubmit = "return validateForm()">
                                                </c:if>
                                                <c:if test="${user !=null}">
                                                    <input type="hidden" name="id"
                                                           value="c:out value ='${user.id}'/>"/>
                                                </c:if>

                                                <div class="mdl-textfield mdl-js-textfield">
                                                    <input class="mdl-textfield__input" type="text" name="name"
                                                           value="<c:out value='${user.name}'/>" id="name"/> <label
                                                           class ="mdl-textfield__label" for ="name"> Name</label>
                                                </div>

                                                <div class="mdl-textfield mdl-js-textfield">
                                                    <input class=" mdl-textfield__input" type="text"
                                                           name="description"
                                                           value="<c:out value='${user.surname}'/>" id="surname"/>
                                                    <label class="mdl-textfield__label" for="surname">Surname</label>
                                                </div>


                                                <div class="mdl.textfield mdl-js-textfield">
                                                    <c:choose>
                                                        <c:when test= "${user!=null}">
                                                            <input class  ="mdl-textfield__input" type="text" name="age" value="<c:out value='${user.age}'/>" id="age"/>
                                                        </c:when>    
                                                        <c:otherwise>
                                                            <input class  ="mdl-textfield__input" type="text" name="age" value="<c:out value='18'/>" id="age"/>  
                                                        </c:otherwise> 
                                                    </c:choose>  
                                                    <label 
                                                        class="mdl-textfield__label" for="age">Age</label>
                                                </div>


                                                <div class="mdl-textfield mdl-js-textfield">
                                                    <input class="mdl-textfield__input" type="text" name="department"
                                                           value="<c:out value ='${user.department}'/>" id="department" /> <label
                                                           class ="mdl-textfield__label" for="department" >Department</label>
                                                </div>
                                                <input type="submit"
                                                       class ="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
                                                       value="save">
                                            </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <script type="text/javascript">
                function validateForm() {
                    var x = document.forms["myForm"]["age"].value;
                    if (x == "") {
                        alter("Age must be filled out");
                        return false;
                    }
                }
            </script>
        </body>
    </html>