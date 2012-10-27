package client;

import java.rmi.RemoteException;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
/**
 * 访问URL：http://localhost:8080/axis/services，页面将返回server端暴露的webservice所有服务 
 * @author jack
 */
public class BaseHandlerClient{
	
	 public static void main(String[] args) {
		 String ret =null;
		 try {
			 String url = "http://localhost:8080/axis/services/baseHandlerService?wsdl";
			 Service service = new Service();
			 Call call = (Call) service.createCall();// 通过service创建call对象
			 call.setTargetEndpointAddress(new java.net.URL(url));//设置call对象的目标端点地址(调用的目标url地址)
			 call.setOperationName(new QName("handle"));//设置调用的方法,在wsdl中描述为操作(input,output)
			 ret = (String) call.invoke(new Object[] {"传给方法的参数，相当于wsdl中input"});
			 System.out.println("返回值===" + ret);//方法返回值，相当于wsdl中output
		 } catch (RemoteException e) {
			 e.printStackTrace();
		 } catch (Exception e){
			 e.printStackTrace();
		 }
	 }
}

