package com.nami.model.dto.questionsumbit;

import lombok.Data;

/**
 * 题目判题信息
 *
 * @author nami
 */

@Data
public class JudgeInfo {

    /**
     * 程序执行信息
     */
    private String message;
    /**
     * 消耗时间(ms)
     */
    private Long time;
    /**
     * 消耗内存(KB)
     */
    private Long memory;
}
