package cn.netty;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IOServer {
    public static void main(String[] args) throws IOException {
        ExecutorService esThreadPool=Executors.newCachedThreadPool();
        ServerSocket server=new ServerSocket(50000);
        System.out.println("微冷的雨服务器启动");
        while(true){
            //获取一个套接字 阻塞
            final Socket socket=server.accept();
            System.out.println("一个新客户端");
            esThreadPool.execute(new Runnable() {
                public void run() {
                    handler(socket);
                }
            });
        }
    }

    protected static void handler(Socket socket) {
        byte[] bytes=new byte[1024];
        try {
            InputStream inputStream=socket.getInputStream();
            while (true) {
                int read = inputStream.read(bytes);
                if(read!=-1){
                    System.out.println(new String(bytes,0,read));
                }else{
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                System.out.println("socket关闭");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
