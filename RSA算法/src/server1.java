import java.util.*;
import java.io.*;
import java.net.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
public class server1 {
	public static void main(String[] args ) {
		String huifu=null;
		//Scanner in=new Scanner(System.in);
		ServerSocket fwdsocket=null;
		Socket socket2=null;
		 DataInputStream input =null;
		 DataOutputStream output=null;
		 try {
			 fwdsocket=new ServerSocket(5000);//初始化服务端端口
			 socket2=fwdsocket.accept(); //建立连接 ,此端口处于阻塞状态，除非客户端呼叫
			 output=new DataOutputStream(socket2.getOutputStream());
			 input=new DataInputStream(socket2.getInputStream());
			 while(true) {
				 
				 System.out.println("等待对方发送消息");
				 String s=input.readUTF();
				 //System.out.println("对方发来信息"+s);
				 //huifu=in.nextLine();
				 //output.writeUTF(huifu);
					// 公钥私钥中用到的两个大质数p,q'''
					//BigInteger p = new BigInteger("106697219132480173106064317148705638676529121742557567770857687729397446898790451577487723991083173010242416863238099716044775658681981821407922722052778958942891831033512463262741053961681512908218003840408526915629689432111480588966800949428079015682624591636010678691927285321708935076221951173426894836169") ;
					//BigInteger q = new BigInteger("144819424465842307806353672547344125290716753535239658417883828941232509622838692761917211806963011168822281666033695157426515864265527046213326145174398018859056439431422867957079149967592078894410082695714160599647180947207504108618794637872261572262805565517756922288320779308895819726074229154002310375209") ;
					BigInteger p = new BigInteger("103") ;
					BigInteger q = new BigInteger("101") ;
					RSA rsa = new RSA() ;
				    // 生成公钥私钥'''
				    // pubkey, selfkey = gen_key(p, q)
				    BigInteger[][] keys = rsa.genKey(p, q) ;
				    BigInteger[] pubkey  = keys[0] ;
				    BigInteger[] selfkey = keys[1] ;
				    
				    // 需要被加密的信息转化成数字，长度小于秘钥n的长度，如果信息长度大于n的长度，那么分段进行加密，分段解密即可。'''
				    //BigInteger m = new BigInteger("1356205320457610288745198967657644166379972189839804389074591563666634066646564410685955217825048626066190866536592405966964024022236587593447122392540038493893121248948780525117822889230574978651418075403357439692743398250207060920929117606033490559159560987768768324823011579283223392964454439904542675637683985296529882973798752471233683249209762843835985174607047556306705224118165162905676610067022517682197138138621344578050034245933990790845007906416093198845798901781830868021761765904777531676765131379495584915533823288125255520904108500256867069512326595285549579378834222350197662163243932424184772115345") ;
				    BigInteger m = new BigInteger(s) ;
				    System.out.println("被加密信息：" + m);
				    // 信息加密'''
				    BigInteger c = rsa.encrypt(m, pubkey) ;
				    System.out.println("公钥为"+keys[0][0]+","+keys[0][1]);
				    System.out.println("私钥为"+keys[1][0]+","+keys[1][1]);
				    System.out.println("密文：" + c);
				    // 信息解密'''
				    BigInteger d = rsa.decrypt(c, selfkey) ;
				    System.out.println("被解密后信息：" + d);
				 Thread.sleep(500);
			 
			 }
			 
			 
			 
		 }
		 catch(Exception e) {
			 
		 }
	}
}
