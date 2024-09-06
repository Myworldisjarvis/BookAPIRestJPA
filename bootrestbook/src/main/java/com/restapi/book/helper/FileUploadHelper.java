package com.restapi.book.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.data.convert.Jsr310Converters.ZoneIdToStringConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public final String UPLOAD_DIR = "C:\\Users\\names\\git\\BookAPIRestJPA\\bootrestbook\\src\\main\\resources\\static\\image";

	public boolean uploadFile(MultipartFile file) {
		boolean b = false;

		try {
//			old API
//			InputStream is = file.getInputStream();
//			byte data[]  = new byte[is.available()];
//			is.read(data);
//			//write
//			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+file.getOriginalFilename());
//			fos.write(data);
//			
//			fos.flush();
//			fos.close();
//			is.close();

			// new - nio packege

			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);

			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return b;
	}

}
