package com.nami.judge;

import com.nami.model.entity.QuestionSubmit;

/**
 * @author nami
 * 判题服务 ：执行代码
 */
public interface JudgeService {
    /**
     * 判题
     *
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
