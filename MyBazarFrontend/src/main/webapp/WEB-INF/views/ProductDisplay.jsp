<%@ page language="java" contentType="text/html"%>
<%@ include file="Header.jsp"%>



<c:forEach items="${productList}" var="product">
<div class="row">
     <div class="col-sm-6 col-md-4">
        <div class="thumbnai">
           <h4>
              <b class="glyphicon glyphicon-star"></b>
              </span> <span data-toggl"tooltip" title="Bootstrap version">${product.productName} &nbsp;rs. ${product.price}/-</span>
              </span>
           </h4>
           <img src="<c:url value="resources/images/${product.productId}.jpg"/>" width="150" height="150" alt="Image not Supported"/>
           <a href="<c:url value="/totalProductInfo/${product.productId}"/>"
              class="btn btn-primary col-xs-12" role="button">Click for Large</a>
           <div class="clearfix"></div>   
        </div>
     </div> 
</div>
</c:forEach>