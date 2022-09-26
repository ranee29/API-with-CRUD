<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>	

<div class="container">
	
	<h1>Enter Todo Details</h1>
	
	<form:form method="post" modelAttribute="products">

		<fieldset class="mb-3">				
			<form:label path="productName">Product Name</form:label>
			<form:input type="text" path="productName" required="required"/>
			<form:errors path="productName" cssClass="text-warning"/>
		</fieldset>

		<fieldset class="mb-3">				
			<form:label path="price">Price</form:label>
			<form:input type="text" path="price" required="required"/>
			<form:errors path="price" cssClass="text-warning"/>
		</fieldset>

		<fieldset class="mb-3">
        	<form:label path="quantity">Quantity</form:label>
        	<form:input type="text" path="quantity" required="required"/>
        	<form:errors path="quantity" cssClass="text-warning"/>
        </fieldset>

		<form:input type="hidden" path="productId"/>
		<input type="submit" class="btn btn-success"/>
	
	</form:form>

</div>

<%@ include file="common/footer.jspf" %>

<script type="text/javascript">
	$('#targetDate').datepicker({
	    format: 'yyyy-mm-dd'
	});
</script>
