import java.util.*;
import java.io.*;
import java.net.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
public class client1 {
	 public static void main(String args[]) {
		 Socket socket1;
		 Scanner in=new Scanner(System.in);
		 String fasong=null;
		 DataInputStream input =null;
		 DataOutputStream output=null;
		 try { 
			 socket1=new Socket("127.0.0.1",5000);
			 input=new DataInputStream(socket1.getInputStream());
			 output=new DataOutputStream(socket1.getOutputStream());
			 while(true) {
				 fasong=in.nextLine();
				 output.writeUTF(fasong);
				 //String s=input.readUTF();
				 //System.out.println("对方的回答是"+s);
				 
				 Thread.sleep(500);
			 }
			 
		
		 }catch (Exception e) {
			 System.out.println("服务器断开"+e);}
	 }
}
