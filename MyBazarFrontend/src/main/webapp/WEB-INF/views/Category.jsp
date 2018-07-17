<%@ page language="java" contentType="text/html"%>
<%@ include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="$(flag)">
<form action="<c:url value="/UpdateCategory"/>" method="post">

<table align="center">
     <tr>
         <td>Category Id</td>
         <td><input type="text" name="catid" value="${categoryData.categoryId}"readonly/></td>
     </tr>
     <tr>
         <td>Category Name</td>
         <td><input type="text" name="catname" value="${categoryData.categoryName}"/></td>
     </tr>
     
     <tr>
        <td>Category Description</td>
        <td><input type="text" name="catDesc" value="${categoryData.categoryDesc}"/></td>
     </tr>
     
     <tr>
     <td colspan="2">
            <center>
            <input type="submit" value="Update Category"/>
            </center>
     </td>
     </tr>       
</table>
</form>
</c:if>

<c:if test="$(!flag)">
<form action="<c:url value="/InsertCategory"/>" method="post">

<table align="center">
     <tr>
         <td>Category Name</td>
         <td><input type="text" name="catname"/></td>
     </tr>
     
     <tr>
        <td>Category Description</td>
        <td><input type="text" name="catDesc"/></td>
     </tr>
     
     <tr>
     <td colspan="2">
            <center>
            <input type="submit" value="Insert Category"/>
            </center>
     </td>
     </tr>       

</table>

</form>

<table align="center">
      <tr bgcolor="pink">
          <td>Category ID</td>
          <td>Category Name</td>
          <td>Category Desc</td>
      </tr>
      <c:forEach items="${category list}" var="category">
      <tr>
          <td>${category.categoryId}</td>
          <td>${category.categoryName}</td>
          <td>${category.categoryDesc}</td>
          <td>
              <a href="<c:url value='/deleteCategory/${category.categoryId}'/>">Delete</a>
              <a href="<c:url value='/editCategory/${category.categoryId}'/>">Edit</a>
          </td>    
              
      </tr>
      </c:forEach>
</table>
</c:if>