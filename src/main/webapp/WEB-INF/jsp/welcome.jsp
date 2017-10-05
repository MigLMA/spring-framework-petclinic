<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<petclinic:layout pageName="home">
    <div class="row">
	    <c:if test="${pageContext.request.userPrincipal.name != null}">
	        <form id="logoutForm" method="POST" action="${contextPath}/logout">
	            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        </form>
	
	        <h2><fmt:message key="welcome"/>${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()"><fmt:message key="logout"/></a></h2>
	
			<div class="row">
		        <div class="col-md-12">
		            <spring:url value="/resources/images/pets.png" htmlEscape="true" var="petsImage"/>
		            <img class="img-responsive" src="${petsImage}"/>
		        </div>
		    </div>
	    </c:if>
	</div>
</petclinic:layout>
