package tot.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * 사용자 예외 처리 메소드
	 *
	 * @param ex 발생한 사용자 예외
	 * @return 사용자 알림창 공통 페이지
	 */
	@ExceptionHandler(CustomException.class)
	public ModelAndView handleCustomException(CustomException ex) {
		logError(ex);
		return createAlertResponse(ex.getErrorCode());
	}

	/**
	 * IllegalArgumentException 처리 메소드
	 *
	 * @param ex 발생한 잘못된 인자 예외
	 * @return 잘못된 인자에 대한 에러 페이지
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	public ModelAndView handleIllegalArgumentException(IllegalArgumentException ex) {
		logError(ex);
		return createErrorResponse(ErrorCode.INVALID_ARGUMENT);
	}

	/**
	 * CannotGetJdbcConnectionException 처리 메소드
	 *
	 * @param ex 발생한 JDBC 연결 예외
	 * @return 데이터베이스 연결 오류 페이지
	 */
	@ExceptionHandler(org.springframework.jdbc.CannotGetJdbcConnectionException.class)
	public ModelAndView handleCannotGetJdbcConnectionException(
			org.springframework.jdbc.CannotGetJdbcConnectionException ex) {
		logError(ex);
		return createErrorResponse(ErrorCode.DATABASE_CONNECTION_ERROR);
	}

	/**
	 * 서버 예외 처리 메소드
	 *
	 * @param ex 발생한 서버 예외
	 * @return 서버 에러 페이지
	 */
	@ExceptionHandler(ServerException.class)
	public ModelAndView handleGlobalException(ServerException ex) {
		logError(ex);
		return createErrorResponse(ex.getErrorCode());
	}

	/**
	 * 사용자 예외 알림 페이지 생성 메소드
	 *
	 * @param errorCode 오류 코드
	 * @return 사용자 알림창 공통 페이지
	 */
	private ModelAndView createAlertResponse(ErrorCode errorCode) {
		ModelAndView modelAndView = new ModelAndView("common");
		modelAndView.addObject("status", errorCode.getCode());
		modelAndView.addObject("message", errorCode.getMessage());

		return modelAndView;
	}

	/**
	 * 에러 응답을 생성하는 공통 메소드
	 *
	 * @param errorCode 오류 코드
	 * @return 서버 에러 페이지
	 */
	private ModelAndView createErrorResponse(ErrorCode errorCode) {
		ModelAndView modelAndView = new ModelAndView("errorPage");
		modelAndView.addObject("status", errorCode.getCode());
		modelAndView.addObject("message", errorCode.getMessage());
		modelAndView.setStatus(errorCode.getHttpStatus());

		return modelAndView;
	}

	/**
	 * 예외 발생 시 에러 로그를 기록하는 메소드
	 *
	 * @param ex 발생한 예외
	 */
	private void logError(Exception ex) {
		logger.error("{} occurred: {}", ex.getClass().getSimpleName(), ex.getMessage());
		logger.error("[Error] ", ex);
	}
}
