package com.test.frmw.saral.keywords;

import com.test.frmw.saral.kw.AutomationKeyword;
import com.test.frmw.saral.kw.KeywordAnnotation;
import com.test.frmw.saral.kw.parameters.Param;

@KeywordAnnotation(name="another keyword")
public class AnotherDemoKeyword implements AutomationKeyword {

    @Param
    private String elementToClick;


    @Override
    public void run() {

    }
}
