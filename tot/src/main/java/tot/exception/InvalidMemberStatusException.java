package tot.exception;

public class InvalidMemberStatusException extends ServerException {

	public InvalidMemberStatusException() {
		super(ErrorCode.FORBIDDEN_ACCESS);
	}

}
