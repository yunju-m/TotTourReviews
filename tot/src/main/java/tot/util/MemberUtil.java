package tot.util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import tot.domain.MemberVO;
import tot.exception.MemberNotFoundException;

public class MemberUtil {

	/**
	 * 인증된 회원 정보를 반환합니다.
	 * 
	 * @return 인증된 회원 정보가 없으면 빈 MemberVO 객체를 반환합니다.
	 */
	public static MemberVO getAuthenticatedMember() {
		MemberVO member = (MemberVO) getSession().getAttribute("member");
		return (member != null) ? member : new MemberVO(); // 빈 객체 반환
	}

	/**
	 * 인증된 회원이 존재하지 않으면 예외를 던집니다.
	 * 
	 * @return 인증된 회원 정보
	 * @throws MemberNotFoundException 인증된 회원이 없을 경우 발생합니다.
	 */
	public static MemberVO isAuthenticatedMember() {
		MemberVO member = (MemberVO) getSession().getAttribute("member");

		if (member == null) {
			throw new MemberNotFoundException(); // 예외 던짐
		}

		return member;
	}

	/**
	 * 인증된 회원이 존재하는지 여부를 반환합니다.
	 * 
	 * @return 인증된 회원이 존재하면 true, 그렇지 않으면 false를 반환합니다.
	 */
	public static boolean isMemberLoggedIn() {
		MemberVO member = (MemberVO) getSession().getAttribute("member");
		return member != null; // 존재 여부 반환
	}

	/**
	 * 현재 요청의 HttpSession을 가져오는 공통 메서드입니다.
	 * 
	 * @return 현재 세션
	 */
	private static HttpSession getSession() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest().getSession(); // 세션 반환
	}
}
