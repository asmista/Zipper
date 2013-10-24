package com.supinfo.zipper;

public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args != null && args.length > 0) {
			
			if(args[0].equalsIgnoreCase("COMPRESS")) {
				ZipCompresser compresser = new ZipCompresser(args[1], args[2]);
				compresser.compress();
			}
			
			if(args[0].equalsIgnoreCase("DECOMPRESS")) {
				ZipDecompresser decompresser = new ZipDecompresser(args[1]);
				decompresser.decompress();
			}			
		}
	}

}
