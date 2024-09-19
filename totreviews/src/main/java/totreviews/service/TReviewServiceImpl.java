package totreviews.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import totreviews.common.page.PageDTO;
import totreviews.common.page.PageReqDTO;
import totreviews.common.page.PageResDTO;
import totreviews.dao.TReviewDAO;
import totreviews.domain.DelegatingMultipartFile;
import totreviews.domain.TReviewImageVO;
import totreviews.domain.TReviewReqDTO;
import totreviews.domain.TReviewResDTO;
import totreviews.domain.TReviewVO;
import totreviews.exception.ServerException;
import totreviews.util.FileUtil;

@Service
public class TReviewServiceImpl implements TReviewService {

	@Autowired
	private TReviewDAO treviewDAO;

	@Autowired
	private FileUtil fileUtils;

	@Value("${file.upload-dir}")
	private String uploadDir;

	@Override
	public void insertTReview(TReviewReqDTO treviewReqDTO, MultipartFile[] imageFiles) {
		try {
			// DTO 검증
			treviewReqDTO.validate();

			TReviewVO tReviewVO = TReviewVO.fromDTO(treviewReqDTO);
			treviewDAO.insertTReview(tReviewVO);

			// 이미지 파일 처리
			TReviewImageVO tReviewImageVO = new TReviewImageVO();
			treviewReqDTO.setTrevId(tReviewVO.getTrevId());
			if (imageFiles != null && imageFiles.length > 0) {
				for (MultipartFile imageFile : imageFiles) {
					if (!imageFile.isEmpty()) {
						String imagePath = fileUtils.saveImage(imageFile);
						treviewReqDTO.setTrevImgpath(imagePath);
						tReviewImageVO = TReviewImageVO.fromDTO(treviewReqDTO);

						treviewDAO.insertTReviewImage(tReviewImageVO);
					}
				}
			}
		} catch (DataAccessException e) {
			throw new ServerException("여행 후기 데이터 삽입 중 데이터베이스 오류 발생", e);
		}
	}

	@Override
	public PageResDTO<TReviewResDTO> findTReviewListWithPaging(PageReqDTO pageReqDTO, String boardId) {
		try {
			PageDTO pageDTO = new PageDTO(pageReqDTO, boardId);

			int totalTReviewCount = treviewDAO.selectTotalTReviewCount(pageDTO);

			List<TReviewResDTO> postList = treviewDAO.selectTReviewListWithPaging(pageDTO);
			return new PageResDTO<>(totalTReviewCount, pageReqDTO.getPage(), postList);
		} catch (DataAccessException e) {
			throw new ServerException("여행 후기 목록 데이터 가져오던 중 데이터베이스 오류 발생", e);
		}
	}

	@Override
	public void incrementTReviewCount(int trevId) {
		try {
			treviewDAO.incrementTReviewCount(trevId);
		} catch (DataAccessException e) {
			throw new ServerException("여행 후기 조회수 증가 중 오류 발생", e);
		}

	}

	@Override
	public TReviewResDTO getTReviewById(int trevId) {
		try {
			return treviewDAO.getTReviewById(trevId);
		} catch (DataAccessException e) {
			throw new ServerException("여행 후기 상세 정보 정보 가져오던 중 오류 발생", e);
		}
	}

	@Override
	public void editTReview(TReviewReqDTO treviewReqDTO, MultipartFile[] imageFiles, List<String> existingImages) {
		try {
			treviewReqDTO.validate();
			TReviewResDTO treviewResDTO = treviewDAO.getTReviewById(treviewReqDTO.getTrevId());
			TReviewVO tReviewVO = TReviewVO.fromDTO(treviewReqDTO, treviewResDTO);

			treviewDAO.editTReview(tReviewVO);

			// 기존 이미지 삭제
			treviewDAO.deleteTReviewImages(tReviewVO.getTrevId());

			// 새로운 이미지 처리
			List<MultipartFile> allFiles = new ArrayList<>();

			if (existingImages != null) {
				for (String imagePath : existingImages) {
					File file = new File(uploadDir + "/" + imagePath);

					if (file.exists()) {
						Resource resource = new FileSystemResource(file);
						MultipartFile existingFile = new DelegatingMultipartFile(resource);
						allFiles.add(existingFile);
					}
				}
			}

			if (imageFiles != null && imageFiles.length > 0) {
				allFiles.addAll(Arrays.asList(imageFiles));
			}

			TReviewImageVO tReviewImageVO = new TReviewImageVO();
			for (MultipartFile imageFile : allFiles) {
				if (!imageFile.isEmpty()) {
					String imagePath = fileUtils.saveImage(imageFile);
					treviewReqDTO.setTrevImgpath(imagePath);
					tReviewImageVO = TReviewImageVO.fromDTO(treviewReqDTO);
					treviewDAO.insertTReviewImage(tReviewImageVO);
				}
			}
		} catch (DataAccessException e) {
			throw new ServerException("여행 후기 데이터 수정 중 데이터베이스 오류 발생", e);
		}

	}

}
