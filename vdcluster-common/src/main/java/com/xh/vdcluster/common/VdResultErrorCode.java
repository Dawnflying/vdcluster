package com.xh.vdcluster.common;

/**
 * Created by macbookpro on 17/7/22.
 */
public class VdResultErrorCode {

    /**
     * 1000 - 1099 success code
     */
    public static final int AUTH_SUCCESS = 1000;
    public static final int SERVANT_SUCCESS = 1001;


    /**
     * 1100 - 1199 error code
     */
    public static final int AUTH_NONE = 1101;
    public static final int AUTH_FAILED = 1102;
    public static final int TOKEN_EXPIRED = 1103;
    public static final int TOKEN_ERROR = 1105;
    public static final int SERVER_ERROR = 1106;
    public static final int SERVANT_OVERLOAD = 1107;
    public static final int STREAM_ERROR = 1108;

}
