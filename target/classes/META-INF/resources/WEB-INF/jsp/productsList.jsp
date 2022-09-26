<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<h1>Your Todos</h1>

	<table class="table">
		<thead>
			<tr>
				<th>Product Name</th>
				<th>Quantity</th>
				<th>Price</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${product}" var="product">
            	<tr>
            	    <td>${product.productName}</td>
            		<td>${product.quantity}</td>
            		<td>${product.price}</td>
            		<td> <a href="delete-product?id=${product.productId}" class="btn btn-warning">Delete</a>   </td>
            		<td> <a href="update-product?id=${product.productId}" class="btn btn-success">Update</a>   </td>
            	</tr>
            </c:forEach>
		</tbody>
	</table>

	<a href="add-products" class="btn btn-success">Add Todo</a>
</div>

<%@ include file="common/footer.jspf" %>