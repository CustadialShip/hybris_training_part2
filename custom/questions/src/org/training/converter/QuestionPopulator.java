package org.training.converter;

import de.hybris.platform.commercefacades.product.data.QuestionData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.spockframework.util.Assert;
import org.springframework.stereotype.Component;
import org.training.model.QuestionModel;

@Component
public class QuestionPopulator implements Populator<QuestionModel, QuestionData> {

    public static final String SOURCE_CANNOT_BE_NULL = "Parameter source cannot be null";
    public static final String TARGET_CANNOT_BE_NULL = "Parameter target cannot be null";

    @Override
    public void populate(QuestionModel source, QuestionData target) throws ConversionException {
        Assert.notNull(source, TARGET_CANNOT_BE_NULL);
        Assert.notNull(target, SOURCE_CANNOT_BE_NULL);

        target.setQuestion(source.getQuestion());
        target.setAnswer(source.getAnswer());
    }
}
