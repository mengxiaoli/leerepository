package cn.itcast.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class HelloService {
	public String sayHello(String name){
		//return "hello"+name;
		return "what"+name;
	}
	@WebMethod(exclude=true)
	public String sayHello2(String name){
		return "hello"+name;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub /**
       /* * 参数1：服务的发布地址
        * 参数2：服务的实现者
        *  Endpoint  会重新启动一个线程
        */
		Endpoint.publish("http://192.168.1.108:6781/hello", new HelloService());
		System.out.println("Server ready...");
		//Endpoint 会启动一个新的线程
	}

}
