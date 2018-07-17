<%@ page language="java" contentType="text/html"%>
<%@ include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form action="UpdateProduct" modelAttribute="product" method="post" enctype="multipart/form-data">

<table align="center" cellspacing="3">

<tr bgcolor="pink">
   <td colspan="2"><center>Product Manage</center></td>
</tr>

<tr>
   <td>Product Name</td>
   <td><form:input path="productName"/></td>
</tr>

<tr>
   <td>Product Description</td>
   <td><form:input path="productDesc"/></td>
</tr>

<tr>
   <td>Price</td>
   <td><form:input path="price"/></td>
</tr>

<tr>
   <td>Stock</td>
   <td><form:input path="stock"/></td>
</tr>

<tr>
   <td>Category</td>
   <td>
      <form:select path="categoryId">
            <form:option value="0" label="--Select List--"/>
            <form:options item="${categoryList}"/>
      </form:select>
   </td>
</tr>

<tr>
   <td>Supplier</td>
   <td><form:input path="supplierId"/></td>
</tr>

<tr>
   <td colspan="2">
      <center><input type="submit" value="update"/></center>
   </td>
</tr>      
</table>
</form:form>

<table align="center">
      <tr bgcolor="pink">
          <td>Product ID</td>
          <td>Product Name</td>
          <td>Product Desc</td>
          <td>Price</td>
          <td>Stock</td>
          <td>Category</td>
          <td>Supplier</td>
          <td>Operation</td>
      </tr>   
 <c:forEach items="${productList}" var="product">   
 <tr>
     <td>${product.productyId}</td>
     <td>${product.productName}</td>
     <td>${product.productDesc}</td>
     <td>${product.price}</td>
     <td>${product.stock}</td>
     <td>${product.categoryId}</td>
     <td>${product.supplierId}</td>
     <td>
         <a href="<c:url value='/deleteProduct/${product.productyId}'/>">Delete</a>
         <a href="<c:url value='/editProduct/${product.productyId}'/>">Edit</a>
     </td> 
 </tr>
 </c:forEach>
 </table>      