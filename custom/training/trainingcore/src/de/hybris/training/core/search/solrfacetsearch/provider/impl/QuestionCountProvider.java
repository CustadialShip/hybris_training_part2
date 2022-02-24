package de.hybris.training.core.search.solrfacetsearch.provider.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.provider.FieldNameProvider;
import de.hybris.platform.solrfacetsearch.provider.FieldValue;
import de.hybris.platform.solrfacetsearch.provider.FieldValueProvider;
import de.hybris.platform.solrfacetsearch.provider.impl.AbstractPropertyFieldValueProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QuestionCountProvider extends AbstractPropertyFieldValueProvider implements FieldValueProvider {

    public static final String ERROR_ITEM_IS_NOT_A_PRODUCT = "Error: item is not a Product type !";

    private FieldNameProvider fieldNameProvider;

    @Override
    public Collection<FieldValue> getFieldValues(IndexConfig indexConfig, IndexedProperty indexedProperty, Object model) throws FieldValueProviderException {
        if(model instanceof ProductModel){
            final ProductModel product = (ProductModel) model;
            return createFieldValue(product, indexConfig, indexedProperty);
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
