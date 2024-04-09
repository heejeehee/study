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

import sec01.exam.signup.SignupDTO;

@WebServlet("/upload2.do")
public class FileUpload2 extends HttpServlet {
	private static final long serialVersionUID = 2341123413L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String basePath = "C:\\file_repo";
		
		request2DTO(basePath, request);
	}
	
	// request를 분석해서 DTO에 채워서 return해줌
	
	public SignupDTO request2DTO(String basePath, HttpServletRequest request) throws ServletException, IOException {
		
		SignupDTO dto = new SignupDTO();
		
		String encoding = "utf-8";
		request.setCharacterEncoding(encoding);
		
		try {
			File currentDirPath = new File(basePath);
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(currentDirPath);
			factory.setSizeThreshold(1024 * 1024);
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(1024*1024*100);

			List<FileItem> items = upload.parseRequest(request);
			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);

				if (fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));

					if(fileItem.getFieldName().equals("id")) {
						dto.setId(fileItem.getString(encoding));
					} else if (fileItem.getFieldName().equals("pw")) {
						dto.setPw(fileItem.getString(encoding));
					}

				} else {
				// file 영역
					System.out.println("file name:" + fileItem.getName()); // 실제 업로드한 파일 명
					System.out.println("file size:" + fileItem.getSize() + "Bytes");

					if (fileItem.getSize() > 0) {
						String fileName = fileItem.getName();
						
						// 아이디어 2 : 파일명 중복 방지
						long timestamp = System.currentTimeMillis();
						fileName = timestamp +"_"+ fileName;
						
						File uploadFile = new File(currentDirPath + "\\" + fileName);
						fileItem.write(uploadFile);
						
						if(fileItem.getFieldName().equals("img_file")) {
							dto.setFilename(fileName);
						}
					} // end if
				} // end if
			} // end for
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
}
