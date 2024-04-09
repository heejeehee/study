package fileUploadDownload;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload")
public class FileUploadServlet extends HttpServlet {
	
	private Connection connDB() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/OracleDB");
			conn = dataFactory.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String encoding = "utf-8";
		request.setCharacterEncoding(encoding);
		
		userDTO dto = new userDTO();
		
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
			List items = upload.parseRequest(request);
			
			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);

				if (fileItem.isFormField()) {
				// form 요소인지 판별
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));

					if(fileItem.getFieldName().equals("id")) {
						String id = fileItem.getString(encoding);
						dto.setId(id);
						System.out.println("id : " + dto.id);
					} else if(fileItem.getFieldName().equals("pw")) {
						String pw = fileItem.getString(encoding);
						dto.setPw(pw);
						System.out.println("pw : " + dto.pw);
					}
					
					
					
							
				} else {
				// file 영역
					System.out.println("param:" + fileItem.getFieldName());
					System.out.println("file name:" + fileItem.getName());
					System.out.println("file size:" + fileItem.getSize() + "Bytes");
					
					// 이미지 dto에 넣기
					dto.setImg(fileItem.getName());

					if (fileItem.getSize() > 0) {
						// 아이디어 1 : 파일명을 추출하는 
						int idx = fileItem.getName().lastIndexOf("\\");	// 윈도우
						System.out.println("idx : 1 : "+ idx);
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");	// 리눅스나 맥
						}
						System.out.println("idx : 2 : "+ idx);
						String fileName = fileItem.getName().substring(idx + 1);
						
						// 아이디어 2 : 파일명 중복 방지
//						long timestamp = System.currentTimeMillis();
//						fileName = timestamp +"_"+ fileName;
						
						File uploadFile = new File(currentDirPath + "\\" + fileName);
//						File uploadFile = new File(currentDirPath + File.separator + fileName);
//						File uploadFile = new File(currentDirPath + System.getProperty("file.separator") + fileName);
						fileItem.write(uploadFile);
					} // end if
				} // end if
			} // end for
			
			
			
			
			
			
			// 이 지점에서 위쪽 for문 안에서 DTO(VO)를 완성하고
			// DB에 저장할 수 있겠다
			
			Connection conn = null;
			PreparedStatement ps = null;
			int result = -1;
			
			try {
				conn = connDB();
				
				String sql = "";
				sql += " insert into usertest";
				sql += " (id, pw, img)";
				sql += " values";
				sql += " (?, ?, ?)";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, dto.getId());
				ps.setString(2, dto.getPw());
				ps.setString(3, dto.getImg());
				
				int rowAffected = ps.executeUpdate();
				if(rowAffected > 0) {
					System.out.println("insert sql : " + sql);
					System.out.println("insert clear");
					result = 1;
				} else {
					result = 0;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

				if (conn != null) {
					try {
						conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List list = new ArrayList();
		list.add(dto.getId());
		list.add(dto.getPw());
		list.add(dto.getImg());

		request.setAttribute("list", list);
		request.getRequestDispatcher("/mypage.jsp").forward(request, response);
		
	}

}
