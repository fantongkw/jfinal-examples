package com.demo.validator;

import com.jfinal.core.Controller;
import com.jfinal.kit.Ret;
import com.jfinal.validate.Validator;

public class LoginValidator extends Validator {

    @Override
    protected void validate(Controller controller) {
        setRet(Ret.fail());
        validateRequired("id", "msg", "编号不能为空");
        validateInteger("id", "msg", "编号格式不正确");
        validateRequired("name", "msg", "名字不能为空");
        validateString("name", 4, 20,"msg", "名字格式不正确");
    }

    @Override
    protected void handleError(Controller controller) {
        controller.renderJson(getRet());
    }
}
