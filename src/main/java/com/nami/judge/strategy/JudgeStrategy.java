package com.nami.judge.strategy;

import com.nami.judge.codesandbox.model.JudgeInfo;

/**
 * 判题策略
 * @author nami
 */
public interface JudgeStrategy {

    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}