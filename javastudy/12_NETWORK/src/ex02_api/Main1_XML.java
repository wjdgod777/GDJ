package ex02_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Main1_XML {
	
	// 요청
	// 1. Request
	// 2. 클라이언트 -> 서버
	
	// 파라미터
	// 1. Parameter
	// 2. 보내는 데이터(변수 개념)
	
	// 응답
	// 1. Response
	// 2. 서버 -> 클라이언트
	
	public static void m1() {
		
		// 전국종량제봉투가격표준데이터
		
		// API 주소(주소 + 요청 파라미터)
		
		String apiURL = "http://api.data.go.kr/openapi/tn_pubr_public_weighted_envlp_api";
		
		try {
			String serviceKey = "WHLGC0CAk8KYHMedNIFfMV8vDaFnI1HTCzDZUgZAvkSPYFUECq+PgLXOBlo5TOfghtzG0a1jHiAjMoHaBN2pRA==";
			apiURL += "?pageNo=" + URLEncoder.encode("0", "UTF-8");
			apiURL += "&numOfRows=" + URLEncoder.encode("100", "UTF-8");
			apiURL += "&type=" + URLEncoder.encode("xml", "UTF-8");
			apiURL += "&CTPRVN_NM=" + URLEncoder.encode("인천광역시", "UTF-8");
			apiURL += "&SIGNGU_NM=" + URLEncoder.encode("계양구", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_TYPE=" + URLEncoder.encode("규격봉투", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_MTHD=" + URLEncoder.encode("소각용", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_PRPOS=" + URLEncoder.encode("생활쓰레기", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_TRGET=" + URLEncoder.encode("기타", "UTF-8");
			apiURL += "&serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
			
		} catch(UnsupportedEncodingException e) {
			System.out.println("인코딩 실패");
		}
		
		// API 주소 접속
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
			
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch(IOException e) {
			System.out.println("API 주소 접속 실패");
		}
	
		// 입력 스트림(응답) 생성
		// 1. 응답 성공 시 정상 스트림, 실패 시 에러 스트림
		// 2. 응답 데이터는 StringBuilder에 저장
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		try {
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			while((line = reader.readLine()) != null) {	// readLine()은 BufferedReader에서 지원
				sb.append(line + "\n");
			}
			
			// 스트림 종료
			reader.close();
			
				
		} catch(IOException e) {
			System.out.println("API 응답 실패");
		}
		
		// API로부터 전달받은 xml 데이터
		String response = sb.toString();
		
		// File 생성
		File file = new File("C:\\storage", "api1.xml");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		 
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();	// <response>
			System.out.println(root.getNodeName());
			
			NodeList nodeList = root.getChildNodes();	// <response>의 자식 태그(<header>, <body>)
			for(int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);			//  <header>와 <body>
				System.out.println("  " + node.getNodeName());
				
				NodeList nodeList2 = node.getChildNodes();			// <header>의 자식 태그(<resultCode>, <resultMsg>), <body>의 자식 태그(<items>, <nomOfRows>, <pageNo>, <totalCount>) 
				for(int j = 0; j < nodeList2.getLength(); j++) {
					Node node2 = nodeList2.item(j);
					System.out.println("    " + node2.getNodeName());
					
					if(node2.getNodeName().equals("items")) {	// <items> 태그 대상
						NodeList items = node2.getChildNodes();	// <items>의 자식 태그(<item>)
						for(int k = 0; k < items.getLength(); k++) {
							Node item = items.item(k);
							System.out.println("      " + item.getNodeName());
							
							NodeList itemChildren = item.getChildNodes();	// <item>의 자식 태그
							for(int l = 0; l < itemChildren.getLength(); l++) {
								Node itemChild = itemChildren.item(l);
								System.out.println("        " + itemChild.getNodeName() + ":" + itemChild.getTextContent());
							}
						}
					}
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		// 접속 종료
		con.disconnect();
	}
	
	public static void m2() {
		
		// 보건복지부_코로나 19 감염현황 조회 서비스
		
				// 인증키(Decoding)
				String serviceKey = "bEQBRPHjt0tZrc7EsL0T8usfsZ1+wT+5jqamBef/ErC/5ZO6N7nYdRmrwR91bh5d3I1AQeY5qdbJOF6Kv0U1CQ==";

				// API 주소	(주소 + 요청 파라미터)
				StringBuilder urlBuilder = new StringBuilder();
				try {
					urlBuilder.append("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson");
					urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
					urlBuilder.append("&startCreateDt=20220808");
					urlBuilder.append("&endCreateDt=20220812");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
				String apiURL = urlBuilder.toString();
				
				// API 주소 접속
				URL url = null;
				HttpURLConnection con = null;
				
				try {			
					url = new URL(apiURL);
					con = (HttpURLConnection) url.openConnection();
					con.setRequestMethod("GET");
					con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
				} catch(MalformedURLException e) {
					System.out.println("API 주소 오류");
				} catch(IOException e) {
					System.out.println("API 접속 실패");
				}
				
				// 입력 스트림 생성
				// 1. 서버가 보낸 데이터를 읽어야 하므로 입력 스트림이 필요
				// 2. 서버와 연결된 입력 스트림은 바이트 스트림이므로 문자 스트림으로 변환해야 함
				BufferedReader reader = null;
				StringBuilder sb = new StringBuilder();
				try {
					
					if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
						reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
					} else {
						reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
					}
					
					String line = null;
					while((line = reader.readLine()) != null) {
						sb.append(line + "\n");
					}
					
					// 스트림 종료
					reader.close();
					
				} catch(IOException e) {
					System.out.println("API 응답 실패");
				}
				
				// API로부터 전달받은 xml 데이터
				String response = sb.toString();
				
				// XML File 생성
				File file = new File("C:\\storage", "api2.xml");
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(file));
					bw.write(response);
					bw.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
		
	}
	
	public static void m3() {
		
		// xml 파싱
		File file = new File("C:\\storage", "api2.xml");
		
		try {
			
			// api2.xml 문서 -> doc 객체
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			// api2.xml 문서의 최상위 태그 -> root 
			Element root = doc.getDocumentElement();
			
			// <item>...</item> 태그 하나 == 특정 날짜의 데이터
			StringBuilder sb = new StringBuilder();
			NodeList items = root.getElementsByTagName("item");	// 태그 이름으로 찾기
			for(int i = 0; i < items.getLength(); i++) {
				Node item = items.item(i);
				NodeList itemChildren = item.getChildNodes();
				for(int j = 0; j < itemChildren.getLength(); j++) {
					Node itemChild = itemChildren.item(j);
					if(itemChild.getNodeName().equals("stateDt")) {
						sb.append(" 날짜 : ").append(itemChild.getTextContent());
					} else if(itemChild.getNodeName().equals("decideCnt")) {
						sb.append(" 확진자 수 : ").append(itemChild.getTextContent());
					} else if(itemChild.getNodeName().equals("deathCnt")) {
						sb.append(" 사망자 수 : ").append(itemChild.getTextContent());
					}
				}
				sb.append("\n");
				
				// Node stateDt					== <stateDt>20220812</stateDt>
				// stateDt						== stateDt	(태그이름)
				// stateDt.getTextContent()		== 20220812	(태그내부텍스트)
				
			} System.out.println(sb.toString());
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void m4() {
		
		   
		  // 초단기 날씨 예측
		  //오늘날짜, 11시 기준ㅡ 파일명 api3.xml
		  
		  
		String serviceKey = "aJcw6UfRa/b1KW7wJ0vYvM4xyNFeo9R08KH7EI7DVz6mzQsRueWfsu1e1yZfAKD5KSkw6aspN8JWFHPuHBGHLQ==";
		  
		StringBuilder urlBuilder = new StringBuilder();
		  
		try {
	         
			urlBuilder.append("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst");
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&pageNo=1");
			urlBuilder.append("&numOfRows=1000");
			urlBuilder.append("&base_date=20220818");
			urlBuilder.append("&base_time=1100");
			urlBuilder.append("&nx=58");
			urlBuilder.append("&ny=125");
	                  
		} catch (UnsupportedEncodingException e) {
	         
		}
	      
		String apiURL = urlBuilder.toString();
	      
		URL url = null;
		HttpURLConnection con = null;
	      
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
	         
		} catch (MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch (IOException e) {
			System.out.println("API 접속 실패");
		}
	      
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		try {
	         
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
	         
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
			} catch (IOException e) {
				System.out.println("API 응답 실패");
			}
	      
		String response = sb.toString();
	      
		File file = new File ("C:\\storage", "api3.xml");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	         
	      
	}
		   
	public static void m5() {
		// 기상청41_단기예보 조회서비스
		
		// 인증키(Decoding)
		String serviceKey = "bEQBRPHjt0tZrc7EsL0T8usfsZ1+wT+5jqamBef/ErC/5ZO6N7nYdRmrwR91bh5d3I1AQeY5qdbJOF6Kv0U1CQ==";

		// API 주소	(주소 + 요청 파라미터)
		StringBuilder urlBuilder = new StringBuilder();
		try {
			urlBuilder.append("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst");
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&numOfRows=10");
			urlBuilder.append("&pageNo=1");
			urlBuilder.append("&dataType=XML");
			urlBuilder.append("&base_date=20220818");
			urlBuilder.append("&base_time=1100");
			urlBuilder.append("&nx=58");   // 서울특별시 금천구 가산동 좌표X
			urlBuilder.append("&ny=125");  // 서울특별시 금천구 가산동 좌표Y
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String apiURL = urlBuilder.toString();
		
		// API 주소 접속
		URL url = null;
		HttpURLConnection con = null;
		
		try {			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch(IOException e) {
			System.out.println("API 접속 실패");
		}
		
		// 입력 스트림 생성
		// 1. 서버가 보낸 데이터를 읽어야 하므로 입력 스트림이 필요
		// 2. 서버와 연결된 입력 스트림은 바이트 스트림이므로 문자 스트림으로 변환해야 함
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		try {
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			while((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			// 스트림 종료
			reader.close();
			
		} catch(IOException e) {
			System.out.println("API 응답 실패");
		}
		
		// API로부터 전달받은 xml 데이터
		String response = sb.toString();
		
		// XML File 생성
		File file = new File("C:\\storage", "api3.xml");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void m6() {
		
		File file = new File("C:\\storage", "api3.xml");
		
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();
			
			NodeList items = root.getElementsByTagName("item");
			for(int i = 0; i < items.getLength(); i++) {
				Element item = (Element)items.item(i);	// Node -> Element 타입으로 다운캐스팅
				Node category = item.getElementsByTagName("category").item(0);
				Node obsrValue = item.getElementsByTagName("obsrValue").item(0);
				String strCategory = null;
				switch(category.getTextContent()) {
				case "PTY" : strCategory = "강수형태"; break;
				case "REH" : strCategory = "습도"; break;
				case "RN1" : strCategory = "강수량(1시간)"; break;
				case "T1H" : strCategory = "기온"; break;
				case "UUU" : strCategory = "동서바람성분"; break;
				case "VEC" : strCategory = "풍향"; break;
				case "VVV" : strCategory = "남북바람성분"; break;
				case "WSD" : strCategory = "풍속"; break;
				}
				System.out.println(strCategory + ":" + obsrValue.getTextContent());
			}
		} catch(Exception e) {
			
		}
		
	}
	
	public static void m7() {
		
		// 기상청 RSS
		
		String apiURL = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=5013061000";
	      URL url = null;
	      HttpURLConnection con = null;
	      
	      try {
	         url = new URL(apiURL.toString());
	         con = (HttpURLConnection)url.openConnection();
	         con.setRequestMethod("GET");
	         con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
	      } catch (MalformedURLException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      
	      // 입력 스트림
	      BufferedReader reader = null;
	      StringBuilder sb = new StringBuilder();
	      
	      try {
	         if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
	            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
	         } else {
	            reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	         }
	         
	         String line = null;
	         while((line = reader.readLine()) != null) {
	            sb.append(line + "\n");
	         }
	         reader.close();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      
	      String response = sb.toString();
	      
	      // File생성
	      File file = new File("C:\\storage","m7.xml");
	      try {
	         BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	         bw.write(response);
	         bw.close();   
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      
	      System.out.println(sb.toString());
	      
	      
	   }

	public static void m8() {
		
		 // parsing 기상청 RSS
	      
	      File file = new File("C:\\storage" , "m7.xml");
	      try {
	         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder builder = factory.newDocumentBuilder();
	         Document doc = builder.parse(file);
	         
	         Element root = doc.getDocumentElement(); // 최상위요소
	         
	         StringBuilder sb = new StringBuilder();
	         
	         Node title = root.getElementsByTagName("title").item(0);
	         sb.append(title.getTextContent() + "\n");
	         
	         Node pubDate = root.getElementsByTagName("pubDate").item(0);
	         sb.append(pubDate.getTextContent() + "\n");
	         
	         NodeList data = root.getElementsByTagName("data");
	         System.out.println(title.getTextContent());
	         System.out.println(pubDate.getTextContent());
	         for(int i = 0; i < data.getLength(); i++) {
	            Element item = (Element)data.item(i);
	            Node hour = item.getElementsByTagName("hour").item(0);
	            Node temp = item.getElementsByTagName("temp").item(0);
	            Node wfKor = item.getElementsByTagName("wfKor").item(0);
	            
	            
	            System.out.println(hour.getTextContent() + "시 \t" + temp.getTextContent() + "도 \t" + wfKor.getTextContent());
	         }
	         
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	   }
	
	public static void m9() {
		
		try {
			
			// 접속
			String apiURL = "https://www.kma.go.kr/XML/weather/sfc_web_map.xml";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			// 접속 확인
			if(con.getResponseCode() != HttpURLConnection.HTTP_OK) {
				System.out.println("API 접속 실패");
				return;
			}
			
			// 바이트 입력 스트림 -> 문자 입력 스트림 -> 버퍼 추가
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			File file = new File("C:\\storage", "sfc_web_map.xml");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			
			// readLine() 메소드를 이용한 복사
			String line = null;
			while((line = br.readLine()) != null) {
				bw.write(line + "\n");
			}
			
			// 닫기
			bw.close();
			br.close();
			con.disconnect();
			
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch(IOException e) {
			System.out.println(e.getMessage());
			System.out.println("API 서버 오류");
		}
	}
	
	public static void m10() {
		
		File file = new File("C:\\storage", "sfc_web_map.xml");
		
		try {
			
			StringBuilder sb = new StringBuilder();
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
	        Document doc = builder.parse(file);
	        
	        Element root = doc.getDocumentElement();	// <current xmlns="current"> 태그
	        Element weather = (Element)root.getElementsByTagName("weather").item(0);	// <weather hour="15" day="18" month="08" year="2022">
	        sb.append(weather.getAttribute("year") + "년 ");
	        sb.append(weather.getAttribute("month") + "월 ");
	        sb.append(weather.getAttribute("day") + "일 ");
	        sb.append(weather.getAttribute("hour") + "시\n");
	        
	        NodeList locals = root.getElementsByTagName("local");
	        for(int i = 0; i < locals.getLength(); i++) {
	        	Element local = (Element)locals.item(i);
	        	sb.append(local.getTextContent() + ":");
	        	sb.append(local.getAttribute("ta") + "℃");
	        	sb.append(local.getAttribute("desc") + "\n");
	        }
	        
	        System.out.println(sb.toString());
	        
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {

		m10();

	}

}
