package egovframework.example.signup.service;

import java.io.Serializable;

public class SignupVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int seq;
    private String email;
    private String url;
    private String captcha;
    
    public int getSeq() {
        return seq;
    }
    public void setSeq(int seq) {
        this.seq = seq;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getCaptcha() {
        return captcha;
    }
    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
