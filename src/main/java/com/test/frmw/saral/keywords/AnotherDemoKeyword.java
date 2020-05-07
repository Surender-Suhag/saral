package com.test.frmw.saral.keywords;

import com.test.frmw.saral.annotations.FrameworkKeyword;
import com.test.frmw.saral.annotations.Param;
import com.test.frmw.saral.kw.AutomationKeyword;


@FrameworkKeyword(name="another keyword",description = "This is a demo keyword")
public class AnotherDemoKeyword implements AutomationKeyword {

    @Param
    private String elementToClick;


    @Override
    public void run() {

    }
}
