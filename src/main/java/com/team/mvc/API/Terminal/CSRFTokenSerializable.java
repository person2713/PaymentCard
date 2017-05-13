package com.team.mvc.API.Terminal;

import org.springframework.security.web.csrf.CsrfToken;

import java.io.Serializable;

/**
 * Created by dronp on 15.04.2017.
 */
public class CSRFTokenSerializable<T> implements Serializable {

    private String X_CSRF_HEADER;
    private String X_CSRF_PARAM;
    private String X_CSRF_TOKEN;
    private T RequestBody;

    public CSRFTokenSerializable(CsrfToken token) {
        X_CSRF_HEADER = token.getHeaderName();
        X_CSRF_PARAM = token.getParameterName();
        X_CSRF_TOKEN = token.getToken();
    }

    public CSRFTokenSerializable(CsrfToken token, T object) {
        X_CSRF_HEADER = token.getHeaderName();
        X_CSRF_PARAM = token.getParameterName();
        X_CSRF_TOKEN = token.getToken();
        RequestBody = object;
    }

    public String getX_CSRF_HEADER() {
        return X_CSRF_HEADER;
    }

    public void setX_CSRF_HEADER(String x_CSRF_HEADER) {
        X_CSRF_HEADER = x_CSRF_HEADER;
    }

    public String getX_CSRF_PARAM() {
        return X_CSRF_PARAM;
    }

    public void setX_CSRF_PARAM(String x_CSRF_PARAM) {
        X_CSRF_PARAM = x_CSRF_PARAM;
    }

    public String getX_CSRF_TOKEN() {
        return X_CSRF_TOKEN;
    }

    public void setX_CSRF_TOKEN(String x_CSRF_TOKEN) {
        X_CSRF_TOKEN = x_CSRF_TOKEN;
    }

    public T getRequestBody() {
        return RequestBody;
    }

    public void setRequestBody(T ObjectBody) {
        this.RequestBody = ObjectBody;
        this.RequestBody = ObjectBody;
    }
//"X-CSRF-HEADER", token.getHeaderName()
//"X-CSRF-PARAM", token.getParameterName()
//"X-CSRF-TOKEN", token.getToken()
}