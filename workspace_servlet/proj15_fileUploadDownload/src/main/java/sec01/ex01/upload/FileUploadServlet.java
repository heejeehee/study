package sec01.ex01.upload;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.jasper.tagplugins.jstl.core.If;

@WebServlet("/upload.do")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String encoding = "utf-8";
		request.setCharacterEncoding(encoding);
		
		try {
			// File ; 파일 또는 디렉토리(폴더)를 관리하는 class
			File currentDirPath = new File("E:\\file_repo");
			
			// 세팅
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(currentDirPath);
			// 처리하는 메모리 용량 (Byte 단위) (임시 메모리)
			factory.setSizeThreshold(1024 * 1024);	// 1MB
			// 8bit == 1바이트 Byte
			// 1024Byte == 1KB
			// 1024KB == 1MB
			// 1024MB == 1GB
			// 1024GB == 1TB
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 파일의 최대 크기 지정 (Byte 단위)
			upload.setFileSizeMax(1024*1024*100);	// 100MB
			
			// request를 분석하라
			// input 모두를 list 로 돌려줌
			List items = upload.parseRequest(request);
//			List<FileItem> items = upload.parseRequest(request);	// generic
			
			// 전체 input상자(list) 중에
			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);	// 하나를 뽑아서
//				FileItem fileItem = items.get(i);	// generic
				
				// 그 뽑은 값이
				if (fileItem.isFormField()) {
				// form 요소인지 판별
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
					// fileItem.getFieldName() : input의 name값
					// fileItem.getString(encoding) : input의 value값
					if(fileItem.getFieldName().equals("param1")) {
						System.out.println("param1 : " + fileItem.getFieldName());
						// 여기서 dto에 세팅
					}
					
				} else {
				// file 영역
					System.out.println("param:" + fileItem.getFieldName());	// name 속성
					System.out.println("file name:" + fileItem.getName());	// 업로드한 파일 명
					System.out.println("file size:" + fileItem.getSize() + "Bytes");

					if (fileItem.getSize() > 0) {	// 파일이 깨지거나 크기가 0 인건 제외.
						
						// 만약 파일이 c:\\file\name.jpg 이런식으로 들어오면 아래과정 실행.
						// 아이디어 1 : 파일명을 추출하는 
						int idx = fileItem.getName().lastIndexOf("\\");	// 윈도우
						System.out.println("idx : 1 : "+ idx);
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");	// 리눅스나 맥
						}
						System.out.println("idx : 2 : "+ idx);
						String fileName = fileItem.getName().substring(idx + 1);
						
						// 아이디어 2 : 파일명 중복 방지
						long timestamp = System.currentTimeMillis();
						fileName = timestamp +"_"+ fileName;
						
						File uploadFile = new File(currentDirPath + "\\" + fileName);
//						File uploadFile = new File(currentDirPath + File.separator + fileName);
//						File uploadFile = new File(currentDirPath + System.getProperty("file.separator") + fileName);
						fileItem.write(uploadFile);
						
						if(fileItem.getFieldName().equals("file1")) {
							System.out.println("file1 : " + fileItem.getFieldName());
							// 여기서 dto에 세팅
						}
					} 
				} 
			}
			
			// 이 지점에서 위쪽 for문 안에서 DTO(VO)를 완성하고
			// DB에 저장할 수 있겠다
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}