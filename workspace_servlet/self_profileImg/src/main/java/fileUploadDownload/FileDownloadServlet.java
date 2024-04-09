package fileUploadDownload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class FileDownloadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); response.setContentType("text/html; charset=utf-8;");
		// 읽을 폴더
		String file_repo = "e:\\file_repo";
		// 파일명
		String fileName = request.getParameter("fileName");
		System.out.println("fileName : " + fileName);
		
		// 읽을 폴더의 '\\' 대신에 사용가능 (다른 운영체제에서도 오류 없이 돌아감)
		System.out.println("폴더 구분자 1 : " + System.getProperty("file.separator"));
		System.out.println("폴더 구분자 2 : " + File.separator);
		
		// full path (읽을 파일의 최종경로)
		String downFile = file_repo + File.separator + fileName;
		System.out.println("downFile : " + downFile);
		// 지정한 파일 그 자체
		File file = new File(downFile);
		
		// 파일을 읽을 흐름(stream)을 열어서 준비 (입구 open)
		FileInputStream in = new FileInputStream(file);
		
		// 브라우저가 cache를 사용하지 않도록 함
		// 브라우저는 같은 파일은 두번 안받으려 노력하는 성질이 있음
		response.setHeader("Cache-Control ", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName=" + fileName); // attachment : 첨부파일
		// 브라우저로 내보낼 수 있는 흐름(stream)을 열어서 준비
		OutputStream os = response.getOutputStream();
		
		
		// 흐름(stream)에서 java 메모리(JVM)로 퍼 나를 바가지 만들기 (임시 메모리)(보통 8kb정도를 씀)
		byte[] buffer = new byte[1024 * 1];
		
		// 파일 크기를 예상할 수 없으므로
		while(true) {
			// in.read(buffer) : buffer만큼 흐름(stream)에서 읽이서 java 메모리(JVM)에 올린다
			// 읽은 양 byte 만큼 돌려준다
			// 단, 더 읽을 내용이 없으면 -1을 돌려준다
			int count = in.read(buffer);
			System.out.println("읽은 크기(count) : " + count);
			
			// 더이상 읽을 내용이 없으면 퍼나르기 종료
			if(count == -1) {
				break;
			}
			
			// response의 내보내는 흐름(OutputStream)에 바가지의 내용을 보낸다
			// (buffer, 바가지의 처음 값부터, 읽은 만큼)
			os.write(buffer, 0, count);
			
		}
		
		in.close();
		os.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
