package com.nami.judge.codesandbox.impl;


import com.nami.judge.codesandbox.CodeSandBox;
import com.nami.judge.codesandbox.model.ExecuteCodeRequest;
import com.nami.judge.codesandbox.model.ExecuteCodeResponse;
/**
 * 第三方代码沙箱（调用网上现成的代码沙箱）
 */
public class ThirdPartyCodeSandbox implements CodeSandBox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }
}
