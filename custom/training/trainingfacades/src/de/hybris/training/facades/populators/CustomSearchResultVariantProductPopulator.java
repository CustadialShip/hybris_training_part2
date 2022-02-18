package de.hybris.training.facades.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.search.converters.populator.SearchResultVariantProductPopulator;
import de.hybris.platform.commerceservices.search.resultdata.SearchResultValueData;

public class CustomSearchResultVariantProductPopulator extends SearchResultVariantProductPopulator {

    public static final String QUESTION_COUNT = "questionCount";

    @Override
    public void populate(SearchResultValueData source, ProductData target) {
        target.setQuestionCount(this.<Integer>getValue(source, QUESTION_COUNT));
    }
}
