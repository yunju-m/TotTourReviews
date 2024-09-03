package totreviews.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	// ValidationException 처리
    @ExceptionHandler(ValidationException.class)
    public ModelAndView handleValidationException(ValidationException e) {
        String errorMessage = e.getErrorCode().getMessage();

        return getModelAndView(errorMessage);
    }

	// 경고창으로 보내기 위한 에러메시지 전달
	private ModelAndView getModelAndView(String message) {
		ModelAndView mav = new ModelAndView("common");
		mav.addObject("message", message);
		return mav;
	}

}
