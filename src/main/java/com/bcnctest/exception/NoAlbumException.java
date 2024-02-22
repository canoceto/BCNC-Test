package com.bcnctest.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NoAlbumException extends RuntimeException {
    private String msg;
    private String code;

    public NoAlbumException(String msg, String code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

}
