<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <c:forEach items="${ALIANAME_SET }" var="aliaName">
       <c:choose>
          <c:when test="${aliaName == CURR_ALIA_NAME }">
             <font color="red">${aliaName }</font><br/>
          </c:when>
          <c:otherwise>${aliaName }<br/></c:otherwise>
       </c:choose>
    </c:forEach>
