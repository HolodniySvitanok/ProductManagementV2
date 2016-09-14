package com.holodniysvitanok.service;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


import org.springframework.stereotype.Component;

@Component
public class ImageBox {

	public boolean saveImage(byte[] fileByte, String fileName, String url) {

		BufferedOutputStream bos = null;

		try {

			File file = createPath(fileName, url);
			bos = new BufferedOutputStream(new FileOutputStream(file));
			bos.write(fileByte);

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
				}
			}
		}

//		try{
//			
//			InputStream in = new ByteArrayInputStream(fileByte);
//			BufferedImage image = ImageIO.read(in);
//						
//			Image newImage = image.getScaledInstance(GlobalConfigProject.width, GlobalConfigProject.height, Image.SCALE_SMOOTH);
//			
//			BufferedImage bufferedImage = new BufferedImage(newImage.getWidth(null), newImage.getHeight(null),
//			        BufferedImage.TYPE_INT_RGB);
//			
//			Graphics g = bufferedImage.createGraphics();
//		    g.drawImage(newImage, 0, 0, null);
//		    g.dispose();
//			
//			ImageIO.write(bufferedImage, "jpg", createPath(fileName, url));
//			
//		}catch(Exception ex){
//			return false;
//		}
		
		
		
		return true;
	}

	public boolean deleteImage(String fileName, String url) {
		try {
			File file = createPath(fileName, url);
			file.delete();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	private File createPath(String fileName, String url) throws IOException {
		File file = new File(url+fileName);

		return file;
	}

}
