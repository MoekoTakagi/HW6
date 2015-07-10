import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;

public class Sorting10GB{

	public static void main(String[] args){
		File inputFile = new File("/Users/takagimoeko/step2015/test");
		ArrayList<Integer> list = new ArrayList<Integer>();
		BufferedInputStream bis = null;
		int j = 0;
		try{
			FileInputStream fis = new FileInputStream(inputFile);
			bis = new BufferedInputStream(fis);


			while(true){
				int i = bis.read();
				if(i == -1){
					break;
				}
				list.add(new Integer(i));
			}
		}catch(IOException ie){
			System.out.println(ie);
		}finally{
			try{
				if(bis != null){
					bis.close();
				}
			}catch(IOException e){
				System.out.println(e);
			}
		}
		QuickSort.sort(list);
	}
}