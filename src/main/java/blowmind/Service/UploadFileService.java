package blowmind.Service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileService {

	public String fileUpload(String path, MultipartFile documentPhoto1, String folder) {

		 String fileName = "";

		try {
			fileName = documentPhoto1.getOriginalFilename();
			byte[] bytes = documentPhoto1.getBytes();
			File file = new File(path + "/" + folder + "/" + fileName);
			file.getParentFile().mkdirs();
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
					
			bufferedOutputStream.write(bytes);
			bufferedOutputStream.close();
			return file.getName();
		} catch (Exception e) {
			return null;
		}

	}

}
