package tot.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import tot.exception.FileUploadDirectoryNotFoundException;
import tot.exception.FileUploadException;
import tot.exception.FileUploadInvalidFilenameException;

@Component
public class FileUtil {

	@Value("${file.upload-dir}")
	private String uploadDir; // 파일 업로드 디렉토리 경로

	// uploadDir의 값을 반환하는 getter 메서드
	public String getUploadDir() {
		return uploadDir;
	}

	/**
	 * 이미지를 저장하는 메서드.
	 *
	 * @param file 업로드할 이미지 파일
	 * @return 저장된 이미지의 경로
	 * @throws FileUploadDirectoryNotFoundException 디렉토리 설정이 잘못된 경우
	 * @throws FileUploadInvalidFilenameException   파일 이름이 유효하지 않은 경우
	 * @throws FileUploadException                  파일 저장 중 오류가 발생한 경우
	 */
	public String saveImage(MultipartFile file) {
		validateUploadDir(); // 업로드 디렉토리 유효성 검증

		String originalFilename = file.getOriginalFilename();
		validateFilename(originalFilename); // 파일 이름 유효성 검증

		String filename = generateUniqueFilename(originalFilename);
		Path targetPath = Paths.get(uploadDir, filename);

		try {
			Files.copy(file.getInputStream(), targetPath); // 파일 저장
			targetPath.toFile().setLastModified(System.currentTimeMillis()); // 수정 시간 설정
			return "/upload/" + filename; // 저장된 파일의 경로 반환
		} catch (IOException e) {
			throw new FileUploadException(); // 파일 저장 오류 발생
		}
	}

	/**
	 * 업로드 디렉토리의 유효성을 검증하는 메서드.
	 *
	 * @throws FileUploadDirectoryNotFoundException 디렉토리가 설정되지 않은 경우
	 */
	private void validateUploadDir() {
		if (uploadDir == null || uploadDir.isEmpty()) {
			throw new FileUploadDirectoryNotFoundException();
		}

		File uploadDirFile = new File(uploadDir);
		if (!uploadDirFile.exists()) {
			uploadDirFile.mkdirs(); // 디렉토리가 없으면 생성
		}
	}

	/**
	 * 파일 이름의 유효성을 검증하는 메서드.
	 *
	 * @param originalFilename 검사할 파일 이름
	 * @throws FileUploadInvalidFilenameException 파일 이름이 null인 경우 예외 발생
	 */
	private void validateFilename(String originalFilename) {
		if (originalFilename == null) {
			throw new FileUploadInvalidFilenameException();
		}
	}

	/**
	 * 고유한 파일 이름을 생성하는 메서드.
	 *
	 * @param originalFilename 원본 파일 이름
	 * @return 생성된 고유한 파일 이름
	 */
	private String generateUniqueFilename(String originalFilename) {
		String extension = originalFilename.substring(originalFilename.lastIndexOf(".")); // 파일 확장자 추출
		return UUID.randomUUID().toString() + extension; // 고유한 파일 이름 생성
	}
}
