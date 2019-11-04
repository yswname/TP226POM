<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${firstProList }" var="_pro">
			  <div class="grid1">
			    <h5>${_pro.prTitle }</h5>
   				  <div class="view view-first">
                     <img src="images/${_pro.listPic.imgUrl }" class="img-responsive" alt="${_pro.listPic.imgTitle }"/>
   				       <a href="single.html"><div class="mask">
   			            <h3>查看详细信息</h3>
                        <p>-----Or----</p>
                        <h4>加入购物车</h4>
                      </div></a>
                   </div> 
               <h6>￥${_pro.prPrice}</h6>
			  </div>
</c:forEach>   