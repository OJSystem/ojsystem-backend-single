package com.nami.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nami.common.ErrorCode;
import com.nami.exception.BusinessException;
import com.nami.exception.ThrowUtils;
import com.nami.mapper.UserCodeMapper;
import com.nami.model.entity.UserCode;
import com.nami.service.UserCodeService;
import org.springframework.stereotype.Service;

/**
 * @author nami
 * @description 针对表【user_code(用户)】的数据库操作Service实现
 */
@Service
public class UserCodeServiceImpl extends ServiceImpl<UserCodeMapper, UserCode>
        implements UserCodeService {

    @Override
    public UserCode getUserCodeByUserId(long userId) {
        if (userId < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<UserCode> wrapper = new QueryWrapper<>();
        wrapper.eq("userId", userId);
        UserCode userCode = this.getOne(wrapper);
        ThrowUtils.throwIf(userCode == null, ErrorCode.NULL_ERROR, "此用户不存在");
        return userCode;
    }
}




