<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="product" required="true" type="de.hybris.platform.commercefacades.product.data.ProductData"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="tab-details">
	<ycommerce:testId code="productDetails_content_label">
		<p>
			${ycommerce:sanitizeHTML(product.description)}
		<p>
	</ycommerce:testId>
		<c:choose>
		<c:when test="${not empty product.questionCount}">
			questions number: ${product.questionCount}
		</c:when>
		<c:otherwise>
			questions number: 0
		</c:otherwise>
		</c:choose>
</div>