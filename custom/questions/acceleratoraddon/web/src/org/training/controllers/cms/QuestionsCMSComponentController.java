package org.training.controllers.cms;

import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.training.model.QuestionsCMSComponentModel;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Scope("tenant")
@Controller
@RequestMapping("/view/QuestionsCMSComponentController")
public class QuestionsCMSComponentController extends AbstractCMSAddOnComponentController<QuestionsCMSComponentModel> {


    public static final String FONT_SIZE = "fontSize";
    public static final String NUMBER_OF_QUESTION_TO_SHOW = "numberOfQuestionToShow";
    public static final String QUESTION_CMS = "addon:/question/cms/";

    @Override
    protected void fillModel(HttpServletRequest request, Model model, QuestionsCMSComponentModel component) {
        model.addAttribute(FONT_SIZE, component.getFontSize());
        model.addAttribute(NUMBER_OF_QUESTION_TO_SHOW,component.getNumberOfQuestionsToShow());
    }

    @Override
    protected String getView(QuestionsCMSComponentModel component) {
        return QUESTION_CMS + (getTypeCode(component).toLowerCase(Locale.ROOT));
    }
}
