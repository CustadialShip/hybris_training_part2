package de.hybris.training.facades.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.search.converters.populator.SearchResultVariantProductPopulator;
import de.hybris.platform.commerceservices.search.resultdata.SearchResultValueData;

public class CustomSearchResultVariantProductPopulator extends SearchResultVariantProductPopulator {

    public static final String QUESTION_COUNT = "questionCount";

    @Override
    public void populate(SearchResultValueData source, ProductData target) {
        super.populate(source, target);
        final Object obj = this.getValue(source, QUESTION_COUNT);
        if (obj != null) {
            target.setQuestionCount(this.<Integer>getValue(source, QUESTION_COUNT));
        } else {
            target.setQuestionCount(0);
        }
    }
}
