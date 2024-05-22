package com.nami.judge.codesandbox;

import com.nami.judge.codesandbox.model.ExecuteCodeRequest;
import com.nami.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * @author nami
 * 代码沙箱接口定义
 */
public interface CodeSandBox {

    /**
     * 代码沙箱执行代码接口
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
