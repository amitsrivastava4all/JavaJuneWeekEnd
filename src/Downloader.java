import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Downloader {

	static String getFileName(String url) {
		int index = url.lastIndexOf("/");
		String fileName  = url.substring(index+1);
		return fileName;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String downloadLocation = "/Users/amit/Documents/FileOutput/download";
		//Scanner s = new Scanner(System.in);
		//String urlName  = s.next();
		//String urlName = "http://awallpapersimages.com/wp-content/uploads/2016/09/Sachin-Tendulkar-HD-Wallpapers-1.jpg";
		String urlName = "https://media.sportsmatik.com/hof/sachin-Tendulkar2-min_1489655166_99365.jpg";
		URL url = new URL(urlName);
		String fileName = getFileName(urlName);
		System.out.println("File Name is "+fileName);
		URLConnection connection = url.openConnection();
		connection.connect();  // request to the server
		InputStream is = connection.getInputStream();
		int singleByte = is.read();
		StringBuilder sb = new StringBuilder();
		String path = downloadLocation+"/"+fileName;
		System.out.println("Path is "+path);
		File file = new File(path);
		FileOutputStream fs= new FileOutputStream(file);
				/*File file = new File(downloadLocation+"/test.html");
				
				fs.write(arr);
				fs.close();*/
		while(singleByte!=-1){
			//sb.append((char)singleByte);
			fs.write(singleByte);
			singleByte = is.read();
		}
		is.close();
		fs.close();
		System.out.println("File Downloaded....");
		//System.out.println(sb);
		//byte arr[] = is.readAllBytes();
		
		System.out.println("Downloaded....");
	}

}

















