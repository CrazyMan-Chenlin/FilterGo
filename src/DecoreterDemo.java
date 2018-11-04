import java.io.*;

public class DecoreterDemo {
    //װ����ģʽdemo
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
  * װ����ģʽ����ͬ�ڴ���ģʽ  ����ģʽ��ֱ����д��������װ����ģʽ�Ǽ�ǿ����
  *            ��дһ��װ������ȥװ�α�װ�ε��ࣨ���磺BufferReader�� ����̳�BufferReader
  *            װ�����ж���һ����Ա�������������ձ�װ�εĶ���
  *            ���幹�췽�������뱻װ���࣬�ó�Ա������
  *            ��д���������뷽����ǿ
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