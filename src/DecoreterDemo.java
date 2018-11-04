import java.io.*;

public class DecoreterDemo {
    //装饰者模式demo
    public static void main(String[] args) throws Exception {
        //oldMethod();
        BufferedReader br=new BufferedReader(new FileReader("D:/username.txt"));
        BufferedReader br2=new MyBufferReader(br);
        String str=null;
        while((str=br2.readLine())!=null){
            System.out.println(str);
        }
    }

    private static void oldMethod() throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("D:/username.txt"));
        String str=null;
        while((str=br.readLine())!=null){
            System.out.println(str);
        }
    }
}
  /*
  * 装饰者模式，不同于代理模式  代理模式是直接重写方法，而装饰者模式是加强方法
  *            编写一个装饰者类去装饰被装饰的类（例如：BufferReader） 该类继承BufferReader
  *            装饰类中定义一个成员变量，用来接收被装饰的对象
  *            定义构造方法，传入被装饰类，用成员变量接
  *            重写方法，对齐方法加强
  * */
     class MyBufferReader extends BufferedReader{
      BufferedReader br;
        int count=1;
      public MyBufferReader(Reader in) {
          super(in);
          this.br=(BufferedReader)in;
      }
      public String readLine() throws IOException {
          String str=br.readLine();
          if(str!=null) {
              str = count + ":" + str;
              count++;
          }
          return str;
      }
  }