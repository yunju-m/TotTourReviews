package totreviews.util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import totreviews.domain.MemberVO;
import totreviews.exception.ErrorCode;
import totreviews.exception.ValidationException;

public class MemberUtil {

	public static MemberVO getAuthenticatedMember() {
		// RequestContextHolder에서 현재 RequestAttributes 가져오기
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

		// RequestAttributes에서 HttpSession 가져오기
		HttpSession session = attr.getRequest().getSession();

		MemberVO member = (MemberVO) session.getAttribute("member");

		// member가 null인 경우 빈 MemberVO 반환
		if (member == null) {
			return new MemberVO(); // 빈 MemberVO 객체 반환
		}

		return member;
	}

	public static MemberVO isAuthenticatedMember() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();

		MemberVO member = (MemberVO) session.getAttribute("member");

		if (member == null) {
			throw new ValidationException(ErrorCode.NOT_FOUND_MEMBERID);
		}

		return member;
	}

}
