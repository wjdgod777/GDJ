package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class ApiMain {
	
	public static void q1() {
		
		String serviceKey = "WHLGC0CAk8KYHMedNIFfMV8vDaFnI1HTCzDZUgZAvkSPYFUECq+PgLXOBlo5TOfghtzG0a1jHiAjMoHaBN2pRA==";

		StringBuilder urlBuilder = new StringBuilder();
		try {
			urlBuilder.append("http://apis.data.go.kr/B552061/AccidentDeath");
			urlBuilder.append("?ServiceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&searchYear=2021");
			urlBuilder.append("&siDo=1100");
			urlBuilder.append("&guGun=1125");
			urlBuilder.append("&type=json");
			urlBuilder.append("&occrrnc_dt=10");
			urlBuilder.append("&occrrnc_day_cd=1");
			urlBuilder.append("&dth_dnv_cnt=3");
			urlBuilder.append("&injpsn_cnt=3");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	
		String apiURL = urlBuilder.toString();
		
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		} catch (MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch (IOException e) {
			System.out.println("API 접속 실패");
		}
		
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		try {

			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}

			reader.close();

		} catch (IOException e) {
			System.out.println("API 응답 실패");
		}
		
		String response = sb.toString();
		
		File file = new File("accident.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			
			br.readLine();
			
			List<Accident> accidents = new ArrayList<Accident>();
			String line = null;
			while((line = br.readLine()) != null) {
				String[] arr = line.split(",");
				Accident accident = new Accident();
				accident.setOccrrncDt(arr[0]);
				accident.setOccrrncDayCd(arr[1]);
				accident.setDthDnvCnt(Integer.parseInt(arr[2]));
				accident.setInjpsnCnt(Integer.parseInt(arr[3]));
				accidents.add(accident);
				
			}
			
			for(Accident accident : accidents) {
				System.out.println(accident);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		

}
	
	

	public static void main(String[] args) {

		q1();
	}
		


}
