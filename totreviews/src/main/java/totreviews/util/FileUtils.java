package totreviews.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {

	private static final String UPLOAD_DIR = "uploads/";

	static {
		File uploadDir = new File(UPLOAD_DIR);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
	}

	public static String saveImage(MultipartFile file) {
		String originalFilename = file.getOriginalFilename();
		String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
		String filename = UUID.randomUUID().toString() + extension;
		try {
			File targetFile = new File(UPLOAD_DIR + filename);
			Files.copy(file.getInputStream(), targetFile.toPath());
			return filename;
		} catch (IOException e) {
			throw new RuntimeException("파일 저장 중 오류 발생", e);
		}
	}
}
