package cn.com.demo.tp06.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Random random = new Random();

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean bool = ServletFileUpload.isMultipartContent(request);
		if (bool) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> items = upload.parseRequest(request);
				
				// 确定目标目录（动态的获取到当前web应用的根路径（绝对路径））
				ServletContext ctx = request.getServletContext();
				// 获取/uploadImages的物理路径
				String rootRealPath = ctx.getRealPath("/uploadImages");
				String uploadPath = rootRealPath;
				
				for(FileItem item:items) {
					if(item.isFormField()) {
						// 获取参数名称和参数值（userName和userName的值）
						System.out.println(item.getFieldName() + " ," + item.getString());
					}else {
						// 获取原文件名，有些浏览器会包含路径
						String fileName = item.getName();
						// 确定目标文件名（按策略，产生一个唯一的文件名）
						String targetFileName = this.generateTargetFileName(fileName);
						targetFileName = uploadPath +"/" + targetFileName;
						// 将上传的文件内容，写入目标文件
						item.write(new File(targetFileName));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("不是文件上传的请求");
		}
	}

	private String generateTargetFileName(String sourceFileName) {
		String targetFileName = sourceFileName;
		targetFileName = String.valueOf(System.currentTimeMillis());
		targetFileName += "_" + random.nextInt(100);
		
		int index = sourceFileName.lastIndexOf(".");
		if(index != -1) {
			targetFileName += sourceFileName.substring(index);
		}
		return targetFileName;
	}
}
