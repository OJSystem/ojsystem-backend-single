package com.nami.judge;

import com.nami.judge.codesandbox.model.JudgeInfo;
import com.nami.judge.strategy.DefaultJudgeStrategy;
import com.nami.judge.strategy.JavaLanguageJudgeStrategy;
import com.nami.judge.strategy.JudgeContext;
import com.nami.judge.strategy.JudgeStrategy;
import com.nami.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 * @author nami
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getSubmitLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}