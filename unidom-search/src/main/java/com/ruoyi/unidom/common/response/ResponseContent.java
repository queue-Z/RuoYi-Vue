package com.ruoyi.unidom.common.response;

import java.io.Serializable;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class ResponseContent<T> implements Serializable {
    private static final long serialVersionUID = -7347286191917162270L;
    private int code;
    private String message;
    private String detailMsg;
    private T data;

    public static ResponseContent success() {
        return success((Object)null);
    }

    public static <T> ResponseContent<T> success(final T data) {
        return build(0, "success", "", data);
    }

    public static ResponseContent failure(final int code, final String msg) {
        return failure(code, msg, "");
    }

//    public static ResponseContent failure(final ErrorCode errorCode) {
//        return failure(errorCode, "");
//    }
//
//    public static ResponseContent failure(final ErrorCode errorCode, final Throwable ex) {
//        return failure(errorCode, ExceptionUtils.getStackTrace(ex));
//    }
//
//    public static ResponseContent failure(final ErrorCode errorCode, final String detailMsg) {
//        return failure(errorCode.getCode(), errorCode.getMessage(), detailMsg);
//    }
//
//    public static <T> ResponseContent<T> failure(final ErrorCode errorCode, final T data) {
//        return build(errorCode.getCode(), errorCode.getMessage(), "", data);
//    }

    public static ResponseContent failure(final String msg) {
        return failure(-1, msg, (String)"");
    }

    public static ResponseContent failure(final String msg, final String detailMsg) {
        return failure(-1, msg, (String)detailMsg);
    }

    public static ResponseContent failure(final int code, final String msg, final String detailMsg) {
        return build(code, msg, detailMsg, (Object)null);
    }

    public static ResponseContent failure(final int code, final String msg, final Throwable ex) {
        return build(code, msg, ExceptionUtils.getStackTrace(ex), (Object)null);
    }

    public static <T> ResponseContent<T> build(final int code, final String msg, final String detailMsg, final T data) {
        return new ResponseContent(code, msg, detailMsg, data);
    }

    private static <T> int $default$code() {
        return 0;
    }

    public static <T> ResponseContentBuilder<T> builder() {
        return new ResponseContentBuilder();
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getDetailMsg() {
        return this.detailMsg;
    }

    public T getData() {
        return this.data;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setDetailMsg(final String detailMsg) {
        this.detailMsg = detailMsg;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ResponseContent)) {
            return false;
        } else {
            ResponseContent<?> other = (ResponseContent)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                label49: {
                    Object this$message = this.getMessage();
                    Object other$message = other.getMessage();
                    if (this$message == null) {
                        if (other$message == null) {
                            break label49;
                        }
                    } else if (this$message.equals(other$message)) {
                        break label49;
                    }

                    return false;
                }

                Object this$detailMsg = this.getDetailMsg();
                Object other$detailMsg = other.getDetailMsg();
                if (this$detailMsg == null) {
                    if (other$detailMsg != null) {
                        return false;
                    }
                } else if (!this$detailMsg.equals(other$detailMsg)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ResponseContent;
    }

    public String toString() {
        return "ResponseContent(code=" + this.getCode() + ", message=" + this.getMessage() + ", detailMsg=" + this.getDetailMsg() + ", data=" + this.getData() + ")";
    }

    public ResponseContent(final int code, final String message, final String detailMsg, final T data) {
        this.code = code;
        this.message = message;
        this.detailMsg = detailMsg;
        this.data = data;
    }

    public ResponseContent() {
        this.code = $default$code();
    }

    public static class ResponseContentBuilder<T> {
        private boolean code$set;
        private int code;
        private String message;
        private String detailMsg;
        private T data;

        ResponseContentBuilder() {
        }

        public ResponseContentBuilder<T> code(final int code) {
            this.code = code;
            this.code$set = true;
            return this;
        }

        public ResponseContentBuilder<T> message(final String message) {
            this.message = message;
            return this;
        }

        public ResponseContentBuilder<T> detailMsg(final String detailMsg) {
            this.detailMsg = detailMsg;
            return this;
        }

        public ResponseContentBuilder<T> data(final T data) {
            this.data = data;
            return this;
        }

        public ResponseContent<T> build() {
            int code = this.code;
            if (!this.code$set) {
                code = ResponseContent.$default$code();
            }

            return new ResponseContent(code, this.message, this.detailMsg, this.data);
        }

        public String toString() {
            return "ResponseContent.ResponseContentBuilder(code=" + this.code + ", message=" + this.message + ", detailMsg=" + this.detailMsg + ", data=" + this.data + ")";
        }
    }
}
