package tot.exception;

public class MemberNotFoundException extends CustomException {

	public MemberNotFoundException() {
		super(ErrorCode.NOT_FOUND_MEMBERID);
	}

}
