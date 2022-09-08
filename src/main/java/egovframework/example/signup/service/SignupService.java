package egovframework.example.signup.service;

public interface SignupService {
	public int insertTuser (SignupVO vo) throws Exception;
	
	public int insertTarclogin (SignupVO vo) throws Exception;
	
	public Long selectSignupEmail (SignupVO vo) throws Exception;
	
	public Long selectUserEmail (SignupVO vo) throws Exception;
	
	public Long selectUserLoginId (SignupVO vo) throws Exception;
	
	public Long selectUserSeq (SignupVO vo) throws Exception;
}
