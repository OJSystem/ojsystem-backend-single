package com.nami.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nami.common.BaseResponse;
import com.nami.common.ErrorCode;
import com.nami.common.ResultUtils;
import com.nami.exception.BusinessException;
import com.nami.model.dto.questionsumbit.QuestionSubmitAddRequest;
import com.nami.model.dto.questionsumbit.QuestionSubmitQueryRequest;
import com.nami.model.entity.QuestionSubmit;
import com.nami.model.entity.User;
import com.nami.model.vo.QuestionSubmitVO;
import com.nami.service.QuestionSubmitService;
import com.nami.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 *
 * @author nami
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
@Deprecated
// @CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
@CrossOrigin(origins = "http://oj.kongshier.top", allowCredentials = "true")
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 提交题目
     *
     * @param questionSubmitAddRequest
     * @param request
     * @return 提交记录 id
     */
    @PostMapping("/sumbit")
    @ApiOperation(value = "题目提交")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
                                               HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能点赞
        final User loginUser = userService.getLoginUser(request);
        long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(questionSubmitId);
    }

    /**
     * 分页获取题目提交列表（除了管理员外，其他普通用户只能看到非答案、提交的代码等公开信息）
     *
     * @param questionSubmitQueryRequest
     * @param request
     * @return
     */
    @PostMapping("/list/page")
    @ApiOperation(value = "分页获取题目提交列表")
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest,
                                                                         HttpServletRequest request) {
        long current = questionSubmitQueryRequest.getCurrent();
        long pageSize = questionSubmitQueryRequest.getPageSize();

        // 从数据库中查询到原始的题目提交信息
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, pageSize),
                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
        final User loginUer = userService.getLoginUser(request);
        // 返回脱敏信息
        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage, loginUer));
    }

}
