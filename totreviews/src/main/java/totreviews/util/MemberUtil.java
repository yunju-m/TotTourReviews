package totreviews.util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import totreviews.domain.MemberVO;

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

}
