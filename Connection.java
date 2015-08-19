import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Connection {
	
	HttpURLConnection con;
	URL url;
	
	
	public void conectar(){
		
		
		try {
		
			url = new URL("https://api.myjson.com/bins/25yo4");
			con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			InputStream in = con.getInputStream();
			InputStreamReader inreader = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inreader);
		 
			String line;
			StringBuffer response = new StringBuffer();
		 
			while((line = br.readLine())!= null){
				response.append(line.toString());
			}
		 
			System.out.println("Teste resposta: "+ response);
			br.close();
			in.close();
			inreader.close();
		}catch(Exception e){e.printStackTrace();}
	}
	
	
	public static void main(String[] arg){
		new Connection().conectar();
	}
   
}
