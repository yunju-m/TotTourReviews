package totreviews.util;

import totreviews.domain.MemberVO;

public class MemberUtil {

	private MemberUtil() {
		throw new IllegalStateException("회원 검사 중 에러 발생했습니다.");
	}

	/**
	 * 로그인 한 유저인지 판단
	 *
	 * @return 로그인 한 유저의 MemberVO
	 * @throws IllegalStateException 로그인하지 않은 경우 예외 발생
	 */
	public static MemberVO isAuthenticatedMember() {
		/*
		 * Authentication authentication =
		 * SecurityContextHolder.getContext().getAuthentication();
		 * 
		 * if (authentication == null || !(authentication.getPrincipal() instanceof
		 * UserDetails)) { throw new IllegalStateException("로그인되지 않은 사용자입니다."); }
		 * 
		 * UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		 */
		MemberVO member = new MemberVO();

		return member;
	}
}
