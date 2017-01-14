package org.bit.linc;

public class SysimpleException extends Exception{
	public SysimpleException() {
    }

    public SysimpleException(String message) {
        super(message);
    }

    public SysimpleException(String message, Throwable cause) {
        super(message, cause);
    }

    public SysimpleException(Throwable cause) {
        super(cause);
    }

    public SysimpleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
