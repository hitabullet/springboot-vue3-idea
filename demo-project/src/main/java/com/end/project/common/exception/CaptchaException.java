package com.end.project.common.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author root
 * @version 1.0
 * @description: TODO
 * @date 2021/12/9 13:19
 */
public class CaptchaException extends AuthenticationException {
    public CaptchaException(String explanation) {
        super(explanation);
    }
}
