package de.hybris.training.core.search.solrfacetsearch.provider.impl;

import de.hybris.platform.acceleratorservices.dataexport.googlelocal.model.Product;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.provider.FieldNameProvider;
import de.hybris.platform.solrfacetsearch.provider.FieldValue;
import de.hybris.platform.solrfacetsearch.provider.FieldValueProvider;
import de.hybris.training.core.model.ApparelProductModel;
import de.hybris.training.core.model.ApparelSizeVariantProductModel;
import de.hybris.training.core.model.ApparelStyleVariantProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QuestionCountProvider implements FieldValueProvider, Serializable {

    public static final String ERROR_ITEM_IS_NOT_A_PRODUCT = "Error: item is not a Product type !";

    private FieldNameProvider fieldNameProvider;

    @Override
    public Collection<FieldValue> getFieldValues(IndexConfig indexConfig, IndexedProperty indexedProperty, Object model) throws FieldValueProviderException {
        if(model instanceof ProductModel){
            final ProductModel product = (ProductModel) model;
            final List<FieldValue> fieldValues = createFieldValue(product, indexConfig, indexedProperty);
            return fieldValues;
        } else {
            throw new FieldValueProviderException(ERROR_ITEM_IS_NOT_A_PRODUCT);
        }
    }

    private List<FieldValue> createFieldValue(ProductModel product, IndexConfig indexConfig, IndexedProperty indexedProperty) {
        final List<FieldValue> fieldValues = new ArrayList<FieldValue>();
        final Integer questionCount = product.getQuestion().size();
        addFieldValues(fieldValues, indexedProperty, questionCount);
        return fieldValues;
    }

    private void addFieldValues(List<FieldValue> fieldValues, IndexedProperty indexedProperty,  Integer questionCount) {
        final Collection<String> fieldNames = fieldNameProvider.getFieldNames(indexedProperty, null);
        fieldNames.forEach(fieldName -> fieldValues.add(new FieldValue(fieldName, questionCount)));
    }

    public void setFieldNameProvider(final FieldNameProvider fieldNameProvider)
    {
        this.fieldNameProvider = fieldNameProvider;
    }
}
