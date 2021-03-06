package com.supinfo.zipper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCompresser {
	
	private String archive;
	private String fileName;

	public ZipCompresser(String archive, String fileName) {
		this.archive = archive;
		this.fileName = fileName;
	}
	
	public void compress() {
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		FileInputStream fis = null;
		ZipEntry entry = null;
		try {
			fos = new FileOutputStream(archive);
			zos = new ZipOutputStream(fos);
			
			File file = new File(fileName);
			byte[] buffer = new byte[(int) file.length()];
			
			fis = new FileInputStream(file);
			entry = new ZipEntry(file.getName());
			zos.putNextEntry(entry);
			
			while(fis.read(buffer) != -1) {
				zos.write(buffer);
			}
			
			zos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(zos != null) {
				try {
					zos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String getArchive() {
		return archive;
	}

	public void setArchive(String archive) {
		this.archive = archive;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
