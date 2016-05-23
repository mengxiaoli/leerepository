package cn.it.cast.ws.urlConnection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import java.net.URL;

public class App {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		URL wsUrl=new URL("http://192.168.1.108/hello");
		HttpURLConnection conn = (HttpURLConnection)wsUrl.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
		OutputStream os =conn.getOutputStream();
		String soap="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:q0=\"http://ws.itcast.cn/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" + 
									 " <soapenv:Body> <q0:sayHello><arg0>aa</arg0>  </q0:sayHello> </soapenv:Body> </soapenv:Envelope>";
	    os.write(soap.getBytes());//�����ͨ�������巢�ͳ�ȥ
	    InputStream is =conn.getInputStream();//����˷������ݣ�������
	    byte[] b= new byte[1024];
	    int len=0;
	    String s="";
	    //����ʹ��read()����һ�ζ�ȡһ���ֽڣ������������int���ͷ���
	    while((len=is.read(b)) !=-1){
	    	String ss = new String(b,0,len,"UTF-8");
	    	s+=ss;
	    }
	    System.out.println(s);
	    is.close();
	    os.close();
	    conn.disconnect();
	}

}
