package com.end.project.common.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author root
 * @version 1.0
 * @description: TODO
 * @date 2021/12/10 13:47
 */
public class TokenException extends
        AuthenticationException {
    public TokenException(String message) {
        super(message);
    }
}
