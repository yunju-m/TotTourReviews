package tot.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import tot.domain.MemberVO;
import tot.exception.MemberNotFoundException;
import tot.util.MemberUtil;

public class MemberUtilTest {

	private HttpSession mockSession; // Mock HttpSession 객체
	private MemberVO mockMember; // Mock MemberVO 객체

	@BeforeEach
	public void setUp() {
		mockSession = mock(HttpSession.class);
		mockMember = new MemberVO();

		HttpServletRequest mockRequest = mock(HttpServletRequest.class);
		when(mockRequest.getSession()).thenReturn(mockSession);

		// 현재 요청 속성을 설정하여 RequestContextHolder에 등록
		ServletRequestAttributes attributes = new ServletRequestAttributes(mockRequest);
		RequestContextHolder.setRequestAttributes(attributes);
	}

	/**
	 * 인증된 회원이 존재하는 경우
	 * getAuthenticatedMember() 메서드가 올바른 회원 정보를 반환하는지 테스트
	 */
	@Test
	public void testGetAuthenticatedMember_WithAuthenticatedMember() {
		// 세션에서 회원 정보를 반환하도록 설정
		when(mockSession.getAttribute("member")).thenReturn(mockMember);

		// 인증된 회원 정보가 반환되어야 함
		MemberVO result = MemberUtil.getAuthenticatedMember();
		assertNotNull(result, "인증된 회원 정보는 null이 아니어야 합니다.");
		assertEquals(mockMember, result, "반환된 회원 정보는 설정한 mockMember와 같아야 합니다.");
	}

	/**
	 * 인증된 회원이 존재하지 않는 경우
	 * getAuthenticatedMember() 메서드가 빈 MemberVO 객체를 반환하는지 테스트
	 */
	@Test
	public void testGetAuthenticatedMember_WithoutAuthenticatedMember() {
		// 세션에서 회원 정보가 없도록 설정
		when(mockSession.getAttribute("member")).thenReturn(null);

		// 빈 MemberVO 객체가 반환되어야 함
		MemberVO result = MemberUtil.getAuthenticatedMember();
		assertNotNull(result, "빈 MemberVO 객체는 null이 아니어야 합니다.");
		assertTrue(result.getMemId()== null || result.getMemId().isEmpty(), "반환된 MemberVO 객체는 비어있어야 합니다.");
	}

	/**
	 * 인증된 회원이 없는 경우
	 * isAuthenticatedMember() 메서드가 MemberNotFoundException을 발생하는지 테스트
	 */
	@Test
	public void testIsAuthenticatedMember_WithoutAuthenticatedMember() {
		// 세션에서 회원 정보가 없도록 설정
		when(mockSession.getAttribute("member")).thenReturn(null);

		// MemberNotFoundException이 발생해야 함
		assertThrows(MemberNotFoundException.class, MemberUtil::isAuthenticatedMember, "인증된 회원이 없으므로 예외가 발생해야 합니다.");
	}


	/**
	 * 인증된 회원이 존재하는 경우
	 * isMemberLoggedIn() 메서드가 true를 반환하는지 테스트
	 */
	@Test
	public void testIsMemberLoggedIn_WithAuthenticatedMember() {
		// 세션에서 회원 정보를 반환하도록 설정
		when(mockSession.getAttribute("member")).thenReturn(mockMember);

		// true가 반환되어야 함
		boolean result = MemberUtil.isMemberLoggedIn();
		assertTrue(result, "인증된 회원이 존재하므로 true가 반환되어야 합니다.");
	}

	/**
	 * 인증된 회원이 존재하지 않는 경우
	 * isMemberLoggedIn() 메서드가 false를 반환하는지 테스트
	 */
	@Test
	public void testIsMemberLoggedIn_WithoutAuthenticatedMember() {
		// 세션에서 회원 정보가 없도록 설정
		when(mockSession.getAttribute("member")).thenReturn(null);

		// false가 반환되어야 함
		boolean result = MemberUtil.isMemberLoggedIn();
		assertFalse(result, "인증된 회원이 없으므로 false가 반환되어야 합니다.");
	}
}
